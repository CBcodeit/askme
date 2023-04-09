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

        System.out.print("I am Driver. Let's Go and explore AskMe");

        //get producers and consumers set ready
        List<Student> students = UserService.createStudent();
        List<TeachingAssistant> teachingAssistants = UserService.createTeachingAssistant();

        //get queue
        RequestQueue requestQueue = RequestQueueImpl.getRequestQueueImplInstance();
        //add consumers/subscribers to queue
        teachingAssistants.forEach(ta -> requestQueue.attach(ta));


        //ask students to raise requests
        Request request = null;
        Request request0 = students.get(0).getRequestManagementService().raiseRequest(1,Topic.ADMISSION,"When does admission starts?",new Slot("11.30",true,false));
        students.get(0).getRequestSet().add(request0);

        Request request1 = students.get(1).getRequestManagementService().raiseRequest(2,Topic.LLD,"What is abstraction in oops?",new Slot("12.00",true,false));
        students.get(1).getRequestSet().add(request1);

        Request request2 = students.get(2).getRequestManagementService().raiseRequest(3,Topic.HLD,"How laod balancers work?",new Slot("2.30",true,false));
        students.get(2).getRequestSet().add(request2);

        Request request4 = students.get(0).getRequestManagementService().raiseRequest(4,Topic.DSA,"how to implement stack using queue?",new Slot("2.30",true,false));
        students.get(0).getRequestSet().add(request4);

        //ask Students to cancel request
        cancelRequest(request4,students.get(0));

        //ask Students to hold request
        holdRequest(request4,students.get(0));



    }

    public static void cancelRequest(Request requestToBeCancelled, Student student){
        Request requestCanceled = null;
        for (Request req : student.getRequestSet()) {
            if(req.equals(requestToBeCancelled)){
                requestCanceled = student.getRequestManagementService().cancelRequest(req);
                break;
            }
        }
        if(requestCanceled!=null){
            student.getRequestSet().remove(requestCanceled);
            System.out.println("Request successfully removed from students request list. " +
                    "Request details: "+requestCanceled);
        }
    }

    public static void holdRequest(Request requestToBeHeld, Student student){
        Request requestHeld = null;
        for (Request req : student.getRequestSet()) {
            if(req.equals(requestToBeHeld)){
                requestHeld = student.getRequestManagementService().holdRequest(req);
                break;
            }
        }

    }
}
