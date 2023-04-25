package com.example.todocomponent;

import java.util.Date;
import java.util.UUID;

public class Todo {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    private UUID id;
    private String title;
    private String detail;
    private Date date;
    private boolean isComplete;

    public Todo() {
        id = UUID.randomUUID();
        date = new Date();
    }


}
