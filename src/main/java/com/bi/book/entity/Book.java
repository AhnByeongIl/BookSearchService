package com.bi.book.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    public String title;
    public String isbn;
    public String publisher;
    public String authors;
    public String contents;
    public String url;
    public String price;
    public String salePrice;
    public String thumbnail;

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
