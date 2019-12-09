package com.lyh.guanbei.mapper;

import com.lyh.guanbei.bean.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    void insert(Book book);
    Book query(long id);
    List<Book> queryForList(List<Long> idList);
    void update(Book book);
    void delete(long book_id);
}
