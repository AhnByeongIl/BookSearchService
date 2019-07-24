package com.bi.book.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name="SearchHistory")
@EqualsAndHashCode(of="uid")
@ToString
@NoArgsConstructor
public class SearchHistory {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String uid;

    @Column
    private String keyword;

    @Column
    private String date;

    private int count;

    @Builder
    public SearchHistory(String uid, String keyword, String date) {
        this.uid = uid;
        this.keyword = keyword;
        this.date = date;
    }
}

