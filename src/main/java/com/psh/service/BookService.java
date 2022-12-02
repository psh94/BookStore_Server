package com.psh.service;

import com.psh.model.*;

import java.util.List;

public interface BookService {

	/* 상품 검색 */
	public List<BookVO> getGoodsList(Criteria cri);
	
	/* 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri);	
	
	/* 국내 카테고리 리스트 */
	public List<CateVO> getCateCode1();
	
	/* 외국 카테고리 리스트 */
	public List<CateVO> getCateCode2();	
	
	/* 검색결과 카테고리 필터 정보 */
	public List<CateFilterDTO> getCateInfoList(Criteria cri);	
	
	/* 상품 정보 */
	public BookVO getGoodsInfo(int bookId);		
	
	/* 상품 id 이름 */
	public BookVO getBookIdName(int bookId);
	
	/* 평줌순 상품 정보 */
	public List<SelectDTO> likeSelect();		

}
