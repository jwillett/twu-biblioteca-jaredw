package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<MenuChoice> menuOptions = new ArrayList<MenuChoice>();

    public Menu() {
        initOptions();
    }

    private void initOptions() {
        menuOptions.add(new MenuChoice("List Books"));
    }

    public void printMenuOptions() {
        System.out.println("Select an option by entering the appropriate number:");
        for (MenuChoice option : menuOptions) {
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
