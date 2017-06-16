package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();

    public Menu(BibliotecaApp biblioteca) {
        initOptions(biblioteca);
    }

    private void initOptions(BibliotecaApp biblioteca) {
        menuOptions.add(new MenuOption("List Books", biblioteca.getBooks()));
    }

    public void printMenuOptions() {
        System.out.println("Select an option by entering the appropriate number:");
        for (MenuOption option : menuOptions) {
            System.out.println(option.getName() + " - " + (menuOptions.indexOf(option) + 1));
        }
    }

    public void processUserInput(BibliotecaApp biblioteca) {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        while (!option.equals("1")) {
            System.out.println("Select a valid option!");
            option = scanner.nextLine();
        }
        biblioteca.listBooks();
    }
}
