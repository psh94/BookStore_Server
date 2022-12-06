package com.psh.service;

import com.psh.mapper.CartMapper;
import com.psh.mapper.ImageMapper;
import com.psh.model.book.AttachImage;
import com.psh.model.cart.Cart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartMapper cartMapper;

    private final ImageMapper imageMapper;

    @Override
    public int addCart(Cart cart) {
        Cart checkCart = cartMapper.checkCart(cart);
        // 카트가 이미 있으면 2를, 정상 작동하면 1을, 예외가 발생하면 0을 반환한다.
        if(checkCart != null){
            return 2;
        }

        try {
            return cartMapper.addCart(cart);
        } catch (Exception e){
            return 0;
        }
    }

    @Override
    public int deleteCart(int cartId) {
        return cartMapper.deleteCart(cartId);
    }

    @Override
    public int modifyCount(Cart cart) {
        return cartMapper.modifyCount(cart);
    }

    @Override
    public List<Cart> getCart(String memberId) {
        return cartMapper.getCart(memberId);
    }

    @Override
    public Cart checkCart(Cart cart) {
        return  cartMapper.checkCart(cart);
    }

    @Override
    public List<Cart> getCartList(String memberId) {
        List<Cart> cartList = cartMapper.getCart(memberId);

        for(Cart cart : cartList){
            // 종합적인 값 세팅
            cart.initSaleTotal();

            // 이미지 정보 추가
            int bookId = cart.getBookId();

            List<AttachImage> imageList = imageMapper.getAttachList(bookId);

            cart.setImageList(imageList);
        }

        return cartList;
    }
}

