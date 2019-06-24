package com.gmail.yuramitryhin.model;

public class User {
    private String name;
    private String login;
    private String mail;

    public User() {
    }

    public User(String name, String login, String mail) {
        this.name = name;
        this.login = login;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
