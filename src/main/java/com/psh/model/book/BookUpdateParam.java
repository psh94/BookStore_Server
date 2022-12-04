package com.psh.model.book;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
public class BookUpdateParam {

    @NotNull
    private String isbn;

    private String bookName;

    private String author;

    private int price;

    private int quantity;

    private int discount;

    private Date regDate;

    private Date updateDate;
}
