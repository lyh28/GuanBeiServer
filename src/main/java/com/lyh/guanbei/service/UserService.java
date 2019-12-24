package com.lyh.guanbei.service;

import com.lyh.guanbei.bean.User;
import com.lyh.guanbei.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserService(){
    }
    @Autowired
    private UserMapper userMapper;
    public User search(String phone){
        return userMapper.search(phone);
    }
    public User queryByPhone(String phone){
        return userMapper.queryByPhone(phone);
    }
    public User queryById(long id){
        return userMapper.queryById(id);
    }
    public void insert(User user){
        userMapper.insert(user);
    }
    public void updateBookId(String bookId,long userId){
        userMapper.updateBookId(bookId, userId);
    }
    public String queryBookId(long user_Id){
        return userMapper.queryBookId(user_Id);
    }
    public void updateLoginTime(String loginTime,long user_id){
        userMapper.updateLoginTime(loginTime,user_id);
    }
}
