package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuOptionReturnBook extends MenuOption {

    private ArrayList<Book> books;

    public MenuOptionReturnBook(ArrayList<Book> books) {
        this.books = books;
        setName("Return Book");
    }

    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select number of book to return");

        for (Book book : books) {
            System.out.println((books.indexOf(book) + 1) + "\t" + book.getBookInfo());
        }

        String option = scanner.nextLine();

        try {
            int optionNumber = Integer.parseInt(option);
            Book selectedBook = books.get(optionNumber - 1);
            selectedBook.returnBook();
            System.out.println("Thank you for returning the book.");
        } catch (Exception e) {
            System.out.println("That is not a valid book to return.");
        }
    }
}