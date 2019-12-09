package com.lyh.guanbei.service;

import com.lyh.guanbei.BaseResponse;
import com.lyh.guanbei.bean.Book;
import com.lyh.guanbei.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public void insert(Book book) {
        bookMapper.insert(book);
    }

    public Book query(long id) {
        return bookMapper.query(id);
    }

    public List<Book> query(List<Long> idList) {
        return bookMapper.queryForList(idList);
    }

    public void update(List<Book> books) {
        for (Book book : books)
            bookMapper.update(book);
    }

    public void update(Book book) {
        bookMapper.update(book);
    }

    public void delete(long id) {
        bookMapper.delete(id);
    }
}
