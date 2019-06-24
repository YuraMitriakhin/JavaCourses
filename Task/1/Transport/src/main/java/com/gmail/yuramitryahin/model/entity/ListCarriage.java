package com.gmail.yuramitryahin.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ListCarriage {
    private static ListCarriage instance;
    private List<PassengerCarriage> listCarriage;

    private ListCarriage(){
        listCarriage = new ArrayList();
        ListFill();
    }

    public static ListCarriage getInstance(){
        if(instance==null){
            instance=new ListCarriage();
        }
        return instance;
    }

    private void ListFill(){
        listCarriage.add(new PassengerCarriage(3349564, "blue", 7000, 60, 80, CarriageComfort.COMPARTMENT));
        listCarriage.add(new PassengerCarriage(3349768, "blue", 6800, 40, 55, CarriageComfort.LUXURY));
        listCarriage.add(new PassengerCarriage(3345261, "green", 5500, 35, 0, CarriageComfort.RESTAURANT));
        listCarriage.add(new PassengerCarriage(3111160, "blue", 8000, 55, 60, CarriageComfort.RESERVER));
    }

    public List<PassengerCarriage> getListCarriage() {
        return listCarriage;
    }
}
