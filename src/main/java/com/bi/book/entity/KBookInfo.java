package com.bi.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KBookInfo extends BookList {
    private meta meta;
    private List<document> documents;

    public void setBookData() {
        for (document doc : documents) {
            /*Book book = new Book();
            book.setTitle(doc.getTitle());
            book.setAuthors(doc.getAuthors().toString());
            book.setIsbn(doc.getIsbn());
            book.setPublisher(doc.getPublisher());*/
            Book book = Book.builder()
                    .title(doc.getTitle())
                    .authors(doc.getAuthors().toString())
                    .isbn(doc.getIsbn())
                    .publisher(doc.getPublisher())
                    .contents(doc.getContents())
                    .url(doc.getUrl())
                    .price(doc.getPrice())
                    .salePrice(doc.getSalePrice())
                    .thumbnail(doc.getThumbnail()).build();

            super.getRows().add(book);
        }
    }
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class meta {
    private String isEnd;
    private String pageableCount;
    private String totalCount;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class document {
    private List<String> authors;
    private String contents;
    private String datetime;
    private String isbn;
    private String price;
    private String publisher;
    private String salePrice;
    private String status;
    private String thumbnail;
    private String title;
    private List<String> translators;
    private String url;

}