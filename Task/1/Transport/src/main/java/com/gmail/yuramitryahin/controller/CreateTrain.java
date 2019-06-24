package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.model.NotFoundIDException;
import com.gmail.yuramitryahin.model.WrongInputException;
import com.gmail.yuramitryahin.model.entity.ListLocomotive;
import com.gmail.yuramitryahin.model.entity.Locomotive;
import com.gmail.yuramitryahin.view.View;

import java.util.Scanner;

import static com.gmail.yuramitryahin.RegularProperties.NUM;
import static com.gmail.yuramitryahin.view.MessageText.*;

public class CreateTrain {
    private Scanner sc;
    private View view;

    public CreateTrain(Scanner sc, View view) {
        this.sc = sc;
        this.view = view;
    }

    /**
     * Locomotive selection function
     * @return
     */
    public Locomotive inputTrain(){
        view.printStringInput(LOCOMOTIVES);
        printListLomotive();

        view.printStringInput(CHOOSE_LOCOMOTIVE);
        ListLocomotive locomotive;

        while (true){
            String id = sc.nextLine();
            try {
                checkInputLine(id, NUM);
                    locomotive = checkID(Integer.parseInt(id));
                    return convert(locomotive);

            } catch (NotFoundIDException e) {
                e.printStackTrace();
                view.printStringInput(WRONG_ID);
                view.printStringInput(CHOOSE_LOCOMOTIVE);
            } catch (WrongInputException e) {
                view.printStringInput(WRONG_VALUES);
                view.printStringInput(CHOOSE_LOCOMOTIVE);
                e.printStackTrace();
            }
        }
    }

    /**
     * Function which print all locomotives
     */
    private void printListLomotive(){
        for (ListLocomotive l: ListLocomotive.values()) {
            view.printMessage(l.toString());
        }
    }

    /**
     * Check id locomotive function
     * @param id
     * @return
     * @throws NotFoundIDException
     */
    private ListLocomotive checkID(int id) throws NotFoundIDException {
        for (ListLocomotive l: ListLocomotive.values()) {
            if(id==l.getIDTransport()){
                return l;
            }
        }
        throw new NotFoundIDException(WRONG_ID);
    }

    /**
     * Convert element list locomotive to class locomotive
     * @param listLocomotive
     * @return
     */
    private Locomotive convert(ListLocomotive listLocomotive){
        Locomotive locomotive = new Locomotive(listLocomotive.getIDTransport(), listLocomotive.getColor(), listLocomotive.getWeight(), listLocomotive.getPower(), listLocomotive.getMaxNumberOfCarriage());
        return locomotive;
    }

    /**
     * Validation the entered data for regular expression
     * @param line
     * @param regular
     * @throws WrongInputException
     */
    private void checkInputLine(String line, String regular) throws WrongInputException {
        if (line.matches(regular)){
            return;
        }
        throw new WrongInputException(WRONG_VALUES);
    }
}
