package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.model.NotFoundIDException;
import com.gmail.yuramitryahin.model.entity.ListLocomotive;
import com.gmail.yuramitryahin.model.entity.Locomotive;
import com.gmail.yuramitryahin.view.View;

import java.util.Scanner;

import static com.gmail.yuramitryahin.view.MessageText.*;

public class CreateTrain {
    private Scanner sc;
    private View view;

    public CreateTrain(Scanner sc, View view) {
        this.sc = sc;
        this.view = view;
    }

    public Locomotive inputTrain(){
        view.printMessage("Locomotives:");
        printListLomotive();

        view.printMessage(CHOOSE_LOCOMOTIVE);
        ListLocomotive locomotive;

        while (true){
            int id = sc.nextInt();
            try {
                 locomotive = checkID(id);
                return convert(locomotive);
            } catch (Exception e) {
                e.printStackTrace();
                view.printMessage(WRONG_ID, CHOOSE_LOCOMOTIVE);
            }
        }
    }

    private void printListLomotive(){
        for (ListLocomotive l: ListLocomotive.values()) {
            view.printMessage(l.toString());
        }
    }

    private ListLocomotive checkID(int id) throws NotFoundIDException {
        for (ListLocomotive l: ListLocomotive.values()) {
            if(id==l.getIDTransport()){
                return l;
            }
        }
        throw new NotFoundIDException(WRONG_ID);
    }

    private Locomotive convert(ListLocomotive listLocomotive){
        Locomotive locomotive = new Locomotive(listLocomotive.getIDTransport(), listLocomotive.getColor(), listLocomotive.getWeight(), listLocomotive.getPower(), listLocomotive.getMaxNumberOfCarriage());
        return locomotive;
    }

}
