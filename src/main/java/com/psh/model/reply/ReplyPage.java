package com.psh.model.reply;

import com.psh.model.Page;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ReplyPage {

    List<Reply> list;

    Page pageInfo;


}
