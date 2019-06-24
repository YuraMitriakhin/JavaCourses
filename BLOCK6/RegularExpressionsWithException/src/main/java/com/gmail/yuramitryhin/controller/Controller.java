package com.gmail.yuramitryhin.controller;

import com.gmail.yuramitryhin.NotUniqueLoginException;
import com.gmail.yuramitryhin.RegularProperties;
import com.gmail.yuramitryhin.model.DBNotebook;
import com.gmail.yuramitryhin.model.Notebook;
import com.gmail.yuramitryhin.view.Messages;
import com.gmail.yuramitryhin.view.UAMessages;
import com.gmail.yuramitryhin.view.View;
import com.gmail.yuramitryhin.model.Model;

import java.util.Scanner;

/**
 * Class with properties <b>view</b> <b>model</b> and <b>messages</b>
 * @author Yura Mitryakhin
 */
public class Controller {

    /** Interface field */
    private View view;

    /** Business logic field*/
    private Model model;

    /** Message field*/
    private Messages messages;

    /**
     * Constructor create a new object
     * @param view
     * @param model
     * field messages for select the interface language
     */
    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
        this.messages = new UAMessages();
        //this.messages = new ENMessages();  English language
    }


    public void process(){
        Scanner sc = new Scanner(System.in);
        Notebook inputNotebook = new Notebook();
        inputNotebook.setName(checkMessage(sc, messages.INPUT_NAME, RegularProperties.uaName));
        inputNotebook.setMail(checkMessage(sc, messages.INPUT_EMAIL, RegularProperties.mail));
        inputNotebook.setLogin(checkMessage(sc, messages.INPUT_LOGIN, RegularProperties.login));
        inputNotebook = checkLogin(sc,inputNotebook);
        view.printMessage(inputNotebook.toString());

    }

    /**
     * Function shows user what he needs to enter
     * @param sc scanner
     * @param message output message
     * @param regular regular expression
     * @return input string
     */
    public String checkMessage(Scanner sc, String message, String regular){
        view.printMessage(message);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(checkWord(line, regular)){
                return line;
            }else{
                view.printMessage(messages.WRONG_INPUT, message);
            }
        }
        return null;
    }

    /**
     * Function check the input line for regular expression matches
     * @param text
     * @param regular
     * @return true ir false
     */
    public boolean checkWord(String text, String regular){
        if (text.matches(regular)){
            return true;
        }
        return false;
    }


    public Notebook checkLogin(Scanner sc, Notebook inputNotebook){
        Notebook notebook=null;
        while (true){
            try {
                notebook = new Notebook(inputNotebook.getName(), inputNotebook.getLogin(), inputNotebook.getMail());
                break;
            }catch (NotUniqueLoginException e){
                e.printStackTrace();
                view.printMessage(messages.WRONG_LOGIN, e.getLogin());
                inputNotebook.setLogin(checkMessage(sc, messages.INPUT_LOGIN, RegularProperties.login));
            }
        }
        return  notebook;
    }
}
