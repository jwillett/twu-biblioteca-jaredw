package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public BibliotecaApp() {
        initLibraryItems();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    private void initLibraryItems() {
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
        books.add(new Book("Harry Potter", "J.K. Rowling", 1997));
        movies.add(new Movie("The Godfather", 1972, "Francis Ford Coppola", 10));
        movies.add(new Movie("Jurassic Park", 1993, "Steven Spielberg"));

    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    private void promptMainMenu() {
        Menu mainMenu = new Menu(books, movies);

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
