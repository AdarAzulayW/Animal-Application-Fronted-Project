package com.example.ourfinalapp.Model;

public class Users {
    public String FirstName , LastName, Email , Password, Id;

    public Users(String firstName, String lastName, String email, String password, String id) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        Id = id;
    }

    public Users(){
    }
}
