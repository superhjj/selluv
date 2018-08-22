package com.company.selluv.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.service.MemberService;

@Controller
public class MemberDeleteController {
	public static final Logger logger= LoggerFactory.getLogger(MemberDeleteController.class);
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="memberDelete.do", method=RequestMethod.POST)
	public String memberDelete(HttpSession session, @RequestParam("id")String memberId,@RequestParam("pwd")String pwd, Model model) {
		String sessionId = (String) session.getAttribute("memberId");
		
		MemberDTO sessionDTO = service.memberSearch(sessionId, 1);
		MemberDTO memberDTO = service.memberSearch(memberId, pwd);
		
		String path=null;
		if(sessionDTO == null) {
			logger.info("��α��� ����");
			path="";//?????????????
			return path;
		}
		
		if(memberDTO == null && !sessionDTO.getLevelCode().equals("AD")){
			logger.info("��й�ȣ ��ġ���� ����");
			model.addAttribute("error", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			path="";//?????????????
			return path;
		}
		
		service.memberDelete(memberId, pwd);
		if(sessionDTO.getLevelCode().equals("AD"))
		{
			path="";
		}
		else if(memberDTO != null) {
			path="";
		}
		return path;
		
	}
}
