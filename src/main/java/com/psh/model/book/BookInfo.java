package com.psh.model.book;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
public class BookInfo {

    @NotNull
    private Long bookId;

    @NotNull
    private String bookName;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    @NotNull
    private int price;

    @NotNull
    private int discount;

}
