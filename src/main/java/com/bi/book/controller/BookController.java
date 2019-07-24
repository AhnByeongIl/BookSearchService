package com.bi.book.controller;

import com.bi.book.entity.BookList;
import com.bi.book.entity.BookReqeustInfo;
import com.bi.book.entity.SearchHistory;
import com.bi.book.repository.BookRepository;
import com.bi.book.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/search")
    public String searchPage() {
        return "book/search";
    }

    @GetMapping("/search/{type}/{keyword}")
    @ResponseBody
    public BookList searchBooks(@PathVariable("type") String type
            , @PathVariable("keyword") String keyword
            , int records, int page, String isSearch) {
        BookList rtnInfo = null;
        BookReqeustInfo reqInfo = BookReqeustInfo.builder()
                .type(type)
                .keyword(keyword)
                .size(records)
                .page(page)
                .isSearch(isSearch).build();

        rtnInfo = bookService.bookSearchLogic(reqInfo);

        return rtnInfo;
    }

    @GetMapping("/detail/{isbn}")
    public ModelAndView detailPage(@PathVariable("isbn") String keyword) {
        ModelAndView mv = new ModelAndView();

        BookList rtnInfo = null;
        String[] keywords = keyword.split(" ");
        try {
            keyword = keywords[0].length() > 0 ? keywords[0] : keywords[1];
            BookReqeustInfo reqInfo = BookReqeustInfo.builder()
                    .type("isbn")
                    .keyword(keyword)
                    .size(1)
                    .page(1).build();
            rtnInfo = bookService.sendReqeustBookApi(reqInfo);

            mv.addObject("bookInfo", rtnInfo.getRows().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("book/detail");
        return mv;
    }

    @GetMapping("/myhistory")
    public ModelAndView getMyHistory() {
        ModelAndView mv = new ModelAndView();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails authUser = (UserDetails) principal;
        String authUserName = authUser.getUsername();

        List<SearchHistory> histories = bookRepository.findByUidOrderByDateDesc(authUserName);

        mv.addObject("histories", histories);
        mv.setViewName("book/history");
        return mv;
    }

    @GetMapping("/topten")
    public ModelAndView getToptenHistory() {
        ModelAndView mv = new ModelAndView();

        List<SearchHistory> histories = bookRepository.findTop10GroupByKeyword();

        mv.addObject("histories", histories);
        mv.setViewName("book/topten");
        return mv;
    }

}
