package com.psh.controller.admin;

import com.psh.exception.ExistSameBookException;
import com.psh.model.book.Book;
import com.psh.model.book.BookInfo;
import com.psh.model.book.BookUpdateParam;
import com.psh.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static com.psh.utill.HttpResponses.*;

@RestController
@Slf4j
@RequestMapping("/admin/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("/Enroll")
    public ResponseEntity<Void> bookEnroll(@Valid @ModelAttribute Book book){
        boolean existedBook = bookService.isExistBookIsbn(book.getIsbn());
        if(existedBook) {
            throw new ExistSameBookException("이미 등록된 책입니다.");
        }
        bookService.bookEnroll(book);
        return RESPONSE_OK;
    }

    @GetMapping("/{isbn}")
    public BookInfo bookDetail(@PathVariable String isbn){
       return bookService.bookGet(isbn);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> bookUpdate(@Valid @ModelAttribute BookUpdateParam param){
        boolean existedBook = bookService.isExistBookIsbn(param.getIsbn());
        if(existedBook) {
            throw new ExistSameBookException("같은 ISBN으로는 등록할 수 없습니다.");
        }
        bookService.bookUpdate(param);
        return RESPONSE_OK;
    }

    @GetMapping("/delete")
    public ResponseEntity<Void> bookDelete(@Valid Book book){
        if(book.getIsbn() != null){
            bookService.bookDelete(book);
            return RESPONSE_OK;
        }
        return RESPONSE_CONFLICT;
    }


}
