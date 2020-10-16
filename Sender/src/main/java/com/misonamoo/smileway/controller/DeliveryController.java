package com.misonamoo.smileway.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.misonamoo.smileway.domain.ItemVO;
import com.misonamoo.smileway.domain.SearchCriteria;
import com.misonamoo.smileway.domain.UserVO;
import com.misonamoo.smileway.domain.DeliveryVO;
import com.misonamoo.smileway.domain.ItemPageMaker;
import com.misonamoo.smileway.domain.ItemVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.ReviewVO;
import com.misonamoo.smileway.domain.SearchCriteria;
import com.misonamoo.smileway.service.DeliveryService;
import com.misonamoo.smileway.service.ItemService;
import com.misonamoo.smileway.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
public class DeliveryController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);
	
	@Inject
	private DeliveryService deliveryService;
	@Inject
	private ItemService itemService;
	
	//@Resource(name="uploadPath")


	private String uploadPath = "C:\\workspace\\spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\delivery\\resources";

	//C:\Users\User\Desktop\new project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\TeamDelivery\resources
	//private String uploadPath = "C:\\Users\\User\\Desktop\\new project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TeamDelivery\\resources";

	
	@RequestMapping(value="/delivery/regist", method = RequestMethod.GET)
	public String regist(Model model) throws Exception {
		
		//카테고리 조회하기 위해서 쓰는것
		List<ItemVO> catagoryList = null;
		catagoryList = itemService.catagoryList();
		model.addAttribute("catagoryList", JSONArray.fromObject(catagoryList));
		
		return "/delivery/regist";
	}
	
	@RequestMapping(value="/delivery/regist", method = RequestMethod.POST)
	public String registDelItem(DeliveryVO deliveryVO,
			@RequestParam("file") MultipartFile file) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		deliveryVO.setDEL_CONTENT_PICTURE(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		deliveryVO.setDEL_CONTENT_PICTURE_Thum(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		deliveryService.registDelItem(deliveryVO);
		deliveryService.registDelLocationDepart(deliveryVO);
		deliveryService.registDelLocationArrival(deliveryVO);
		deliveryService.registDelInfo(deliveryVO);
		deliveryService.registDelMethod(deliveryVO);
		
		return "redirect:/delivery/list";
	}
	
	@RequestMapping(value="/deliveryList", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("cri") @RequestBody SearchCriteria cri,
			HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		HttpSession session = req.getSession();
		
		UserVO login = (UserVO)session.getAttribute("User");
		
		if(login != null && login.getSUSER_ID() != null ) {
			
			cri.setSuserId(login.getSUSER_ID());
			
		}
		
		ItemPageMaker pageMaker = new ItemPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(deliveryService.countDelivery(cri));
		model.addAttribute("pageMaker",pageMaker);
		
		List<DeliveryVO> list = deliveryService.deliveryList(cri);		
		model.addAttribute("list",list);
		
		for(int i=0; i<list.size(); i++) {
			DeliveryVO deliveryVO = list.get(i);
			System.out.println(deliveryVO.getDELIVERY_NUMBER());
		}
		
		return "/delivery/list";
	}
	
	
	@RequestMapping(value="/deliveryDetail/{DELIVERY_NUMBER}", method = RequestMethod.GET)
	public String detail(@PathVariable("DELIVERY_NUMBER") int DELIVERY_NUMBER,
			DeliveryVO deliveryVO, 
			RUserVO ruserVO, Model model) throws Exception {
		
		deliveryVO = deliveryService.deliveryDetail(DELIVERY_NUMBER);
		model.addAttribute("d", deliveryVO);
		
		ruserVO = deliveryService.deliveryRoder(DELIVERY_NUMBER);
		model.addAttribute("r", ruserVO);
		
		return "/delivery/detail";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(DeliveryVO deliveryVO, int DELIVERY_NUMBER, Model model) throws Exception {
		
		//카테고리 조회하기 위해서 쓰는것
		List<ItemVO> catagoryList = null;
		catagoryList = itemService.catagoryList();
		model.addAttribute("catagoryList", JSONArray.fromObject(catagoryList));
        
		deliveryVO = deliveryService.deliveryDetail(DELIVERY_NUMBER);
		model.addAttribute("d", deliveryVO);
		
		return "/delivery/edit";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String edit(DeliveryVO deliveryVO, 
			@RequestParam("file") MultipartFile file,
			HttpServletRequest req) throws Exception {
		
		// 새로운 파일이 등록되었는지 확인
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		
			// 기존 파일을 삭제
			new File(uploadPath + req.getParameter("DEL_CONTENT_PICTURE")).delete();
			new File(uploadPath + req.getParameter("DEL_CONTENT_PICTURE_Thum")).delete();
		  
			// 새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
			deliveryVO.setDEL_CONTENT_PICTURE(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			deliveryVO.setDEL_CONTENT_PICTURE_Thum(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
	  
		} else {  // 새로운 파일이 등록되지 않았다면
			// 기존 이미지를 그대로 사용
			deliveryVO.setDEL_CONTENT_PICTURE(req.getParameter("DEL_CONTENT_PICTURE"));
			deliveryVO.setDEL_CONTENT_PICTURE_Thum(req.getParameter("DEL_CONTENT_PICTURE_Thum"));
		}
		            
		deliveryService.updateDelItem(deliveryVO);
		deliveryService.updateDelLocationDepart(deliveryVO);
		deliveryService.updateDelLocationArrival(deliveryVO);
		deliveryService.updateDelInfo(deliveryVO);
		deliveryService.updateDelMethod(deliveryVO);
		
		return "redirect:/delivery/list";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(int DELIVERY_NUMBER, Model model) throws Exception {
		
		deliveryService.deleteDelItem(DELIVERY_NUMBER);
		deliveryService.deleteDelLocation(DELIVERY_NUMBER);
		deliveryService.deleteDelInfo(DELIVERY_NUMBER);
		
		return "redirect:/deliveryList";
	}
	

	
	
	//상품 목록 팝업
	@RequestMapping(value = "/delivery/itemList", method = RequestMethod.GET)
	public String openItemListPop(Model model)throws Exception{
		
		//카테고리 조회하기 위해서 쓰는것
		List<ItemVO> catagoryList = null;
		catagoryList = itemService.catagoryList();
		model.addAttribute("catagoryList", JSONArray.fromObject(catagoryList));
		
		List<ItemVO> list = itemService.listItemPop();
		model.addAttribute("list",list);
		
		return "/delivery/ItemListPop";
	}
	
	/**
	 * 로더 지원 목록 팝업
	 * @param	RUserVO vo
	 * @param	model
	 * @return	/delivery/RoaderApplyPop
	 * @throws	Exception
	 */
	@RequestMapping(value = "/delivery/RoaderApplyPop",method = RequestMethod.GET)
	public String openApplyRoaderPop(@ModelAttribute RUserVO vo, Model model)throws Exception{
		
		logger.info(vo.toString());
		List<RUserVO> list = deliveryService.openApplyRoaderPop(vo);		
		model.addAttribute("list",list);
			
		return "/delivery/RoaderApplyPop";
	}

	//픽업 요청 메세지 팝업
	@RequestMapping(value = "/delivery/RequestPickUp", method = RequestMethod.GET)
	public String openRequestPickUpPop(DeliveryVO deliveryVO)throws Exception{
		
		return "/delivery/RequestPickUpPop";
	}
	
	/**
	 * 픽업 요청 메세지 팝업
	 * @param	DeliveryVO deliveryVO
	 * @return	/delivery/RequestPickUpPop
	 * @throws	Exception
	 */
	@RequestMapping(value = "/delivery/RequestPickUp", method = RequestMethod.POST)
	public String requestPickUp(DeliveryVO deliveryVO) throws Exception{
		
		//DEL_STATE_HISTORY 픽업요청 히스토리 추가
		deliveryService.regRequestPickUp(deliveryVO);
		
		//DELIVERY_MAN 배송상태 수정
		deliveryService.updateDelRequestPickUp(deliveryVO);
		
		//DELIVERY_CANDIDATE 배송상태 수정
		deliveryService.updateRoderRequestPickUp(deliveryVO);
		
		return "/delivery/RequestPickUpPop";
	}
	
	
	@RequestMapping(value = "/delivery/pickUpApproval", method = RequestMethod.GET)
	public String openPickUpAprovalPop(DeliveryVO deliveryVO) throws Exception{
			
		return "/delivery/PickUpApprovalPop";
	}
	
	@RequestMapping(value = "/delivery/aprovalPickUp", method = RequestMethod.POST)
	public String aprovalPickUp(DeliveryVO deliveryVO) throws Exception{
		
		//DEL_STATE_HISTORY 픽업 승인 히스토리 추가
		deliveryService.regApprovePickUp(deliveryVO);
		
		//DELIVERY_MAN 배송상태 수정
		deliveryService.updateApprovePickUp(deliveryVO);
		
		return "/delivery/PickUpApprovalPop";
	}
	
	
	//구매 확정 및 평가 팝업
	@RequestMapping(value = "/delivery/confirm", method = RequestMethod.GET)
	public String openConfirmPurchasePop()throws Exception{
		
		return "/delivery/ConfirmPurchasePop";
	}
	
	//구매 확정 및 평가 팝업
	@RequestMapping(value = "/delivery/confirm", method = RequestMethod.POST)
	public String registPickupReview(DeliveryVO deliveryVO) throws Exception{
		
		//REVIEW_MAN 등록
		deliveryService.registTotalReview(deliveryVO);
		//DETAIL_REVIEW_MAN 친절평점 등록
		deliveryService.registKindlyReview(deliveryVO);
		//DETAIL_REVIEW_MAN 약속평점 등록
		deliveryService.registPromiseReview(deliveryVO);
		//DETAIL_REVIEW_MAN 속도평점 등록
		deliveryService.registSpeedReview(deliveryVO);
		//REVIEW_MAN - totalStart 업데이트
		deliveryService.updateTotalReview(deliveryVO);
		
		//DEL_STATE_HISTORY 배송완료승인 히스토리 추가
		deliveryService.regConfirmDelHistory(deliveryVO);
		
		//DELIVERY_MAN 배송상태 수정 -> 6으로
		deliveryService.updateConfirmDelHistory(deliveryVO);
		
		return "/delivery/ConfirmPurchasePop";
	}
	
	
	/**
	 * 배송 관리 타임라인 팝업 
	 * @param  DeliveryVO vo
	 * @param  model
	 * @return /delivery/DeliveryHistoryPop
	 * @throws Exception
	 */
	@RequestMapping(value="/delivery/deliHisPop", method= RequestMethod.GET)
	public String openDelHistoryPop(@ModelAttribute DeliveryVO vo,Model model)throws Exception{
		
		//SendUser정보는 그냥 한번만 받으면 되므로,따로 senduser의 정보만 구하도록 하자.
		DeliveryVO sevo = deliveryService.readSuser(vo);
		model.addAttribute("sevo",sevo);
		
		//이쪽은 타임라인이다 배송상태는 1부터 7까지 있으므로 리스트로 받아서 뿌려준다. jsp부분에서 <c:forEach>부분이다.
		List<DeliveryVO> list = deliveryService.delHistory(vo);
		model.addAttribute("list",list);
		
		logger.info(vo.getGRADE_CODE());
		return "/delivery/DeliveryHistoryPop";
	}
}
