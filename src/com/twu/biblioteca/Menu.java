package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();

    public Menu(BibliotecaApp biblioteca) {
        initOptions(biblioteca);
    }

    private void initOptions(BibliotecaApp biblioteca) {
        menuOptions.add(new MenuOptionListBooks(biblioteca.getBooks()));
        menuOptions.add(new MenuOptionCheckoutBook(biblioteca.getBooks()));
        menuOptions.add(new MenuOptionReturnBook(biblioteca.getBooks()));
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
