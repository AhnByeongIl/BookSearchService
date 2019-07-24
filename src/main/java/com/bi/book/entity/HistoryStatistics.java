package com.bi.book.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryStatistics {
    private String keyword;
    private Long count;

    public HistoryStatistics(String keyword, Long count) {
        this.keyword = keyword;
        this.count = count;
    }
}
