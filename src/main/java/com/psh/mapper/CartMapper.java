package com.psh.mapper;

import com.psh.model.CartDTO;

import java.util.List;

public interface CartMapper {
	
	/* 카트 추가 */
	public int addCart(CartDTO cart) throws Exception;
	
	/* 카트 삭제 */
	public int deleteCart(int cartId);
	
	/* 카트 수량 수정 */
	public int modifyCount(CartDTO cart);
	
	/* 카트 목록 */
	public List<CartDTO> getCart(String memberId);	
	
	/* 카트 확인 */
	public CartDTO checkCart(CartDTO cart);	
	
	/* 카트 제거(주문) */
	public int deleteOrderCart(CartDTO dto);		

}
