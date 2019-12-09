package com.lyh.guanbei.util;

public class Util {
    //从"A-B-C"格式中删除其中一个数据
    public static String deleteFormData(long data, String str) {
        if(str==null)   return "";
        String datas=data+"";
        String[] arr = str.split(Contact.SEPARATOR);
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(datas)) {
                continue;
            }
            if (res.equals("")) {
                res += arr[i];
            } else {
                res = res + Contact.SEPARATOR + arr[i];
            }
        }
        return res;
    }

    //添加至"A-B-C"格式中
    public static String addToData(long data, String str) {
        if(str==null){
            str="";
        }
        if (str.equals("")) {
            str += data;
        } else {
            str = str + Contact.SEPARATOR + data;
        }
        return str;
    }
}
