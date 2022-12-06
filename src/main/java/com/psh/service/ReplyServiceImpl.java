package com.psh.service;

import com.psh.mapper.ReplyMapper;
import com.psh.model.Criteria;
import com.psh.model.Page;
import com.psh.model.reply.Reply;
import com.psh.model.reply.ReplyPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyMapper replyMapper;


    @Override
    public int enrollReply(Reply reply) {
        return replyMapper.enrollReply(reply);
    }

    @Override
    public String checkReply(Reply reply) {

        if(replyMapper.checkReply(reply) == null) {

            return "0";
        } else {
            return "1";
        }
    }

    @Override
    public ReplyPage replyList(Criteria cri) {
        ReplyPage replyPage = new ReplyPage();

        replyPage.setList(replyMapper.getReplyList(cri));
        replyPage.setPageInfo(new Page(cri, replyMapper.getReplyTotal(cri.getBookId())));

        return replyPage;
    }

    @Override
    public int updateReply(Reply reply) {
        return replyMapper.enrollReply(reply);
    }

    @Override
    public Reply getUpdateReply(int replyId) {

        return replyMapper.getUpdateReply(replyId);
    }

    @Override
    public int deleteReply(Reply dto) {

        return replyMapper.deleteReply(dto.getReplyId());
    }
}
