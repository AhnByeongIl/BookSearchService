package com.bi.book.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class BookList {

    private int page;
    private int records;
    private int total;
    private List<Book> rows;
    private int pageCnt;

    public abstract void setBookData();

    BookList() {
        this.rows = new ArrayList<>();
    }

}

