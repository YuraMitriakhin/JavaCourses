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
     Model model;
     View view;

    /**
     * Constructor create a new object
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Function which start all processes
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();
        addLocomotive(sc,train);
        addCarriage(sc, train);

        view.printMessage(train.toString());
        view.printMessage("All passenger = "+ train.numPassengers()+  "\n All larges = "+ train.numLuggages());
        view.printMessage(sort(train.getPassengerCarriages()).toString());
        view.printMessage(findCarriageOfNumPass(sc, train).toString());

    }

    /**
     * Function to add locomotive in train
     * @param sc
     * @param train
     */
    public void addLocomotive(Scanner sc, Train train){
        CreateTrain createTrain = new CreateTrain(sc, view);
        train.addLocomotive(createTrain.inputTrain());
    }

    /**
     * Function to add carriage in train
     * @param sc
     * @param train
     */
    public void  addCarriage(Scanner sc, Train train){
       train.addPassengerCarriages(chooseCarriage(sc));
        view.printStringInput(CONTINUE_INPUT_CARRIAGE);
       while (true){
           String line = sc.nextLine();
           if(line.equals("y")){
               train.addPassengerCarriages(chooseCarriage(sc));
           }else if (line.equals("n")){
               break;
           }else{
               view.printStringInput(WRONG_VALUES);
               view.printStringInput(CONTINUE_INPUT_CARRIAGE);
           }

       }
    }

    /**
     * Function to select the type of Carriage
     * @param sc
     * @return
     */
    public PassengerCarriage chooseCarriage(Scanner sc){
        CreateCarriage createCarriage = new CreateCarriage(view, sc);
        return createCarriage.inputCarriage();
    }

    /**
     * Function to search the carriage by the number of passengers
     * @param sc
     * @param train
     * @return
     */
    public List<PassengerCarriage> findCarriageOfNumPass(Scanner sc, Train train){
        view.printStringInput(INPUT_MIN_VALUE);
        while (true){
            int min=sc.nextInt();
            if(min<0){
                view.printStringInput(WRONG_VALUES);
                view.printStringInput(INPUT_MIN_VALUE);
            }else{
                view.printStringInput(INPUT_MAX_VALUE);
                int max = sc.nextInt();
                return train.findCarriage(min,max);
            }
        }
    }

    /**
     * Function to sort the list of carriages for comfort
     * @param list
     * @return
     */
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
