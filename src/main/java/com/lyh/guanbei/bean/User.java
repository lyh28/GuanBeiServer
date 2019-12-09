package com.lyh.guanbei.bean;

public class User {
    private String user_name;
    private long user_id;
    private String user_icon;
    private String user_pwd;
    private String user_phone;
    private String create_time;
    private String book_id;
    private String last_login_time;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_id=" + user_id +
                ", user_icon='" + user_icon + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", create_time='" + create_time + '\'' +
                ", book_id='" + book_id + '\'' +
                ", last_login_time='" + last_login_time + '\'' +
                '}';
    }
}
