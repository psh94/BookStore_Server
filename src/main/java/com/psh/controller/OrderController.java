package com.psh.controller;

import com.psh.model.Criteria;
import com.psh.model.Page;
import com.psh.model.member.Member;
import com.psh.model.member.MemberLoginParam;
import com.psh.model.order.Order;
import com.psh.model.order.OrderCancel;
import com.psh.model.order.OrderPage;
import com.psh.service.LoginService;
import com.psh.service.MemberService;
import com.psh.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final LoginService loginService;

    @GetMapping("/order/{memberId}")
    public String orderPgae(@PathVariable String memberId, OrderPage orderPage, Model model) {

        model.addAttribute("orderList", orderService.getBooksInfo(orderPage.getOrders()));
        model.addAttribute("memberInfo", memberService.getMemberInfo(memberId));

        return "/order";

    }

    @PostMapping("/order")
    public String orderPage(Order order, HttpServletRequest request){

        orderService.order(order);

        MemberLoginParam member = new MemberLoginParam();
        member.setMemberId(order.getMemberId());

        HttpSession session = request.getSession();

        try {
            Member memberLogin = loginService.memberLogin(member);
            memberLogin.setPassword("");
            session.setAttribute("member", memberLogin);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "redirect:/main";
    }

    /* 주문 현황 페이지 */
    @GetMapping("/orderList")
    public String orderListGET(Criteria cri, Model model) {

        List<Order> list = orderService.getOrderList(cri);

        if(!list.isEmpty()) {
            model.addAttribute("list", list);
            model.addAttribute("pageMaker", new Page(cri, orderService.getOrderTotal(cri)));
        } else {
            model.addAttribute("listCheck", "empty");
        }

        return "/admin/orderList";
    }

    /* 주문삭제 */
    @PostMapping("/orderCancle")
    public String orderCancle(OrderCancel orderCancel) {

        orderService.orderCancle(orderCancel);

        return "redirect:/admin/orderList?keyword=" + orderCancel.getKeyword() + "&amount=" + orderCancel.getAmount() + "&pageNum=" + orderCancel.getPageNum();

    }
}
