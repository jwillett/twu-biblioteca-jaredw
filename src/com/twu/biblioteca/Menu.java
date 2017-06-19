package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();

    public Menu(ArrayList<Book> books, ArrayList<Movie> movies) {
        initOptions(books, movies);
    }

    private void initOptions(ArrayList<Book> books, ArrayList<Movie> movies) {
        menuOptions.add(new MenuOptionListBooks(books));
        menuOptions.add(new MenuOptionCheckoutBook(books));
        menuOptions.add(new MenuOptionReturnBook(books));
        menuOptions.add(new MenuOptionListMovies(movies));
        menuOptions.add(new MenuOptionCheckoutMovie(movies));
        menuOptions.add(new MenuOptionReturnMovie(movies));
        menuOptions.add(new MenuOptionQuit());
    }

    public void printMenuOptions() {
        System.out.println("Select an option by entering the appropriate number:");
        for (MenuOption option : menuOptions) {
            System.out.println(option.getName() + " - " + (menuOptions.indexOf(option) + 1));
        }
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        MenuOption selectedOption = null;

        // test if valid int
        // test if int valid index
        // if both, execute
        // else, throw error message
        // loop forever (only quit breaks out)

        while ((selectedOption == null) || (!selectedOption.getName().equals("Quit"))) {
            String option = scanner.nextLine();
            try {
                int optionNumber = Integer.parseInt(option);
                selectedOption = menuOptions.get(optionNumber - 1);
                selectedOption.execute();
            } catch (Exception e) {
                System.out.println("Select a valid option!");
            }
        }
    }
}
