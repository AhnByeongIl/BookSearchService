package com.bi.book.controller;

import com.bi.book.entity.BookList;
import com.bi.book.entity.BookReqeustInfo;
import com.bi.book.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/search")
    public String searchPage() {
        return "book/search";
    }

    @GetMapping("/search/{type}/{keyword}")
    @ResponseBody
    public BookList searchBooks(@PathVariable("type") String type, @PathVariable("keyword") String keyword) {
        BookList rtnInfo = null;
        BookReqeustInfo reqInfo = new BookReqeustInfo();
        reqInfo.setType(type);
        reqInfo.setKeyword(keyword);
        rtnInfo = bookService.sendReqeustBookApi(reqInfo);

//        bookService.insertHistory

        return rtnInfo;
    }



}
