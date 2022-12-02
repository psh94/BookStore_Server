package com.psh.service;

import com.psh.mapper.AttachMapper;
import com.psh.mapper.CartMapper;
import com.psh.model.AttachImageVO;
import com.psh.model.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private  AttachMapper attachMapper;		

	@Override
	public int addCart(CartDTO cart) {

		// 장바구니 데이터 체크
		CartDTO checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		// 장바구니 등록 & 에러 시 0반환
		try {
			return cartMapper.addCart(cart);
		} catch (Exception e) {
			return 0;
		}		
		
	}	
	
	@Override
	public List<CartDTO> getCartList(String memberId) {
		
		List<CartDTO> cart = cartMapper.getCart(memberId);
		
		for(CartDTO dto : cart) {
			
			/* 종합 정보 초기화 */
			dto.initSaleTotal();
			
			/* 이미지 정보 얻기 */
			int bookId = dto.getBookId();
			
			List<AttachImageVO> imageList = attachMapper.getAttachList(bookId);
			
			dto.setImageList(imageList);
		}
		
		return cart;
		
	}	
	
	@Override
	public int modifyCount(CartDTO cart) {
		
		return cartMapper.modifyCount(cart);
	}		
	
	@Override
	public int deleteCart(int cartId) {

		return cartMapper.deleteCart(cartId);
	}	
	
}
