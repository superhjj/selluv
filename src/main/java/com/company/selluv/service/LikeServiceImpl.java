package com.company.selluv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.domain.dto.LikeDTO;
import com.company.selluv.domain.dto.ProfileDTO;
import com.company.selluv.persistence.LikeMapper;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeMapper likeMapper;
	
	private static int likeNumber;
	
	@Override
	public LikeDTO likeAdd(String likeCode,String memberId, String contentsCode) {
		LikeDTO likeDTO = new LikeDTO();
		likeNumber++;
		String generateCode = "like-" + likeNumber;
		likeDTO.setLikeCode(generateCode);
		likeDTO.setMemberId(memberId);
		likeDTO.setContentsCode(contentsCode);
		likeMapper.addLike(likeDTO);
		return likeDTO;
	}
	@Override
	public boolean likeDelete(String memberId, String contentsCode) {
		likeMapper.deleteLike(memberId, contentsCode);
		return true;
	}
	@Override
	public String likeCodeSearch(String memberId,String contentsCode) {
		return likeMapper.searchLikeCode(memberId, contentsCode);
	}
	@Override
	public List<ProfileDTO> likeMemberSearch(String contentsCode){
		return likeMapper.searchLikeMember(contentsCode);
	}
	@Override
	public List<ContentDTO> likeSearch(String memberId){
		return likeMapper.searchLike(memberId);
	}
	
}
