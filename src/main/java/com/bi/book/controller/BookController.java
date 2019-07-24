package com.bi.book.controller;

import com.bi.book.entity.BookList;
import com.bi.book.entity.BookReqeustInfo;
import com.bi.book.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/search")
    public String searchPage() {
        return "book/search";
    }

    @GetMapping("/search/{type}/{keyword}")
    @ResponseBody
    public BookList searchBooks(@PathVariable("type") String type
            , @PathVariable("keyword") String keyword
            , int records, int page) {
        BookList rtnInfo = null;
        BookReqeustInfo reqInfo = BookReqeustInfo.builder()
                .type(type)
                .keyword(keyword)
                .size(records)
                .page(page).build();
        rtnInfo = bookService.sendReqeustBookApi(reqInfo);

//        bookService.insertHistory

        return rtnInfo;
    }

    @GetMapping("/detail/{isbn}")
    @ResponseBody
    public BookList detailPage(@PathVariable("isbn") String keyword) {
        BookList rtnInfo = null;
        String[] keywords = keyword.split(" ");
        BookReqeustInfo reqInfo = BookReqeustInfo.builder()
                .type("isbn")
                .keyword(keywords[0]).build();
        rtnInfo = bookService.sendReqeustBookApi(reqInfo);

        return rtnInfo;
    }

}
