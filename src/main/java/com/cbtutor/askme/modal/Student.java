package com.cbtutor.askme.modal;

import com.cbtutor.askme.service.RequestManagementService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student extends User{
    private double score;
    private RequestManagementService requestManagementService = new RequestManagementService();

    public Student(int id, String name, double score){
        super(id,name);
        this.score = score;
    }


}
