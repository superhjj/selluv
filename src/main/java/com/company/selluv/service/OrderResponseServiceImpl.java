package com.company.selluv.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.FormResponseDTO;
import com.company.selluv.domain.dto.OrderMemberDTO;
import com.company.selluv.persistence.OrderResponseMapper;

@Service
public class OrderResponseServiceImpl implements OrderResponseService {

	@Autowired
	private OrderResponseMapper orderResponseMapper;
	private static final Logger logger = LoggerFactory.getLogger(OrderResponseServiceImpl.class);

	
	@Override
	public boolean orderResponseListDelete(String formResponseCode) {
		// TODO Auto-generated method stub
		try {
			orderResponseMapper.deleteOrderResponseList(formResponseCode);
			return true;
		} catch (Exception e) {
			logger.error("orderResponseListDelete 에러");
		}
		return false;
	}

	@Override
	public boolean orderResponseDelete(String formCode, int flag) {
		// TODO Auto-generated method stub
		try {
				orderResponseMapper.deleteOrderResponse(formCode);
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("orderResponseDelete error");
		}

		return false;
	}

	@Override
	public FormResponseDTO orderResponseSearch(String formResponseCode) {
		// TODO Auto-generated method stub
		try {
			FormResponseDTO dto = orderResponseMapper.searchOrderResponseCode(formResponseCode);
			return dto;
		} catch (Exception e) {
			logger.error("formResponseCode로 orderResponseSearch 에러");
		}
		return null;
	}

	@Override
	public List<FormResponseDTO> orderResponseSearch(String formCode, int flag) {
		// TODO Auto-generated method stub
		try {
			List<FormResponseDTO> list = orderResponseMapper.searchOrderResponseForm(formCode);
			return list;
		} catch (Exception e) {
			logger.error("formCode로 orderResponseSearch 에러");
		}
		return null;
	}

	@Override
	public boolean orderMemberDelete(String memberId) {
		// TODO Auto-generated method stub
		try {
			orderResponseMapper.deleteOrderMemberByMember(memberId);
			return true;
		} catch (Exception e) {
			logger.error("memberId로 orderMemberDelete 에러");
		}
		return false;
	}

	@Override
	public boolean orderMemberDelete(String orderMemberCode, int flag) {
		try {
			orderResponseMapper.deleteOrderMemberByCode(orderMemberCode);
			return true;
		} catch (Exception e) {
			logger.error("orderMemberCode로 orderMemberDelete 에러");
		}
		return false;
	}

	@Override
	public List<OrderMemberDTO> orderMemberSearch(String memberId) {
		// TODO Auto-generated method stub
		try {
			List<OrderMemberDTO> list  = orderResponseMapper.searchOrderMemberByMember(memberId);
			return list;
		} catch (Exception e) {
			logger.error("memberId로 orderMemberSearch 에러");
		}
		return null;
	}

	@Override
	public OrderMemberDTO orderMemberSearch(String orderMemberCode, int flag) {
		// TODO Auto-generated method stub
		try {
			OrderMemberDTO dto  = orderResponseMapper.searchOrderMemberByCode(orderMemberCode);
			return dto;
		} catch (Exception e) {
			logger.error("memberId로 orderMemberSearch 에러");
		}
		return null;
	}

}
