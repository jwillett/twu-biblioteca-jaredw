package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuOptionListBooks extends MenuOption {

    private ArrayList<Book> books;

    public MenuOptionListBooks(ArrayList<Book> books) {
        this.books = books;
        setName("List Books");
    }

    public void execute() {
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getBookInfo());
            }
        }
    }

}