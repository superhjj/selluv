package com.company.selluv.domain.dto;

public class OrderMemberDTO {
	private String orderMemberCode;
	private String formResponseCode;
	private String memberId;
	private String orderDate;
	
	public OrderMemberDTO(){
	}
	public OrderMemberDTO(String orderMemberCode, String formResponseCode, String memberId, String orderDate) {
		super();
		this.orderMemberCode = orderMemberCode;
		this.formResponseCode = formResponseCode;
		this.memberId = memberId;
		this.orderDate = orderDate;
	}

	public String getOrderMemberCode() {
		return orderMemberCode;
	}

	public void setOrderMemberCode(String orderMemberCode) {
		this.orderMemberCode = orderMemberCode;
	}

	public String getFormResponseCode() {
		return formResponseCode;
	}

	public void setFormResponseCode(String formResponseCode) {
		this.formResponseCode = formResponseCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderMemberDTO [orderMemberCode=" + orderMemberCode + ", formResponseCode=" + formResponseCode
				+ ", memberId=" + memberId + ", orderDate=" + orderDate + "]";
	}
	
	
}
