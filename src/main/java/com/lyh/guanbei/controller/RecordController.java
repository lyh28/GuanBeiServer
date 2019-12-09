package com.lyh.guanbei.controller;

import com.lyh.guanbei.BaseResponse;
import com.lyh.guanbei.bean.Record;
import com.lyh.guanbei.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @PostMapping("/insert")
    public BaseResponse<List<Record>> insert(@RequestBody List<Record> recordList){
        recordService.insert(recordList);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE,"",recordList);
    }
    @PostMapping("/delete")
    public BaseResponse<String> delete(@RequestBody List<Long> idList){
        recordService.delete(idList);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE,"","");
    }
    @PostMapping("/update")
    public BaseResponse<String> update(@RequestBody List<Record> recordList){
        recordService.update(recordList);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE,"","");
    }
    @PostMapping("/queryByUserId")
    public BaseResponse<List<Record>> queryByUserId(@RequestBody List<Long> idList){
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE,"",recordService.queryByUserId(idList));
    }
    @PostMapping("/queryByBookId")
    public BaseResponse<List<Record>> queryByBookId(@RequestBody List<Long> idList){
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE,"",recordService.queryByBookId(idList));
    }
}
