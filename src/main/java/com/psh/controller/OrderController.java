//package com.psh.controller;
//
//import com.psh.model.member.Member;
//import com.psh.model.OrderDTO;
//import com.psh.model.OrderPageDTO;
//import com.psh.service.MemberService;
//import com.psh.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class OrderController {
//
//	@Autowired
//	private OrderService orderService;
//
//	@Autowired
//	private MemberService memberService;
//
//	@GetMapping("/order/{memberId}")
//	public String orderPgaeGET(@PathVariable("memberId") String memberId, OrderPageDTO opd, Model model) {
//
//		model.addAttribute("orderList", orderService.getGoodsInfo(opd.getOrders()));
//		model.addAttribute("memberInfo", memberService.getMemberInfo(memberId));
//
//
//		return "/order";
//	}
//
//	@PostMapping("/order")
//	public String orderPagePost(OrderDTO od, HttpServletRequest request) {
//
//		System.out.println(od);
//
//		orderService.order(od);
//
//		Member member = new Member();
//		member.setMemberId(od.getMemberId());
//
//		HttpSession session = request.getSession();
//
//		try {
//			Member memberLogin = memberService.memberLogin(member);
//			memberLogin.setMemberPw("");
//			session.setAttribute("member", memberLogin);
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//		return "redirect:/main";
//	}
//
//}
