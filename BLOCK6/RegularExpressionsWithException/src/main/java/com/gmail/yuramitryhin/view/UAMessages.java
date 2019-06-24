package com.gmail.yuramitryhin.view;

public class UAMessages extends Messages {
     private String INPUT_NAME = "Введіть ім'я:";
     private String INPUT_LOGIN = "Введіть логін:";
     private String INPUT_EMAIL = "Введіть електрону адресу:";
     private  String WRONG_INPUT = "Некоректний ввід! Повторіть будь ласка!";
     private String WRONG_LOGIN = "Не унікальний логін! Повторіть будь ласка!";

    public UAMessages(){
        super.INPUT_NAME=INPUT_NAME;
        super.INPUT_LOGIN = INPUT_LOGIN;
        super.INPUT_EMAIL=INPUT_EMAIL;
        super.WRONG_INPUT=WRONG_INPUT;
        super.WRONG_LOGIN=WRONG_LOGIN;
    }
}
