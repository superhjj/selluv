package com.company.selluv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.OrderMemberViewVO;
import com.company.selluv.persistence.OrderMemberViewMapper;

@Service
public class OrderMemberViewServiceImpl implements OrderMemberViewService{
	
	@Autowired
	OrderMemberViewMapper orderMemberViewMapper;
	
	@Override
	public List<OrderMemberViewVO> orderMemberViewSearch(String form_code){
		return orderMemberViewMapper.searchOrderMemberView(form_code);
	}
}
