package com.gmail.yuramitryhin.view;

public class ENMessages extends Messages {
    private String INPUT_NAME = "Input name:";
    private String INPUT_LOGIN = "Input login:";
    private String INPUT_EMAIL = "Input email:";
    private String WRONG_INPUT = "Incorrect input! Repeat please!";
    private String WRONG_LOGIN = "Not unique login! Repeat please!";

    public ENMessages(){
        super.INPUT_NAME=INPUT_NAME;
        super.INPUT_LOGIN=INPUT_LOGIN;
        super.INPUT_EMAIL=INPUT_EMAIL;
        super.WRONG_INPUT=WRONG_INPUT;
        super.WRONG_LOGIN=WRONG_LOGIN;
    }
}
