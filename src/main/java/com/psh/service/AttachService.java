package com.psh.service;

import com.psh.model.AttachImageVO;

import java.util.List;

public interface AttachService {

	/* 이미지 데이터 반환 */
	public List<AttachImageVO> getAttachList(int bookId);	
	
}
