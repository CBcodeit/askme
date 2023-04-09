package com.cbtutor.askme.service;

import com.cbtutor.askme.enums.Topic;
import com.cbtutor.askme.helper.RequestQueue;
import com.cbtutor.askme.helper.RequestQueueImpl;
import com.cbtutor.askme.modal.Request;
import com.cbtutor.askme.modal.Slot;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RequestManagementService {

    private RequestQueue requestQueue;

    public RequestManagementService(){
        requestQueue = RequestQueueImpl.getRequestQueueImplInstance();
    }

    private Request createRequest(Topic topic,String description, Slot requestedSlot){
        Request request = new Request(topic,description,requestedSlot);
        return request;
    }

    public Request raiseRequest(Topic topic,String description, Slot requestedSlot){

        /*
            1. create request
            2. add request to queue
         */
        Request request = null;
        try{
            request = createRequest(topic,description,requestedSlot);
        }catch(Exception e){
            System.out.println("Could not create request");
        }

        //add request to Queue so that queue can push notifications to it's subscribers(TAs)
        try{
            requestQueue.publish(request);
        }catch(Exception e){
            System.out.println("Could not create request");
        }

        return request;
    }

    public Request cancelRequest(Request request){
        //remove request from Queue
        //
        //....

        return request;
    }

}
