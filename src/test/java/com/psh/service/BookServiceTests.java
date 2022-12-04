package com.psh.service;

import com.psh.mapper.ImageMapper;
import com.psh.model.book.AttachImage;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BookServiceTests {

    @Autowired
    BookService bookService;

    @Autowired
    ImageMapper imageMapper;

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

    /* 이미지 등록 */
    @Test
    public void imageEnrollTest() {

        AttachImage attachImage = new AttachImage();

        attachImage.setBookId(2);
        attachImage.setFileName("test");
        attachImage.setUploadPath("test");
        attachImage.setUuid("test2");

        imageMapper.imageEnroll(attachImage);

    }

    @Test
    public void bookEnrollTestWithImage() {

        Book book = new Book();
        // 상품 정보
        book.setBookName("service 테스트");
        book.setAuthor("kim");
        book.setIsbn("3214323214");
        book.setPrice(30000);
        book.setQuantity(30);


        // 이미지 정보
        List<AttachImage> imageList = new ArrayList<AttachImage>();

        AttachImage image1 = new AttachImage();
        AttachImage image2 = new AttachImage();

        image1.setFileName("test Image 1");
        image1.setUploadPath("test image 1");
        image1.setUuid("test1111");

        image2.setFileName("test Image 2");
        image2.setUploadPath("test image 2");
        image2.setUuid("test2222");

        imageList.add(image1);
        imageList.add(image2);

        book.setImageList(imageList);

        // bookEnroll() 메서드 호출
        bookService.bookEnroll(book);


    }
}
