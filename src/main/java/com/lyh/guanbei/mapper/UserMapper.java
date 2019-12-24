package com.lyh.guanbei.mapper;

import com.lyh.guanbei.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //通过手机号查找用户
    User search(String phone);
    void insert(User user);
    User queryById(long id);
    User queryByPhone(String phone);
    //修改上次登录时间
    void updateLoginTime(String loginTime,long user_id);
    //修改bookid
    void updateBookId(String book_id,long user_id);
    //获取bookid
    String queryBookId(long user_id);
}
