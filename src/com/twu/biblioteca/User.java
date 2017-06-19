package com.twu.biblioteca;

public class User {

    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean testCredentials(String libraryNumber, String password) {

        return libraryNumber.equals(this.libraryNumber) && password.equals(this.password);

    }

}
