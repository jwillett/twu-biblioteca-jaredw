package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int year;
    private boolean checkedOut = false;

    public Book (String title) {
        this.title = title;
    }

    public Book (String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getBookInfo() {
        return getTitle() + '\t' + getAuthor() + '\t' + getYear();
    }

    public void checkout() {
        checkedOut = true;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

}
