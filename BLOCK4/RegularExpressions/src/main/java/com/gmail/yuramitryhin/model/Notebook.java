package com.gmail.yuramitryhin.model;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private static Notebook notebook;
    private List<User> list;

    private Notebook(){
        list=new ArrayList<User>();
    }

    public static Notebook getInstance(){
        if(notebook==null){
            notebook=new Notebook();
        }
        return notebook;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
