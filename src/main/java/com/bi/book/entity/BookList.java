package com.bi.book.entity;

import lombok.Builder;
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

@Getter
@Setter
class Book {
    private String title;
    private String isbn;
    private String publisher;
    private String authors;
    private String contents;
    private String url;
    private String price;
    private String salePrice;
    private String thumbnail;

    @Builder
    public Book(String title, String isbn, String publisher, String authors, String contents
    , String url, String price, String salePrice, String thumbnail) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
        this.contents = contents;
        this.url = url;
        this.price = price;
        this.salePrice = salePrice;
        this.thumbnail = thumbnail;
    }
}
