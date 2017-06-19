package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
    private User activeUser;

    public Menu(ArrayList<Book> books, ArrayList<Movie> movies, User activeUser) {
        this.activeUser = activeUser;
        initOptions(books, movies);
    }

    private void initOptions(ArrayList<Book> books, ArrayList<Movie> movies) {
        System.out.println(activeUser);
        menuOptions.add(new MenuOptionListItems(books, "List Books"));
        menuOptions.add(new MenuOptionListItems(movies, "List Movies"));
        if (activeUser != null) {
            menuOptions.add(new MenuOptionCheckoutItem(books, "book", activeUser));
            menuOptions.add(new MenuOptionReturnItem(books, "book", activeUser));
            menuOptions.add(new MenuOptionCheckoutItem(movies, "movie", activeUser));
            menuOptions.add(new MenuOptionReturnItem(movies, "movie", activeUser));
        }
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
