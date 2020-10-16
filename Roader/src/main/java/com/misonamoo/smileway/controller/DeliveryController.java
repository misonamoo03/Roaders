package com.misonamoo.smileway.controller;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.misonamoo.smileway.domain.DeliveryListVO;
import com.misonamoo.smileway.domain.DeliveryVO;
import com.misonamoo.smileway.service.DeliveryService;

@Controller
public class DeliveryController {
	
	private static final Logger logger = LoggerFactory.getLogger(RUserController.class);
	
	@Inject
	private DeliveryService deliveryService;
	
	/**
	 * 운송장 번호 조회 페이지
	 * @return
	 */
	@RequestMapping(value = "/Delivery/Tracking", method = {RequestMethod.GET, RequestMethod.POST} )
	public String startDeliveryTrack() {
		return "Delivery/Tracking";
		
	}
	
	/**
	 * 배송 목록 화면 이동하기 위한 메서드
	 * @return
	 */
	@RequestMapping(value="/Delivery/List", method = RequestMethod.GET)
	public String goDelListPage()throws Exception {
		return "Delivery/List";
	}
	
	/**
	 * 목록 화면 출력 메서드 이 함수가 axios와 통신한다.
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/listAll")
	public List<DeliveryListVO> deliveryList()throws Exception {
		return deliveryService.deliveryList();
	}
	
	/**
	 * 지도찾기 버튼을 눌렀을때 위도와 경도를 구하는 컨트롤러 
	 * List.vue 파일에서 지도찾기 버튼을 누르면 handle_toggle 메서드안에서 /selectPoint url을 갖는 axios를 실행하게 된다.
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/selectPoint", method=RequestMethod.POST)
	
	// axios쪽에서 파람을 받을때는 메서드 전달인자에 @Requestody를 붙여주고 다음과 같이 map이나 뭐 기타등등을 통해 받아준다.
	public List<DeliveryListVO> selectPoint(@RequestBody Map<String, Object> param)throws Exception{
		
		// 배송번호 변수를 만들어서 map에서 key값을 통해 꺼내와서 deliveryNumber 값을 세팅해주는 부분
		String deliveryNumber = param.get("deliveryNumber").toString();
		
		// 이후 미리 ListVO에 deliveryNumber 값을 세팅해준다.
		DeliveryListVO dlvo = new DeliveryListVO();
		dlvo.setDeliveryNumber(deliveryNumber);
		return deliveryService.selectPoint(dlvo);
	}
	

	@RequestMapping(value="/delivery/{deliveryNumber}", method = RequestMethod.GET)
	public String Detail(@PathVariable("deliveryNumber") String deliveryNumber) throws Exception {
		
		
		return "/Delivery/detail";
	}
	
	@ResponseBody
	@RequestMapping(value="/delivery/detail", method = RequestMethod.POST)
	public DeliveryVO deliveryDetail(int deliveryNumber, DeliveryVO deliveryVO) throws Exception {

		deliveryVO = deliveryService.deliveryDetail(deliveryNumber);
		
		System.out.println(deliveryVO);
		return deliveryVO;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delivery/requestDelivery", method = RequestMethod.POST)
	public String requestDelivery(@RequestBody DeliveryVO deliveryVO) throws Exception {

		deliveryService.requestDelivery(deliveryVO);
		deliveryService.deliveryHistory(deliveryVO);
		deliveryService.updateDeliveryState(deliveryVO);
		
		return "/delivery/requestDelivery";
	}

	@RequestMapping(value="/delivery/registPickup", method = RequestMethod.POST)
	public String registPickup(@RequestBody DeliveryVO deliveryVO) throws Exception {

		deliveryService.pickupHistory(deliveryVO);
		deliveryService.updatePickupDelState(deliveryVO);
		
		return "/delivery/registPickup";
	}
	
	@RequestMapping(value="/delivery/completeDelHistory", method = RequestMethod.POST)
	public String complateDelivery(@RequestBody DeliveryVO deliveryVO) throws Exception {

		deliveryService.completeDelHistory(deliveryVO);
		deliveryService.updatecompleteDelState(deliveryVO);
		
		return "/delivery/completeDelHistory";
	}

	@RequestMapping(value="/delivery/reviewDelivery", method = RequestMethod.POST)
	public String reviewDelivery(@RequestBody DeliveryVO deliveryVO) throws Exception {


		deliveryService.reviewTotal(deliveryVO);
		
		deliveryService.reviewKindly(deliveryVO);
		deliveryService.reviewPromise(deliveryVO);
		
		deliveryService.reviewDelState(deliveryVO);
		deliveryService.updateReviewDelState(deliveryVO);
		
		deliveryService.updateTotalReview(deliveryVO);
		
		return "/delivery/reviewDelivery";
	}
	
	
	
	
	
}
