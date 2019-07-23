package com.bi.book.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Getter
@Setter
public class Rss extends BookList {
    private Channel channel;

    @Override
    public void setBookData() {
        Book book = Book.builder()
                .title(channel.getItem().getTitle())
                .authors(channel.getItem().getAuthor())
                .isbn(channel.getItem().getIsbn())
                .publisher(channel.getItem().getPublisher()).build();

        super.getRows().add(book);
    }

}

@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Getter
@Setter
class Channel {
    private String title;
    private String link;
    private String description;
    private String lastBuildDate;
    private String total;
    private String start;
    private String display;
    private Item item;

}

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Getter
@Setter
class Item {
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
