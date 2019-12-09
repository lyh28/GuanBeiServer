package com.lyh.guanbei.controller;

import com.lyh.guanbei.BaseResponse;
import com.lyh.guanbei.bean.Book;
import com.lyh.guanbei.service.BookService;
import com.lyh.guanbei.util.Contact;
import com.lyh.guanbei.util.Util;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserController userController;

    @PostMapping("/insert")
    public BaseResponse<List<Book>> insert(@RequestBody List<Book> books) {
        for(Book book:books){
            bookService.insert(book);
            userController.addBookId(book.getBook_id(), book.getManager_id());
        }
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "插入成功", books);
    }

    @PostMapping("/queryForList")
    private BaseResponse<List<Book>> query(@RequestBody  List<Long> idList) {
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "", bookService.query(idList));
    }

    @PostMapping("/update")
    private BaseResponse<String> update(@RequestBody List<Book> book) {
        bookService.update(book);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "更新成功", null);
    }

    @PostMapping("/deleteFromList")
    private BaseResponse<String> deleteFromList(@RequestBody List<Long> id) {
        for (long i : id) {
            delete(i);
        }
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "删除成功", null);
    }

    @GetMapping("/delete/{id}")
    private BaseResponse<String> delete(@PathVariable("id") long id) {
        Book book = bookService.query(id);
        long managerId = book.getManager_id();
        String personId = book.getPerson_id();
        if(!TextUtils.isEmpty(personId)) {
            String[] arr = personId.split(Contact.SEPARATOR);
            //从用户表中删除相应数据
            for (String s : arr) {
                userController.deleteBookId(id, Integer.valueOf(s));
            }
        }
        userController.deleteBookId(id, managerId);
        bookService.delete(id);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "删除成功", null);
    }

    /**
     *
     * @return
     */
    @PostMapping("/deleteUser")
    private BaseResponse<String> deleteUser(@RequestParam("userId") long userId, @RequestParam("bookId") long bookId) {
        Book book = bookService.query(bookId);
        String idList = book.getPerson_id();
        System.out.println(idList);
        String res = Util.deleteFormData(userId, idList);
        System.out.println(res);
        userController.deleteBookId(bookId, userId);
        book.setPerson_id(res);
        if (res != null) bookService.update(book);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "删除用户成功", null);
    }

    @PostMapping("/addUser")
    private BaseResponse<String> addUser(@RequestParam("userId") long userId, @RequestParam("bookId") long bookId) {
        Book book = bookService.query(bookId);
        String idList = book.getPerson_id();
        book.setPerson_id(Util.addToData(userId, idList));
        userController.addBookId(bookId, userId);
        bookService.update(book);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "添加成员成功", null);
    }

    @PostMapping("/addUserRequest")
    private BaseResponse<String> addUserRequest(@RequestParam("userId") int userId, @RequestParam("requestId") int requestId, @RequestParam("bookId") int bookId) {
        //通过通知向userId的用户发送请求
        //        Book book=bookService.query(bookId);
//        String idList=book.getPerson_id();
//        Util.addToData(userId,idList);
//        userController.addBookId(bookId,userId);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "发起添加成员成功", null);
    }

    /**
     * oldId等于原managerId
     * newId等于其中一个PersonId
     */
    @PostMapping("/changeManager")
    private BaseResponse<Book> changeManager(@RequestParam("oldId") int oldId, @RequestParam("newId") int newId
            , @RequestParam("bookId") int bookId) {
        Book book = bookService.query(bookId);
        String personId = book.getPerson_id();
        long managerId = book.getManager_id();
        String newPersonId = Util.deleteFormData(newId, personId);
        newPersonId=Util.addToData(oldId, newPersonId);
        book.setManager_id(newId);
        book.setPerson_id(newPersonId);
        bookService.update(book);
        return new BaseResponse<>(BaseResponse.SUCCESS_CODE, "", book);
    }
}
