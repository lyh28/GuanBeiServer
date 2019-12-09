package com.lyh.guanbei.mapper;

import com.lyh.guanbei.bean.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {
    //添加记录
    void insert(Record record);
    //删除记录
    void delete(List<Long> id);
    //更新记录
    void update(Record record);
    //获取记录
    List<Record> queryByUserId(List<Long> userIds);
    List<Record> queryByBookId(List<Long> bookIds);
}
