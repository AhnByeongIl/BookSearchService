package com.bi.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NBookInfo extends BookList {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<item> items;

    public void setBookData() {
        for (item doc : items) {
            /*Book book = new Book();
            book.setTitle(doc.getTitle());
            book.setAuthors(doc.getAuthor());
            book.setIsbn(doc.getIsbn());
            book.setPublisher(doc.getPublisher());*/
            Book book = Book.builder()
                    .title(doc.getTitle())
                    .authors(doc.getAuthor())
                    .isbn(doc.getIsbn())
                    .publisher(doc.getPublisher())
                    .contents(doc.getDescription())
                    .url(doc.getLink())
                    .price(doc.getPrice())
                    .salePrice(doc.getDiscount())
                    .thumbnail(doc.getImage()).build();

            super.getRows().add(book);
        }
        super.setTotal(total);
    }
}
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class item {
    private String title;
    private String link;
    private String image;
    private String author;
    private String price;
    private String discount;
    private String publisher;
    private String pubdate;
    private String isbn;
    private String description;

}
