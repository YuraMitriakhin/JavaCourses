package com.gmail.yuramitryhin.view;

public class UAMessages extends Messages {
     String INPUT_NAME = "Введіть ім'я:";
     String INPUT_LOGIN = "Введіть логін:";
     String INPUT_EMAIL = "Введіть електрону адресу:";
     String WRONG_INPUT = "Некоректний ввід! Повторіть будь ласка!";

    public UAMessages(){
        super.INPUT_NAME=INPUT_NAME;
        super.INPUT_LOGIN = INPUT_LOGIN;
        super.INPUT_EMAIL=INPUT_EMAIL;
        super.WRONG_INPUT=WRONG_INPUT;
    }
}
