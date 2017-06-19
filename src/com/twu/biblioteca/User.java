package com.twu.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    private String name = "Unavailable";
    private String email = "Unavailable";
    private String phone = "Unavailable";

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserInfo() {
        return name + '\t' + email + '\t' + phone;
    }

    public boolean testCredentials(String libraryNumber, String password) {

        return libraryNumber.equals(this.libraryNumber) && password.equals(this.password);

    }


}
