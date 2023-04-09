package com.cbtutor.askme.modal;

import com.cbtutor.askme.enums.Topic;
import com.cbtutor.askme.helper.RequestQueue;
import com.cbtutor.askme.helper.RequestQueueImpl;
import com.cbtutor.askme.service.RequestManagementService;
import com.cbtutor.askme.service.UserService;

import java.util.List;

public class Driver {

//    private static UserService userService = new UserService();


    public static void main(String a[]){

        System.out.print("Hi");

        //get producers and consumers set ready
        List<Student> students = UserService.createStudent();
        List<TeachingAssistant> teachingAssistants = UserService.createTeachingAssistant();

        //get queue
        RequestQueue requestQueue = RequestQueueImpl.getRequestQueueImplInstance();
        //add consumers/subscribers to queue
        teachingAssistants.forEach(ta -> requestQueue.attach(ta));


        //ask students to raise requests
        Request request = null;
        request = students.get(0).getRequestManagementService().raiseRequest(Topic.ADMISSION,"When does admission starts?",new Slot("11.30",true,false));
        students.get(0).getRequestSet().add(request);

        request = students.get(1).getRequestManagementService().raiseRequest(Topic.LLD,"What is abstraction in oops?",new Slot("12.00",true,false));
        students.get(1).getRequestSet().add(request);

        request = students.get(2).getRequestManagementService().raiseRequest(Topic.HLD,"How laod balancers work?",new Slot("2.30",true,false));
        students.get(2).getRequestSet().add(request);

        request = students.get(0).getRequestManagementService().raiseRequest(Topic.DSA,"how to implement stack using queue?",new Slot("2.30",true,false));
        students.get(0).getRequestSet().add(request);

        //ask Students to cancel request
        students.get(0).getRequestSet().g getRequestManagementService().cancelRequest()
    }
}
