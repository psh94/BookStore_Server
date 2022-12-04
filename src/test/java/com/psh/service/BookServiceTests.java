package com.psh.service;

import com.psh.model.book.Book;
import com.psh.model.book.BookInfo;
import com.psh.model.book.BookUpdateParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BookServiceTests {

    @Autowired
    BookService bookService;

    @Test
    public void bookEnrollTest(){
        Book book = new Book();
        book.setBookName("연금술사");
        book.setAuthor("코엘료 파울로");
        book.setIsbn("9788982814471");
        book.setPrice(10800);
        book.setQuantity(500);
        book.setDiscount(10);

        bookService.bookEnroll(book);
    }

    @Test
    public void bookGetTest(){
        bookService.bookGet("9788982814471");
    }

    @Test
    public void bookUpdateTest(){
        BookUpdateParam bookUpdateParam = new BookUpdateParam();
        bookUpdateParam.setIsbn("9788982814471");
        bookUpdateParam.setBookName("연금술사2");
        bookUpdateParam.setAuthor("코엘료 파울로");
        bookUpdateParam.setPrice(10800);
        bookUpdateParam.setQuantity(500);
        bookUpdateParam.setDiscount(10);

        bookService.bookUpdate(bookUpdateParam);
    }

    @Test
    public void bookDelete(){
        Book book = new Book();
        book.setBookId(1);
        book.setIsbn("9788982814471");

        bookService.bookDelete(book);
    }
}
