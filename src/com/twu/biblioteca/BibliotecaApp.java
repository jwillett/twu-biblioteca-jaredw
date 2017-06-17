package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();

    public BibliotecaApp() {
        initBooks();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    private void initBooks() {
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
        books.add(new Book("Harry Potter", "J.K. Rowling", 1997));
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    private void promptMainMenu() {
        Menu mainMenu = new Menu(books);

        mainMenu.printMenuOptions();

        mainMenu.processUserInput();

    }

    public void listBooks() {
        for (Book book : books) {
            System.out.print(book.getTitle() + '\t');
            System.out.print(book.getAuthor() + '\t');
            System.out.println(book.getYear());
        }
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.runCustomerInterface();
    }

    private void runCustomerInterface() {
        printWelcomeMessage();
        promptMainMenu();
    }
}
