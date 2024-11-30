package com.alcp.calendar.dto;

import lombok.Getter;
import java.util.Date;

@Getter
public class ScheduleRequestDto {
    private String name;
    private String password;
    private String todo;
    private String date;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
