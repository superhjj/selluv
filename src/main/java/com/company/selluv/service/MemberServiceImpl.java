package com.company.selluv.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.persistence.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper member;

	@Override
	public MemberDTO memberAdd(MemberDTO mem) {
		MemberDTO result = null;
		
		try {
			member.addMember(mem);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		result = mem;
		
		return result;
	}

	@Override
	public boolean memberDelete(String member_id, String member_pwd){
		try {
			MemberDTO delete = new MemberDTO();
			delete.setMemberId(member_id);
			delete.setPwd(member_pwd);
			
			member.deleteMember(delete);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<MemberDTO> memberSearch(String name) {
		List<MemberDTO> searchList = null;
		
		try {
			searchList = member.searchMemberByName(name);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return searchList;
	}

	@Override
	public MemberDTO memberSearch(String memberId, int flag) {
		MemberDTO search = null;
		
		try {
			search = member.searchMemberById(memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return search;
	}
	
	/*
	 * memberSearch
	 * member�� ID�� pwd�� �Ű������� �Ѱ��ش�.
	 */
	@Override
	public MemberDTO memberSearch(String memberId, String pwd) {
		// TODO Auto-generated method stub
		MemberDTO search = null;
		try {
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("member_id", memberId);
			map.put("member_pwd", pwd);
			
			search = member.searchMemberByIdAndPwd(map);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return search;
	}
	
	/*
	 * memberIdSearch
	 * member�� mail�� Id�� �˻��Ѵ�.
	 */
	@Override
	public String memberIdSearch(String mail) {
		String memberId = null;
		
		try {
			memberId = member.searchMemberId(mail);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return memberId;
	}
	
	/*
	 * memberPwdSearch
	 * member�� ID�� Mail�� ������ ���� �Ű������� �Ѱܾ� �Ѵ�.
	 */
	@Override
	public String memberPwdSearch(String memberId, String mail) {
		String pwd = null;
		
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("member_id", memberId);
			map.put("member_mail", mail);
			
			pwd = member.searchMemberPwd(map);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return pwd;
	}

	@Override
	public MemberDTO memberLevelCodeUpdate(String memberId, String pwd, String levelCode) {
		// TODO Auto-generated method stub
		MemberDTO result = null;
		
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("member_id", memberId);
			map.put("member_pwd", pwd);
			map.put("level_code", levelCode);
			
			member.updateMemberLevelCode(map);
			result = member.searchMemberById(memberId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}

	@Override
	public MemberDTO memberRangeCodeUpdate(String memberId, String pwd, String rangeCode) {
		MemberDTO result = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("member_id", memberId);
		map.put("member_pwd", pwd);
		map.put("range_code", rangeCode);
		
		try {
			member.updateMemberRangeCode(map);
			result = member.searchMemberById(memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public MemberDTO memberPwdUpdate(String memberId, String pwd, String newPwd) {
		MemberDTO result = null;
		
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberId", memberId);
			map.put("pwd", pwd);
			map.put("newPwd", newPwd);
			
			member.updateMemberPwd(map);
			result = member.searchMemberById(memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public MemberDTO memberUpdate(MemberDTO mem) {
		// TODO Auto-generated method stub
		MemberDTO result = null;
		
		try {
			member.updateMember(mem);
			result = mem;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
}
