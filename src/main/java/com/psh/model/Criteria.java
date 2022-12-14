package com.psh.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

    /* 현재 페이지 번호 */
    private int pageNum;

    /* 페이지 표시 개수 */
    private int amount;

    /* 페이지 skip */
    private int skip;
//
//    /* 검색 타입 */
//    private String type;
//
//    /* 검색 키워드 */
//    private String keyword;
//
//    /* 작가 리스트 */
//    private String[] authorArr;

    /* 카테고리 코드 */
    private String cateCode;

    /* 상품 번호(댓글 기능에서 사용) */
    private int bookId;

    /* Criteria 생성자 */
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum -1) * amount;
    }

    /* Criteria 기본 생성자 */
    public Criteria(){
        this(1,10);
    }
//
//    /* 검색 타입 데이터 배열 변환 */
//    public String[] getTypeArr() {
//        return type == null? new String[] {}:type.split("");
//    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.skip = (pageNum - 1) * this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.skip = (this.pageNum - 1) * amount;
    }


    public void setSkip(int skip) {
        this.skip = skip;
    }

}
