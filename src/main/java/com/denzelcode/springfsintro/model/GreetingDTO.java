package com.denzelcode.springfsintro.model;

public class GreetingDTO {

    private Integer Id;
    private String greeting;

    public GreetingDTO() {
    }

    public GreetingDTO(String greeting) {
        this.greeting = greeting;
    }

    public GreetingDTO(Integer id, String greeting) {
        Id = id;
        this.greeting = greeting;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
