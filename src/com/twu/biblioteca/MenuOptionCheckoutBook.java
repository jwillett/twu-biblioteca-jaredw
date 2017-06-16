package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuOptionCheckoutBook extends MenuOption {

    private ArrayList<Book> books;

    public MenuOptionCheckoutBook(ArrayList<Book> books) {
        this.books = books;
        setName("Checkout Book");
    }

    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select number of book to checkout");

        for (Book book : books) {
            System.out.println((books.indexOf(book) + 1) + "\t" + book.getBookInfo());
        }

        String option = scanner.nextLine();

        try {
            int optionNumber = Integer.parseInt(option);
            Book selectedBook = books.get(optionNumber - 1);
            selectedBook.checkout();
            System.out.println("Thank you! Enjoy the book");
        } catch (Exception e) {
            System.out.println("Invalid book selection!");
        }
    }
}
