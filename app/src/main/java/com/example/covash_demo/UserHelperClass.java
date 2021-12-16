package com.example.covash_demo;

public class UserHelperClass {
    String Name, Username , Email , Password , FullName, Number,Id,Country;

    public UserHelperClass(){

    }

    public UserHelperClass(String name, String username, String email, String password, String fullName, String number, String id, String country) {
        Name = name;
        Username = username;
        Email = email;
        Password = password;
        FullName = fullName;
        Number = number;
        Id = id;
        Country = country;
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

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
