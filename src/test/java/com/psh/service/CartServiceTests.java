package com.psh.service;

import com.psh.model.book.AttachImage;
import com.psh.model.book.Book;
import com.psh.model.book.BookUpdateParam;
import com.psh.model.cart.Cart;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class CartServiceTests {

    @Autowired
    CartService cartService;

    @Autowired
    ImageService imageService;

    @Test
    public void addCartTest() {
        String memberId = "test7";
        int bookId = 4;
        int count = 2;

        Cart cart = new Cart();
        cart.setMemberId(memberId);
        cart.setBookId(bookId);
        cart.setBookCount(count);

        int result = cartService.addCart(cart);

        System.out.println("result : " + result);

    }


    /* 카트 삭제 */

    @Test
    public void deleteCartTest() {
        int cartId = 1;

        cartService.deleteCart(cartId);

    }

    /* 카트 수량 수정 */

    @Test
    public void modifyCartTest() {
        int cartId = 3;
        int count = 5;

        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setBookCount(count);

        cartService.modifyCount(cart);

    }


    /* 카트 목록 */

    @Test
    public void getCartTest() {
        String memberId = "test3";


        List<Cart> list = cartService.getCart(memberId);
        for(Cart cart : list) {
            System.out.println(cart);
            cart.initSaleTotal();
            System.out.println("init cart : " + cart);
        }
    }


    /* 카트 확인 */

    @Test
    public void checkCartTest() {

        String memberId = "test3";
        int bookId = 3;

        Cart cart = new Cart();
        cart.setMemberId(memberId);
        cart.setBookId(bookId);

        Cart resutlCart = cartService.checkCart(cart);
        System.out.println("결과 : " + resutlCart);

    }


}
