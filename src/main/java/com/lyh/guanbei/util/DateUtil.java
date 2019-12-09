package com.lyh.guanbei.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    //得到当前日期 格式：2019-10-29 18:47:00
    public static String getNowDateTime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
