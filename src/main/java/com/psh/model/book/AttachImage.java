package com.psh.model.book;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AttachImage {

    /* 경로 */
    private String uploadPath;

    /* uuid */
    private String uuid;

    /* 파일 이름 */
    private String fileName;

    /* 상품 id */
    private int bookId;
}
