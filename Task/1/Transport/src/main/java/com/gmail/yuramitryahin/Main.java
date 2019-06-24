package com.gmail.yuramitryahin;

import com.gmail.yuramitryahin.controller.Controller;
import com.gmail.yuramitryahin.model.Model;
import com.gmail.yuramitryahin.view.View;

public class Main {
    public static void main(String[]args){
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model,view);
        controller.processUser();
    }
}
