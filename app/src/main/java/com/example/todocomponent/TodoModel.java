package com.example.todocomponent;

import java.util.ArrayList;
import java.util.UUID;

public class TodoModel {

    private static TodoModel sTodoModel;

    public static TodoModel getInstance(){
        if(sTodoModel == null){
            sTodoModel = new TodoModel();
        }
        return sTodoModel;
    }

    private ArrayList<Todo> todosList;

    private  TodoModel() {
        todosList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Todo todo = new Todo();
            todo.setTitle("Todo title: "+ i);
            todo.setDetail("Todo description: " + i);
            todo.setComplete(false);
            todosList.add(todo);
        }
    }

    public ArrayList<Todo> getTodosList(){
        return todosList;
    }

    public Todo getTodo(UUID id){
        for (Todo todo : todosList){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    public void addTodo(Todo todo){
        todo.setTitle("Todo title: "+ (todosList.size()+1));
        todo.setDetail("Todo description: " + (todosList.size()+1));

        todosList.add(todo);
    }

    public void delete(UUID id){
        Todo todo  = getTodo(id);
        todosList.remove(todo);
    }
}
