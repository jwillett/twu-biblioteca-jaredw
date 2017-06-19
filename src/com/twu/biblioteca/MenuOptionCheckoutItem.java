package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuOptionCheckoutItem extends MenuOption {

    private ArrayList<? extends LibraryItem> items;
    private String itemName;
    private User activeUser;

    public MenuOptionCheckoutItem(ArrayList<? extends LibraryItem> items, String itemName, User user) {
        this.activeUser = user;
        this.items = items;
        this.itemName = itemName;
        setName("Checkout " + itemName);
    }

    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select number of " + itemName + " to checkout");

        for (LibraryItem item : items) {
            if (!item.isCheckedOut()) {
                System.out.println((items.indexOf(item) + 1) + "\t" + item.getItemInfo());
            }
        }

        String option = scanner.nextLine();

        try {
            int optionNumber = Integer.parseInt(option);
            LibraryItem selectedLibraryItem = items.get(optionNumber - 1);
            selectedLibraryItem.checkout(activeUser);
            System.out.println("Thank you! Enjoy the " + itemName);
        } catch (Exception e) {
            System.out.println("That " + itemName + " is not available.");
        }
        System.out.println("Please select an option from the main menu.");
    }
}
