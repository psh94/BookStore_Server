package com.psh.service;

import com.psh.exception.ExistSameBookException;
import com.psh.mapper.BookMapper;
import com.psh.mapper.ImageMapper;
import com.psh.model.book.Book;
import com.psh.model.book.BookInfo;
import com.psh.model.book.BookUpdateParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService{

    private final BookMapper bookMapper;

    private final ImageMapper imageMapper;

//    @Transactional
    @Override
    public void bookEnroll(Book book) {
        bookMapper.bookEnroll(book);

        /* 이미지 등록 로직 */
        if(book.getImageList() == null || book.getImageList().size() <= 0) {
            return; // 여기서 종료
        }

        book.getImageList().forEach(attach ->{

            attach.setBookId(book.getBookId());
            imageMapper.imageEnroll(attach);

        });
    }

    @Override
    public boolean isExistBookIsbn(String isbn) {
        return bookMapper.isExistBookIsbn(isbn);
    }

    @Override
    public BookInfo bookGet(String isbn) {

            return bookMapper.bookGet(isbn);
    }

    @Override
    public void bookUpdate(BookUpdateParam param) {
        bookMapper.bookUpdate(param);
    }

    @Override
    public void bookDelete(Book book) {
        bookMapper.bookDelete(book);
    }
}
