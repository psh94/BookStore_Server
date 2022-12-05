package com.psh.mapper;

import com.psh.model.book.AttachImage;

import java.util.List;

public interface ImageMapper {

    /* 이미지 등록 */
    public void imageEnroll(AttachImage attachImage);

    /* 이미지 데이터 반환 */
    public List<AttachImage> getAttachList(int bookId);

    /* 지정 상품 이미지 전체 삭제 */
    public void deleteImageAll(int bookId);

    /* 어제자 날짜 이미지 리스트 */
    public List<AttachImage> checkFileList();

    /* 지정 상품 이미지 정보 얻기 */
    public List<AttachImage> getAttachInfo(int bookId);
}
