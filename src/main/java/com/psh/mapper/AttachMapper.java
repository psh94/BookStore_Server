package com.psh.mapper;

import com.psh.model.AttachImageVO;

import java.util.List;

public interface AttachMapper {

	/* 이미지 데이터 반환 */
	public List<AttachImageVO> getAttachList(int bookId);	
	
}
