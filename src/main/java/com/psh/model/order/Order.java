package com.psh.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {

    /* 주문 번호 */
    private String orderId;

    /* 배송 받는이 */
    private String takerName;

    /* 주문 회원 아이디 */
    private String memberId;

    /* 주소 */
    private String address;


    /* 주문 상태 */
    private String orderState;

    /* 주문 상품 */
    private List<OrderItem> orders;

    /* 배송비 */
    private int deliveryCost;

    /* 사용 포인트 */
    private int usePoint;

    /* 주문 날짜 */
    private Date orderDate;



    // DB에는 올라가지 않는 데이터터
    /*판매가(모든 상품 비용) */
    private int orderSalePrice;

    /* 적립 포인트 */
    private int orderSavePoint;

    /* 최종 판매 비용 */
    private int orderFinalSalePrice;


    // 주문 작업에 필요한 데이터를 세팅해주는 메서드
    public void getOrderPriceInfo() {
        /* 상품 비용 & 적립포인트 */
        for(OrderItem order : orders) {
            orderSalePrice += order.getTotalPrice();
            orderSavePoint += order.getTotalSavePoint();
        }
        /* 배송비용 */
        // 총 주문 금액이 3만원을 넘을 시 배송비 0원
        if(orderSalePrice >= 30000) {
            deliveryCost = 0;
        } else {
            deliveryCost = 3000;
        }
        /* 최종 비용(상품 비용 + 배송비 - 사용 포인트) */
        orderFinalSalePrice = orderSalePrice + deliveryCost - usePoint;
    }
}

