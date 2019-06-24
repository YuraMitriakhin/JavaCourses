package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.model.Model;
import com.gmail.yuramitryahin.model.entity.PassengerCarriage;
import com.gmail.yuramitryahin.model.entity.Train;
import com.gmail.yuramitryahin.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.gmail.yuramitryahin.view.MessageText.*;

public class Controller {
     Model mode;
     View view;

    public Controller(Model mode, View view) {
        this.mode = mode;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();
        addLocomotive(sc,train);
        addCarriage(sc, train);

        System.out.println(train);
        System.out.println(sort(train.getPassengerCarriages()));
        System.out.println(findCarriageOfNumPass(sc, train));

    }

    public void addLocomotive(Scanner sc, Train train){
        CreateTrain createTrain = new CreateTrain(sc, view);
        train.addLocomotive(createTrain.inputTrain());
    }

    public void  addCarriage(Scanner sc, Train train){
       train.addPassengerCarriages(chooseCarriage(sc));
        view.printMessage(CONTINUE_INPUT_CARRIAGE);
       while (true){
           String line = sc.nextLine();
           if(line.equals("y")){
               train.addPassengerCarriages(chooseCarriage(sc));
           }else if (line.equals("n")){
               break;
           }else{
               view.printMessage(WRONG_VALUES);
               view.printMessage(CONTINUE_INPUT_CARRIAGE);
           }

       }
    }

    public PassengerCarriage chooseCarriage(Scanner sc){
        CreateCarriage createCarriage = new CreateCarriage(view, sc);
        return createCarriage.inputCarriage();
    }

    public List<PassengerCarriage> findCarriageOfNumPass(Scanner sc, Train train){
        view.printMessage(INPUT_MIN_VALUE);
        while (true){
            int min=sc.nextInt();
            if(min<0){
                view.printMessage(WRONG_VALUES,INPUT_MIN_VALUE);
            }else{
                view.printMessage(INPUT_MAX_VALUE);
                int max = sc.nextInt();
                return train.findCarriage(min,max);
            }
        }
    }

    public ArrayList<PassengerCarriage> sort(List<PassengerCarriage> list){

        PassengerCarriage[]array=new PassengerCarriage[list.size()];
        list.toArray(array);

        for(int i=0; i<array.length; i++) {
            for (int j = 0; j < array.length - i-1; j++) {
                if (array[j].compareTo(array[j+1]) == 1) {
                    PassengerCarriage k = array[j];
                    array[j] = array[j+1];
                    array[j+1] = k;
                }
            }
        }
        return new ArrayList<>(Arrays.asList(array));
    }

}
