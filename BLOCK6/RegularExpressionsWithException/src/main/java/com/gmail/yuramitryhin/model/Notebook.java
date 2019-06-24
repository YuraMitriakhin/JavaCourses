package com.gmail.yuramitryhin.model;

import com.gmail.yuramitryhin.NotUniqueLoginException;

public class Notebook {
    private String name;
    private String login;
    private String mail;

    public Notebook() {
    }

    public Notebook(String name, String login, String mail) throws NotUniqueLoginException {
        this.name = name;
        if (DBNotebook.checkLogin(login)){
            throw new NotUniqueLoginException("Not Unique Login", login);
        }else {
            this.login = login;
        }

        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public Notebook setName(String name) {
        this.name = name;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Notebook setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Notebook setMail(String mail) {
        this.mail = mail;
        return this;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
