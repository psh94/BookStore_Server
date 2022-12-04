package com.psh.service;

import com.psh.model.book.Book;
import com.psh.model.book.BookInfo;
import com.psh.model.book.BookUpdateParam;

public interface BookService {

    /* 상품 등록 */
    public void bookEnroll(Book book);

    /* 책 등록 중복 검사 */
    public boolean isExistBookIsbn(String isbn);

    /* 상품 조회 */
    public BookInfo bookGet(String isbn);

    /* 책 업데이트 */
    public void bookUpdate(BookUpdateParam bookUpdateParam);

    /* 책 삭제 */
    public void bookDelete(Book book);

}
