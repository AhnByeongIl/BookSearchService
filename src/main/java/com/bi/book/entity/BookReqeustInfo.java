package com.bi.book.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookReqeustInfo {
    private String type;
    private String keyword;
    private String sort;
    private int page;
    private int size;
    private String isSearch;

    public BookReqeustInfo() {}

    @Builder
    public BookReqeustInfo(String type, String keyword, String sort, int page, int size, String isSearch) {
        this.type = type;
        this.keyword = keyword;
        this.sort = sort;
        this.page = page;
        this.size = size;
        this.isSearch = isSearch;
    }
}
