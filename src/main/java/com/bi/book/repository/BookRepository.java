package com.bi.book.repository;

import com.bi.book.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<SearchHistory, Long> {

    List<SearchHistory> findByUidOrderByDateDesc(String authUserName);

    @Query(value = "SELECT " +
            "s.keyword as keyword, count(s.keyword) as count " +
            "FROM SearchHistory s " +
            "GROUP BY s.keyword " +
            "ORDER BY count(s.keyword) DESC " )
    List<SearchHistory> findTop10GroupByKeyword();
}
