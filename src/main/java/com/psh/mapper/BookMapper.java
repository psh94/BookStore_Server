package com.psh.mapper;

import com.psh.model.book.Book;
import com.psh.model.book.BookInfo;
import com.psh.model.book.BookUpdateParam;
import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
import com.psh.model.member.MemberLoginParam;
import com.psh.model.member.MemberUpdateParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

	/* 책 등록 */
	public void bookEnroll(Book book);

	/* 책 등록 중복 검사 */
	public boolean isExistBookIsbn(String isbn);

	/* 책 조회 */
	public BookInfo bookGet(String isbn);

	/* 책 업데이트 */
	public void bookUpdate(BookUpdateParam bookUpdateParam);

	/* 책 삭제 */
	public void bookDelete(Book book);

	public Member getMemberInfo(String memberId);


}
