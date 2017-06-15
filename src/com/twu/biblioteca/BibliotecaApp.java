package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    ArrayList<Book> books = new ArrayList<Book>();

    public BibliotecaApp() {
        initBooks();
    }

    private void initBooks() {
        books.add(new Book("Moby Dick"));
        books.add(new Book("Harry Potter"));
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
    }
}
