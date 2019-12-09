package com.lyh.guanbei.bean;

public class Book {
    private long book_id;
    private String book_name;
    private long manager_id;
    private String person_id;   //以-分割
    private String max_sum;        //限额
    private String now_sum;
    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public long getManager_id() {
        return manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getMax_sum() {
        return max_sum;
    }

    public void setMax_sum(String max_sum) {
        this.max_sum = max_sum;
    }

    public String getNow_sum() {
        return now_sum;
    }

    public void setNow_sum(String now_sum) {
        this.now_sum = now_sum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", manager_id=" + manager_id +
                ", person_id='" + person_id + '\'' +
                ", max_sum=" + max_sum +
                '}';
    }

    public static Book createNewBook(long id){
        Book book=new Book();
        book.setBook_name("个人");
        book.setManager_id(id);
        return book;
    }
}
