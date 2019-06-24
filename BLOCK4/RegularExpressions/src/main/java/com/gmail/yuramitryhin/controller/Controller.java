package com.gmail.yuramitryhin.controller;

import com.gmail.yuramitryhin.RegularProperties;
import com.gmail.yuramitryhin.model.User;
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

    /**
     * function to check the date and add client to the notebook {@link Model#addUser(User)}
     */
    public void process(){
        Scanner sc = new Scanner(System.in);
        User user = new User();
        user.setName(checkMessage(sc, messages.INPUT_NAME, RegularProperties.uaName));
        user.setLogin(checkMessage(sc, messages.INPUT_LOGIN, RegularProperties.login));
        user.setMail(checkMessage(sc, messages.INPUT_EMAIL, RegularProperties.mail));
        model.addUser(user);

        view.printMessage(""+model.getNotebooks().size());
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
}
