package com.gmail.yuramitryahin.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    static String MESSAGES_BUNDLE_NAME = "messages";
   public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                   // new Locale("ua", "UA"));  // Ukrainian
                    new Locale("en"));        // English


    public void  printMessage(String message){
        System.out.println(message);
    }

    public void  printMessageWithoutSeparator(String message){
        System.out.print(message);
    }

    public void printMessage(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String s : message) {
            concatString = concatString.append("\n").append(s);
        }
        System.out.println(concatString.toString());
    }

    public void printStringInput(String message) {
        printMessage(
                bundle.getString(message));
    }


}
