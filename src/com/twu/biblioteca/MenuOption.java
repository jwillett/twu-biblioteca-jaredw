package com.twu.biblioteca;

import java.util.ArrayList;

public abstract class MenuOption {

    private String name;

    public abstract void execute();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
