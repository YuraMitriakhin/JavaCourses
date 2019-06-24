package com.gmail.yuramitryhin.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<User> notebook = Notebook.getInstance().getList();

    public Model() {
    }

    public void addUser(User user){
        notebook.add(user);
    }

    public List<User> getNotebooks() {
        return notebook;
    }

    public void setNotebooks(List<User> notebook) {
        this.notebook = notebook;
    }
}
