package com.psh.mapper;

import com.psh.model.book.Book;
import com.psh.model.book.BookInfo;
import com.psh.model.book.BookUpdateParam;
import com.psh.model.member.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

	/* 책 등록 */
	public void bookEnroll(Book book);

	/* 책 등록 중복 검사 */
	public boolean isExistBookIsbn(String isbn);

	/* 책 조회 */
	public BookInfo bookGet(int bookId);

	/* 책 업데이트 */
	public void bookUpdate(BookUpdateParam bookUpdateParam);

	/* 책 삭제 */
	public void bookDelete(Book book);

	public Book getBooksInfo(int bookId);

	/* 상품 id 이름 */
	public Book getBookNameById(int bookId);



}
