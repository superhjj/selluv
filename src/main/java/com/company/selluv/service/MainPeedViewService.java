package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.vo.MainPeedViewVO;

public interface MainPeedViewService {

	List<MainPeedViewVO> mainPeedViewSearch(String memberId);
	
	MainPeedViewVO mainPeedViewByContentsCodeSearch(String contentCode);
	
}
