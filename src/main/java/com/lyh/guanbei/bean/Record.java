package com.lyh.guanbei.bean;

public class Record {
    private long record_id;
    private long user_id;
    private long book_id;
    private String time;
    private String amount;
    private String payto;
    private String content;
    private String remark;      //备注
    private String category;    //分类

    public long getRecord_id() {
        return record_id;
    }

    public void setRecord_id(long record_id) {
        this.record_id = record_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayto() {
        return payto;
    }

    public void setPayto(String payto) {
        this.payto = payto;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Record{" +
                "record_id=" + record_id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", time='" + time + '\'' +
                ", amount='" + amount + '\'' +
                ", payto='" + payto + '\'' +
                ", content='" + content + '\'' +
                ", remark='" + remark + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
