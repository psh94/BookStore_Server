package com.psh.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {

    private int memberId;

    private String bookName;

    private String price;

    private String quantity;

    private int discountPrice;

    private int totalPrice;
}

