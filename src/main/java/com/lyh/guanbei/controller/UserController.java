package com.lyh.guanbei.controller;

import com.lyh.guanbei.BaseResponse;
import com.lyh.guanbei.bean.Book;
import com.lyh.guanbei.bean.User;
import com.lyh.guanbei.service.UserService;
import com.lyh.guanbei.util.DateUtil;
import com.lyh.guanbei.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookController bookController;
    @PostMapping("/login")
    public BaseResponse<User> login(@RequestParam("user_pwd") String user_pwd, @RequestParam("user_phone") String user_phone) {
        User res_user = userService.search(user_phone);
        if (user_pwd.equals(res_user.getUser_pwd())) {
            //更新上次登录时间
            userService.updateLoginTime(DateUtil.getNowDateTime(), res_user.getUser_id());
            return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "成功", res_user);
        } else
            return new BaseResponse<>(BaseResponse.FAILED_CODE, "用户名或密码错误", null);
    }

    @PostMapping("/register")
    public BaseResponse<User> register(@RequestBody User user) {
        //先查找是否已被注册
        User res_user = userService.search(user.getUser_phone());
        if (res_user != null) {
            //已被注册
            return new BaseResponse<>(BaseResponse.FAILED_CODE, "该账号已被注册", null);
        }
        String date=DateUtil.getNowDateTime();
        user.setCreate_time(date);
        user.setLast_login_time(date);
        userService.insert(user);
        List<Book> bookList=new ArrayList<>();
        bookList.add(Book.createNewBook(user.getUser_id()));
        bookController.insert(bookList);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "成功", user);
    }

    public String addBookId(long bookId,long userId){
        String bookIds=userService.queryBookId(userId);
        String res=Util.addToData(bookId,bookIds);
        userService.updateBookId(res,userId);
        return res;
    }

    public String deleteBookId(long bookId,long userId){
        String bookIds=userService.queryBookId(userId);
        String res=Util.deleteFormData(bookId,bookIds);
        userService.updateBookId(res,userId);
        return res;
    }
}
