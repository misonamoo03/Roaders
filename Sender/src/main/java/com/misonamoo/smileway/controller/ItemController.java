package com.misonamoo.smileway.controller;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.misonamoo.smileway.domain.ItemPageMaker;
import com.misonamoo.smileway.domain.ItemVO;
import com.misonamoo.smileway.domain.SearchCriteria;
import com.misonamoo.smileway.service.ItemService;
import com.misonamoo.smileway.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
public class ItemController {
	
	@Inject
	private ItemService itemService;
	
	//@Resource(name="uploadPath")
		//private String uploadPath = "C:\\Users\\HeeHyun\\Desktop\\가는길에@\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TeamDelivery\\resources";


	//private String uploadPath = "C:\\workspace\\spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\delivery\\resources";
	private String uploadPath = "C:\\Users\\User\\Desktop\\new project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TeamDelivery\\resources";


	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	//상품 등록
	@RequestMapping(value="/regist", method = RequestMethod.GET)
	public String regist(Model model) throws Exception {
		
		//카테고리 조회하기 위해서 쓰는것
		List<ItemVO> catagoryList = null;
		catagoryList = itemService.catagoryList();
		model.addAttribute("catagoryList", JSONArray.fromObject(catagoryList));
		return "/item/regist";
	}
	
	//상품 등록
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registItem(ItemVO vo, @RequestParam("file") MultipartFile file)throws Exception {
		
		logger.info(uploadPath);
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		vo.setITEM_PICTURE(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setITEM_PICTURE_Thum(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		itemService.registItem(vo);
		
		return "redirect:/item/itemList";
		
	}
	
	//카테고리 조회
	@RequestMapping(value="/catagory", method = RequestMethod.GET)
	public String getcatagoryList(Model model)throws Exception {
		
		logger.info("show catagory.............");
		
		List<ItemVO> list = itemService.catagoryList();
		
		model.addAttribute("list",list);
		
		return "/item/catagory";
	}
	
	//카테고리 등록
	@RequestMapping(value="/catagory", method = RequestMethod.POST)
	public String insertCatagory(ItemVO item) throws Exception {
		
		itemService.registCatagory(item);
		return "redirect:/item/catagory";
		
		
	}
	
	/**
	//상품 조회 페이지(검색 기능 전)
	@RequestMapping(value ="/item/itemList", method = RequestMethod.GET)
	public String listItem(Model model, Criteria cri)throws Exception{
		logger.info("itemlist.......");
		
		List<ItemVO> list = itemService.listItem(cri);
		model.addAttribute("list",list);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(itemService.countItem(cri));
		model.addAttribute("pageMaker",pageMaker);
		
		return "item/itemList";
	}
	*/
	
	// 검색 기능 추가 상품 조회
	@RequestMapping(value ="/itemList", method = RequestMethod.GET)
	public String listItem(Model model, @ModelAttribute("cri") SearchCriteria cri)throws Exception{
		logger.info("itemlist.......");
		logger.info(cri.toString());
		
		List<ItemVO> list = itemService.listItem(cri);
		model.addAttribute("list",list);
		ItemPageMaker pageMaker = new ItemPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(itemService.countItem(cri));
		model.addAttribute("pageMaker",pageMaker);
		
		return "item/itemList";
	}
	
	//상품 수정하기 페이지 호출(조회용)
	@RequestMapping(value="/item/itemRead",method=RequestMethod.GET)
	public String itemRead(@RequestParam("ITEM_NO") int ITEM_NO, Model model)throws Exception {
		logger.info("get Item info");
		
		ItemVO item = itemService.itemRead(ITEM_NO);
		model.addAttribute("item",item);
		
		//카테고리 조회하기 위해서 쓰는것
		List<ItemVO> catagoryList = null;
		catagoryList = itemService.catagoryList();
		model.addAttribute("catagoryList", JSONArray.fromObject(catagoryList));
		
		return "item/modify";
	}
	
	//상품 수정 처리
	@RequestMapping(value="/item/modify", method=RequestMethod.POST)
	public String modifyItem(ItemVO vo,@RequestParam("file") MultipartFile file, HttpServletRequest req)throws Exception{
		
		logger.info("update item info......");
		
		 // 새로운 파일이 등록되었는지 확인
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 기존 파일을 삭제
		  new File(uploadPath + req.getParameter("ITEM_PICTURE")).delete();
		  new File(uploadPath + req.getParameter("ITEM_PICTURE_Thum")).delete();
		  
		  // 새로 첨부한 파일을 등록
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  vo.setITEM_PICTURE(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  vo.setITEM_PICTURE_Thum(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 새로운 파일이 등록되지 않았다면
		  // 기존 이미지를 그대로 사용
		  vo.setITEM_PICTURE(req.getParameter("ITEM_PICTURE"));
		  vo.setITEM_PICTURE_Thum(req.getParameter("ITEM_PICTURE_Thum"));
		  
		 }
		
		itemService.modifyItem(vo);
		logger.info("update item info......");
		return "redirect:/item/itemList";
	}
	
	//상품 삭제하기
	@RequestMapping(value = "/item/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public String removeItemList(@RequestParam("ITEM_NO") int ITEM_NO)throws Exception {
		
		logger.info("delete List......");
		
		itemService.removeItemList(ITEM_NO);
		return "redirect:/item/itemList";
	}
	
	
}
