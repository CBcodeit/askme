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

    private Request createRequest(int requestId, Topic topic,String description, Slot requestedSlot){
        Request request = new Request(requestId,topic,description,requestedSlot);
        return request;
    }

    public Request raiseRequest(int requestId,Topic topic,String description, Slot requestedSlot){
        //create request
        Request request = null;
        try{
            request = createRequest(requestId,topic,description,requestedSlot);
        }catch(Exception e){
            System.out.println("Could not create request. Some Exception occurred: "+e.getMessage());
        }

        //add request to Queue so that queue can push notifications to it's subscribers(TAs)
        try{
            requestQueue.publish(request);
        }catch(Exception e){
            System.out.println("Could not publish request. Some Exception occurred: "+e.getMessage());
        }

        return request;
    }

    public Request cancelRequest(Request request){
        //remove request from Queue
        //
        //....
        Request cancelledRequest = null;
        try{
            boolean isRequestRemoved = requestQueue.getRequestList().remove(request);
            if(isRequestRemoved)
               cancelledRequest = request;
        }catch(Exception e){
            System.out.println("Could not cancel request. Some exception occurred: "+e.getMessage());
        }
        return cancelledRequest;
    }

    public Request holdRequest(Request request) {
        //.....
        Request heldRequest = null;
        try{
            boolean isRequestHeld = requestQueue.getRequestList().remove(request);
            if(isRequestHeld)
                heldRequest = request;
        }catch(Exception e){
            System.out.println("Could not held request. Some exception occurred: "+e.getMessage());
        }
        return heldRequest;
    }
}
