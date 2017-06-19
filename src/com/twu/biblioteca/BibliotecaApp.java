package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private HashMap<String, User> userList = new HashMap<String, User>();
    private User activeUser;

    public BibliotecaApp() {
        initLibraryItems();
        initUsers();
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

    private void initUsers() {
        userList.put("123-4567", new User("123-4567", "password123"));
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    private void promptMainMenu() {

        Menu mainMenu = new Menu(books, movies, activeUser);

        mainMenu.printMenuOptions();

        mainMenu.processUserInput();

    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.runCustomerInterface();
    }

    private void runCustomerInterface() {
        printWelcomeMessage();
        promptUserLogin();
        promptMainMenu();
    }

    private void promptUserLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to login? (Y/N)");
        String userInput = scanner.nextLine();

        if (userInput.startsWith("Y") || userInput.startsWith("y")) {

            System.out.println("Please enter your library number (Format: XXX-XXXX)");
            String libraryNumber = scanner.nextLine();

            System.out.println("Please enter your password");
            String password = scanner.nextLine();

            login(libraryNumber, password);

            if (activeUser == null) {
                System.out.println("Invalid login!");
                promptUserLogin();
            }

        }
    }

    private void login(String libraryNumber, String password) {
        User userLoggingIn = userList.get(libraryNumber);
        if (userLoggingIn != null && userLoggingIn.testCredentials(libraryNumber, password)) {
            this.activeUser = userLoggingIn;
        }
    }
}
