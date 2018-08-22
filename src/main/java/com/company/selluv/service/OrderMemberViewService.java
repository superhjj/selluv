package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.vo.OrderMemberViewVO;

public interface OrderMemberViewService {
	public List<OrderMemberViewVO> orderMemberViewSearch(String form_code);
}
