package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuOptionListItems extends MenuOption {

    private ArrayList<? extends LibraryItem> items;

    public MenuOptionListItems(ArrayList<? extends LibraryItem> items, String menuItemName) {
        this.items = items;
        setName(menuItemName);
    }

    public void execute() {
        for (LibraryItem item: items) {
            if (!item.isCheckedOut()) {
                System.out.println(item.getItemInfo());
            }
        }
    }

}
