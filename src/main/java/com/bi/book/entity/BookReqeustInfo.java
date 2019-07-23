package com.bi.book.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookReqeustInfo {
    private String type;
    private String keyword;
    private String sort;
    private String page;
    private String size;

}
