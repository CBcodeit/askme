package com.cbtutor.askme.modal;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private Set<Request> requestSet;

    private Set<Slot> slotSet;

    public User(int id, String name){
        this.id = id;
        this.name = name;
        requestSet = new HashSet<>();
    }
}
