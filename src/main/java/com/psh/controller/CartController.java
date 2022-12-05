package com.psh.controller;

import com.psh.model.cart.Cart;
import com.psh.model.member.Member;
import com.psh.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/cart/add")
    @ResponseBody
    public int addCartPOST(Cart cart, HttpServletRequest request) {
        // 로그인 체크
        HttpSession session = request.getSession();
        Member mvo = (Member)session.getAttribute("member");

        // 멤버가 null 이면 5를 반환
        if(mvo == null) {
            return 5;
        }

        // 카트 등록 결과 반환
        return cartService.addCart(cart);
    }

    @GetMapping("/cart/{memberId}")
    public String cartPage(@PathVariable("memberId") String memberId, Model model) {

        model.addAttribute("cartInfo", cartService.getCartList(memberId));
        return "/cart";
    }

    @PostMapping("/cart/updateCount")
    public String updateCart(Cart cart) {

        cartService.modifyCount(cart);

        return "redirect:/cart/" + cart.getMemberId();

    }

    @PostMapping("/cart/delete")
    public String deleteCart(Cart cart) {

        cartService.deleteCart(cart.getCartId());

        return "redirect:/cart/" + cart.getMemberId();

    }

}
