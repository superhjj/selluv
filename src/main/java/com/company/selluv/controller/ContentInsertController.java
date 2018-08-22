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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.service.ContentService;

@Controller
public class ContentInsertController {

	private static final Logger logger = LoggerFactory.getLogger(ContentInsertController.class);
	
	@Autowired
	ContentService service;
	
	@RequestMapping(value="/contentInsert.do", method=RequestMethod.POST)
	public String contentInsert(MultipartFile file, Model model, HttpSession session
			,@RequestParam("addcontents_text") String contentText,
			RedirectAttributes redirectAttributes
	) 
	{
		//��� �ٲٱ�
		//C:\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\Selluv\resources\image
		String path="C:\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\Selluv\\resources\\image\\content";
		String memberId = (String)session.getAttribute("memberId");
		String contentImg = null;
		try {
		 contentImg = file.getOriginalFilename();
		}
		catch(Exception e) {
			logger.error("contentInsert : ����  �о���� ����");
	         e.printStackTrace();
	         //return ��
		}
		//String newFilename = uploadFile(file.getOriginalFilename(),file.getBytes(),vo.getWriter());
	
	      ContentDTO dto;
	      if(contentText == null || contentText.length() == 0) {
	    	  dto = service.contentAddImgNoneContext(contentImg, memberId);
	      }
	      
	      else {
	         dto = service.contentAddImg(contentText, contentImg, memberId);
	      }
	      
	      if(dto != null) {
	    	logger.info("contentInsert : ������ ��� ����");
	    	redirectAttributes.addAttribute("job","searchContentList");
	    	redirectAttributes.addAttribute("id", memberId);
	    	return "redirect:userPeedView.do";
	      }
	      logger.info("contentInsert : ������ ��� ����");
		return null;//����!!
	}
}
