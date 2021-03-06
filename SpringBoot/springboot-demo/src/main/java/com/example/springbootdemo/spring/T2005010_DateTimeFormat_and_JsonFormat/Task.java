package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;

import javax.validation.constraints.NotBlank;

public class Task {
 
    @NotBlank(message = "Task name must not be blank!")
    private String name;
 
    @NotBlank(message = "Task description must not be blank!")
    private String description;
 
    public Task() {
    }
 
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
}
