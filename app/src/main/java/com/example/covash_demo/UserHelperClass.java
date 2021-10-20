package com.example.covash_demo;

public class UserHelperClass {
    String Name, Username , Email , Password;

    public UserHelperClass(){

    }

    public UserHelperClass(String name, String username, String email, String password) {
        Name = name;
        Username = username;
        Email = email;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
