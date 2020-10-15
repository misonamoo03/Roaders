package com.misonamoo.smileway.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.misonamoo.smileway.domain.LocationVO;
import com.misonamoo.smileway.domain.PageMaker;
import com.misonamoo.smileway.service.LocationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LocationManController {
   
   private static final Logger logger = LoggerFactory.getLogger(LocationManController.class);
   @Inject
   private LocationService locationService;
   
   //장소입력화면
   @RequestMapping(value="/locationinsert", method = RequestMethod.GET)
   public String locationInsertPage() {
      return "location/locationInsert";
   }
   //입력처리
   @RequestMapping(value="/insertLocation", method = RequestMethod.POST)
   public String locationInsert(@ModelAttribute LocationVO vo) throws Exception {
      locationService.insertLocation(vo);
      return "location/locationList";
   }
   @RequestMapping(value="/location/locationUpdate", method = RequestMethod.GET)
   public String locationUpdatePage(@ModelAttribute LocationVO vo, Model model) throws Exception {
      LocationVO  resultLocation = new LocationVO(); 
      if(vo.getLocationNumber() != null && Integer.parseInt(vo.getLocationNumber()) > 0) {
         resultLocation = locationService.selectLocation(vo.getLocationNumber());
      }
      
      model.addAttribute("location",resultLocation);
      
      return "location/locationUpdate";
   }
   
   @RequestMapping(value="/updateLocation", method = RequestMethod.POST)
   public String locationUpdate(@ModelAttribute LocationVO vo, Model model) throws Exception {
      locationService.updateLocation(vo);
      LocationVO  resultLocation = new LocationVO(); 
      resultLocation = locationService.selectLocation(vo.getLocationNumber());
      model.addAttribute("location",resultLocation);
      return "redirect: /location/locationList";
   }
   //리스트(리드)
   @RequestMapping(value="/locationList", method = RequestMethod.GET)
   public String locationListPage(@ModelAttribute LocationVO vo, Model model) throws Exception {
      
      model.addAttribute("list", locationService.listLocation(vo));
      PageMaker pageMaker = new PageMaker(); 
      pageMaker.setCri(vo); // setCri 
      pageMaker.setTotalCount(locationService.listCountLocation(vo));

      model.addAttribute("pageMaker", pageMaker);
      return "location/locationList";
   }
   
   //삭제
   @RequestMapping(value = "/remove", method = {RequestMethod.GET ,RequestMethod.POST})
   public String removePOST(@RequestParam("locationNumber") int locationNumber, RedirectAttributes rttr) throws Exception {
      
      locationService.remove(locationNumber);
      logger.info("Delete.ARGS_FIELD_NUMBER....");
      return "redirect:/location/locationList";
   }
   
   //팝업 - 출발
   @RequestMapping(value="/locationPopup", method = RequestMethod.GET)
   public String locationPopup(@ModelAttribute LocationVO vo, Model model) throws Exception {
      model.addAttribute("list", locationService.listLocation(vo));
      
      return "location/locationPopup";
   }
   
 //팝업 - 도착
   @RequestMapping(value="/locationArrivalPopup", method = RequestMethod.GET)
   public String locationArrivalPopup(@ModelAttribute LocationVO vo, Model model) throws Exception {
      model.addAttribute("list", locationService.listLocation(vo));
      
      return "location/locationArrivalPopup";
   }
}