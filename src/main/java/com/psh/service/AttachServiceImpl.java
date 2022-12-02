package com.psh.service;

import com.psh.mapper.AttachMapper;
import com.psh.model.AttachImageVO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class AttachServiceImpl implements AttachService{

	@Autowired
	private AttachMapper attachMapper;
	
	
	/* 이미지 데이터 반환 */
	@Override
	public List<AttachImageVO> getAttachList(int bookId) {
		
		log.info("getAttachList.........");
		
		return attachMapper.getAttachList(bookId);
	}
	

}
