package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuOption {

    private String name;
    private ArrayList<Book> books;

    public MenuOption(String name) {
        this.name = name;
    }

    public MenuOption(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
    }

    public void execute() {
        for (Book book : books) {
            System.out.print(book.getTitle() + '\t');
            System.out.print(book.getAuthor() + '\t');
            System.out.println(book.getYear());
        }
    }

    public String getName() {
        return name;
    }

}
