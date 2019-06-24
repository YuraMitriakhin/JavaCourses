package com.gmail.yuramitryhin.view;

import java.util.Arrays;

public class View {

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessage(String... message){
        StringBuilder st = new StringBuilder();
        for (String s: message) {
            st.append(s).append("\n");
        }
        System.out.println(st.toString());
    }
}
