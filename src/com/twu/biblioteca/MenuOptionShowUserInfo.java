package com.twu.biblioteca;

public class MenuOptionShowUserInfo extends MenuOption {

    private User activeUser;

    public MenuOptionShowUserInfo (User activeUser) {
        this.activeUser = activeUser;
        setName("Show User Information");
    }

    public void execute() {
        System.out.println(activeUser.getUserInfo());
    }

}
