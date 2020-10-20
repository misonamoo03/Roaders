package com.misonamoo.smileway.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.misonamoo.smileway.controller.DeliveryController;
import com.misonamoo.smileway.domain.UserVO;
 
public class CommonUtil {
  private static HashMap<String, Properties> propses;
  private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);
 
 
   
  
  public static UserVO cookieUserInfo(HttpServletRequest req){
	  HttpSession session = req.getSession();		
	UserVO login = (UserVO)session.getAttribute("User");
	
	if(login != null && login.getSUSER_ID() != null ) {	
		return login;			
	}else {
		return null;
	}
    
  }
   
 
}
