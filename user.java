package org.example.banksystem.dao;



public class user {
    private static String Name;
    private static String mail;
    private static String password;

    public user() {

        Name = "";
        mail = "";
        password = "";

    }

    public  String getName() {
        return Name;
    }

    public  String getMail() {
        return mail;
    }

    public  String getPassword() {
        return password;
    }

    public String toString() {
        return "Name: " + Name + "\nmail: " + mail + "\npassword :" + password;
    }


}


