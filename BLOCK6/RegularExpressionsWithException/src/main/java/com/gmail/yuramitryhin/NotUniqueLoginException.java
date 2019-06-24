package com.gmail.yuramitryhin;

public class NotUniqueLoginException extends  Exception {
    private String login;
    public String getLogin(){return login;}

    public  NotUniqueLoginException(String message, String login){
        super(message);
        this.login=login;
    }
}
