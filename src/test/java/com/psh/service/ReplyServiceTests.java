package com.psh.service;

import com.psh.mapper.ReplyMapper;
import com.psh.model.reply.Reply;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class ReplyServiceTests {

    @Autowired
    ReplyMapper replyMapper;

    @Test
    public void replyEnrollTest() {

        String memberId = "test2";
        int bookId = 3;
        double rating = 3.5;
        String content = "댓글 테스트";

        Reply reply = new Reply();
        reply.setMemberId(memberId);
        reply.setBookId(bookId);
        reply.setRating(rating);
        reply.setContent(content);

        replyMapper.enrollReply(reply);


    }
}
