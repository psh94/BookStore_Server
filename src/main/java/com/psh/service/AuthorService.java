package com.psh.service;

import com.psh.model.AuthorVO;
import com.psh.model.Criteria;

import java.util.List;

public interface AuthorService {

	/* 작가 등록 */
	public void authorEnroll(AuthorVO author) throws Exception;	
	
	/* 작가 목록 */
	public List<AuthorVO> authorGetList(Criteria cri) throws Exception;
		
	/* 작가 총 수 */
	public int authorGetTotal(Criteria cri) throws Exception;	
	
	/* 작가 상세 페이지 */
	public AuthorVO authorGetDetail(int authorId) throws Exception;
	
	/* 작가 정보 수정 */
	public int authorModify(AuthorVO author) throws Exception;	
	
	/* 작가 정보 삭제 */
	public int authorDelete(int authorId);	
	
}
