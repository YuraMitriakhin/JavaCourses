package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.model.entity.ListCarriage;
import com.gmail.yuramitryahin.model.entity.PassengerCarriage;
import com.gmail.yuramitryahin.view.View;

import java.util.List;
import java.util.Scanner;

import static com.gmail.yuramitryahin.view.MessageText.*;
import static com.gmail.yuramitryahin.view.MessageText.CHOOSE_LOCOMOTIVE;

public class CreateCarriage {
    private Scanner sc;
    private View view;

    public CreateCarriage( View view, Scanner sc) {
        this.sc = sc;
        this.view = view;
    }

    public PassengerCarriage inputCarriage(){
        ListCarriage listCarriage = ListCarriage.getInstance();
        List<PassengerCarriage> list = listCarriage.getListCarriage();

        showArrayCarriage(list);
        return chooseCarriage(list);

    }

    public void showArrayCarriage(List<PassengerCarriage> list){
        view.printMessage(CHOOSE_CARRIAGE);

        int k=1;
        for (PassengerCarriage l: list){
            view.printMessage(k+" - " + l.toString());
            k++;
        }
    }

    public PassengerCarriage chooseCarriage(List<PassengerCarriage> list){
        view.printMessage(INPUT_CARRIAGE_NUM+" (1-"+list.size()+"):");
        while (true){
            int num = sc.nextInt();
            if(num<=0||num>list.size()){
                view.printMessage(WRONG_NUM);
                view.printMessage(INPUT_CARRIAGE_NUM+" (1-"+list.size()+"):");
            }else{
                return list.get(num-1);
            }
        }
    }
}
