package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.model.WrongInputException;
import com.gmail.yuramitryahin.model.entity.ListCarriage;
import com.gmail.yuramitryahin.model.entity.PassengerCarriage;
import com.gmail.yuramitryahin.view.View;

import java.util.List;
import java.util.Scanner;

import static com.gmail.yuramitryahin.RegularProperties.NUM;
import static com.gmail.yuramitryahin.view.MessageText.*;
import static com.gmail.yuramitryahin.view.MessageText.CHOOSE_LOCOMOTIVE;

public class CreateCarriage {
    private Scanner sc;
    private View view;

    public CreateCarriage( View view, Scanner sc) {
        this.sc = sc;
        this.view = view;
    }

    /**
     * Function for selection type of carriage
     * @return
     */
    public PassengerCarriage inputCarriage(){
        ListCarriage listCarriage = ListCarriage.getInstance();
        List<PassengerCarriage> list = listCarriage.getListCarriage();

        showArrayCarriage(list);
        return chooseCarriage(list);

    }

    /**
     * Function for output all carriages
     * @param list
     */
    public void showArrayCarriage(List<PassengerCarriage> list){
        view.printStringInput(CHOOSE_CARRIAGE);

        int k=1;
        for (PassengerCarriage l: list){
            view.printMessage(k+" - " + l.toString());
            k++;
        }
    }

    /**
     * Carriage select function
     * @param list
     * @return
     */
    public PassengerCarriage chooseCarriage(List<PassengerCarriage> list){
        view.printStringInput(INPUT_CARRIAGE_NUM);
        view.printMessageWithoutSeparator(" (1-"+list.size()+"):");
        while (true){
            String number = sc.nextLine();
            try {
                checkInputLine(number, NUM);
                int num = Integer.parseInt(number);
                if(num<=0||num>list.size()){
                    printEror(list.size());
                }else{
                    return list.get(num-1);
                }
            } catch (WrongInputException e) {
                e.printStackTrace();
                printEror(list.size());
            }

        }
    }

    /**
     * Validation the entered data for regular expression
     * @param line
     * @param regular
     * @throws WrongInputException
     */
    public void checkInputLine(String line, String regular) throws WrongInputException {
        if (line.matches(regular)){
            return;
        }
        throw new WrongInputException(WRONG_VALUES);
    }

    /**
     * Print wrong messages
     * @param k
     */
    private void printEror(int k){
        view.printStringInput(WRONG_NUM);
        view.printStringInput(INPUT_CARRIAGE_NUM);
        view.printMessageWithoutSeparator(" (1-"+k+"):");
    }
}
