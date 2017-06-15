package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();

    public BibliotecaApp() {
        initBooks();
    }

    private void initBooks() {
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
        books.add(new Book("Harry Potter", "J.K. Rowling", 1997));
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    public void promptMainMenu() {

        printMenuOptions();

        processUserInput();
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        while (!option.equals("1")) {
            System.out.println("Select a valid option!");
            option = scanner.nextLine();
        }
        listBooks();
    }

    public void printMenuOptions() {
        System.out.println("Select an option by entering the appropriate number:");
        System.out.println("List Books - 1");
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
