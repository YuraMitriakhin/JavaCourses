package com.gmail.yuramitryhin.model;

public enum DBNotebook {

   ONE("Ivan", "Ivan123", "cat@gmail.com"),
    TWO("Ivan", "Ivan123", "cat@gmail.com"),
    THREE("Ivan", "Ivan123", "cat@gmail.com");

    private final String name;
    private final String login;
    private final String mail;

     DBNotebook(String name, String login, String mail){
        this.name=name;
        this.login=login;
        this.mail=mail;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
      return login;
    }

    public String getMail() {
       return mail;
    }

    public static boolean checkLogin(String loginData){
        for (DBNotebook note: DBNotebook.values()){
           if (note.getLogin().equals(loginData)){
               return true;
           }
        }
        return false;
    }

}
