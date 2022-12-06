package com.psh.controller;

import com.psh.model.Criteria;
import com.psh.model.book.Book;
import com.psh.model.reply.Reply;
import com.psh.model.reply.ReplyPage;
import com.psh.service.BookService;
import com.psh.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/reply")
public class ReplyController {

    private final ReplyService replyService;

    private final BookService bookService;

    /* 댓글 등록 */
    @PostMapping("/enroll")
    public void enrollReplyPOST(Reply reply) {
        replyService.enrollReply(reply);
    }

    /* 리뷰 쓰기 */
    @GetMapping("/enroll/{memberId}")
    public String replyEnrollWindowGET(@PathVariable String memberId, int bookId, Model model) {
        Book book = bookService.getBookNameById(bookId);
        model.addAttribute("bookInfo", book);
        model.addAttribute("memberId", memberId);

        return "/enroll";
    }

    /* 댓글 체크 */
    /* memberId, bookId 파라미터 */
    /* 존재 : 1 / 존재x : 0 */
    @PostMapping("/check")
    public String replyCheck(Reply reply) {
        return replyService.checkReply(reply);
    }

    /* 댓글 페이징 */
    @GetMapping("/list")
    public ReplyPage replyList(Criteria cri) {
        return replyService.replyList(cri);
    }

    /* 댓글 수정 */
    @PostMapping("/update")
    public void replyModify(Reply reply) {
        replyService.updateReply(reply);
    }

    /* 리뷰 수정 팝업창 */
    @GetMapping("/replyUpdate")
    public String replyUpdateWindowGET(Reply dto, Model model) {
        Book book = bookService.getBookNameById(dto.getBookId());
        model.addAttribute("bookInfo", book);
        model.addAttribute("replyInfo", replyService.getUpdateReply(dto.getReplyId()));
        model.addAttribute("memberId", dto.getMemberId());

        return "/replyUpdate";
    }

    /* 댓글 삭제 */
    @PostMapping("/delete")
    public void replyDeletePOST(Reply reply) {
        replyService.deleteReply(reply);
    }
}
