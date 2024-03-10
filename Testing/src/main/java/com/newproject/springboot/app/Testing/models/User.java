package com.newproject.springboot.app.Testing.models;

public class User {
    private String name;
    private String lastname;

    private String email;

    public User() {
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;

    }

    public User(String name, String lastname, String email) {
        this(name, lastname); //como ya se tiene el constructor con name y lastname se llama a ese constructor en ve de poner el this con cada parametro
        this.email = email;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }


}
