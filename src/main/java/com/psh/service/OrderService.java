package com.psh.service;

import com.psh.model.Criteria;
import com.psh.model.book.Book;
import com.psh.model.cart.Cart;
import com.psh.model.member.Member;
import com.psh.model.order.Order;
import com.psh.model.order.OrderCancel;
import com.psh.model.order.OrderItem;
import com.psh.model.order.OrderPageItem;

import java.util.List;

public interface OrderService {

    /* 주문 정보 */
    public List<OrderPageItem> getBooksInfo(List<OrderPageItem> orders);

    /* 주문 처리 */
    public void order(Order order);

    /* 주문 상품 리스트 */
    public List<Order> getOrderList(Criteria cri);

    /* 주문 총 갯수 */
    public int getOrderTotal(Criteria cri);

    /* 주문 취소 */
    public void orderCancle(OrderCancel dto);

}
