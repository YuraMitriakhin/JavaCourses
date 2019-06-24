package com.gmail.yuramitryhin;

import com.gmail.yuramitryhin.controller.Controller;
import com.gmail.yuramitryhin.model.Model;
import com.gmail.yuramitryhin.view.View;

public class Main {
    public static void main(String[] args){
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view,model);
        controller.process();
    }
}
