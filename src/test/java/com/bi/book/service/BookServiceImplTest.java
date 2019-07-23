package com.bi.book.service;

import com.bi.book.entity.BookList;
import com.bi.book.entity.BookReqeustInfo;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@Log
public class BookServiceImplTest {
    @Autowired
    private BookServiceImpl bookService;

    @Test
    public void sendReqeustBookApi() {
        BookReqeustInfo info = new BookReqeustInfo();
        info.setType("isbn");
        info.setKeyword("8953721466");

        BookList bookList = bookService.sendReqeustBookApi(info);

        log.info(bookList.toString());
    }
}