package com.lyh.guanbei.service;

import com.lyh.guanbei.bean.Record;
import com.lyh.guanbei.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;
    public void insert(List<Record> recordList){
        for(Record record:recordList){
            recordMapper.insert(record);
        }
    }
    public void delete(List<Long> id){
        recordMapper.delete(id);
    }
    public void update(List<Record> recordList){
        for(Record record:recordList){
            recordMapper.update(record);
        }
    }
    public List<Record> queryByUserId(List<Long> userIds){
        return recordMapper.queryByUserId(userIds);
    }
    public List<Record> queryByBookId(List<Long> bookIds){
        return recordMapper.queryByBookId(bookIds);
    }
}
