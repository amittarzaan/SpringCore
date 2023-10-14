package com.alibou.oauth2.landleasing.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/static/home")
public class LandLeasingLoginWebController {
	  
	 
	  @RequestMapping(method = RequestMethod.GET, produces = "text/html")
		public String viewHomePage() {	
		  return "home";				
			
		}
		
}
