package com.psh.service;

import com.psh.model.OrderCancelDTO;
import com.psh.model.OrderDTO;
import com.psh.model.OrderPageItemDTO;

import java.util.List;

public interface OrderService {

	/* 주문 정보 */
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders);
	
	/* 주문 */
	public void  order(OrderDTO orw);	
	
	/* 주문 취소 */
	public void orderCancle(OrderCancelDTO dto);		
	
}
