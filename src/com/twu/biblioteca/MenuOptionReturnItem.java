package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuOptionReturnItem extends MenuOption {

    private ArrayList<? extends LibraryItem> items;
    private String itemName;
    
    public MenuOptionReturnItem(ArrayList<? extends LibraryItem> items, String itemName) {
        this.items = items;
        this.itemName = itemName;
        setName("Return " + itemName);
    }

    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select number of " + itemName + " to return");

        for (LibraryItem item : items) {
            if (item.isCheckedOut()) {
                System.out.println((items.indexOf(item) + 1) + "\t" + item.getItemInfo());
            }
        }

        String option = scanner.nextLine();

        try {
            int optionNumber = Integer.parseInt(option);
            LibraryItem selectedLibraryItem = items.get(optionNumber - 1);
            selectedLibraryItem.returnItem();
            System.out.println("Thank you for returning the " + itemName + ".");
        } catch (Exception e) {
            System.out.println("That is not a valid " + itemName + " to return.");
        }
        System.out.println("Please select an option from the main menu.");
    }
}
