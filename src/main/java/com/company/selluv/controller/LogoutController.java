package com.company.selluv.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.selluv.service.MemberService;

@Controller
public class LogoutController {
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		
		if(session!=null && session.getAttribute("memberId")!=null){
			session.invalidate();
			logger.info("�α׾ƿ�");
		}
		return "login";
		
	}
}
