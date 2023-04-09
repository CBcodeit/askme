package com.cbtutor.askme.helper;

import com.cbtutor.askme.modal.Request;
import com.cbtutor.askme.modal.TeachingAssistant;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RequestQueueImpl implements RequestQueue{

    //ideally not-singleton as multiple queues can exist handling specific requests

    //but for now simplicity lets keep only one queue
    private static volatile RequestQueueImpl requestQueueImpl;
    private List<TeachingAssistant> teachingAssistantList;
    private List<Request> requestList;
    private RequestQueueImpl(){
        this.teachingAssistantList = new ArrayList<>();
        this.requestList = new ArrayList<>();
    }

    public static RequestQueueImpl getRequestQueueImplInstance(){
        if(requestQueueImpl == null){
            synchronized (RequestQueueImpl.class){
                if(requestQueueImpl==null){
                    requestQueueImpl = new RequestQueueImpl();
                }
            }
        }
        return requestQueueImpl;
    }

    @Override
    public void attach(TeachingAssistant teachingAssistant) {
        teachingAssistantList.add(teachingAssistant);
    }

    @Override
    public void detach(TeachingAssistant teachingAssistant) {
        teachingAssistantList.remove(teachingAssistant);
    }

    @Override
    public void publish(Request request){
        requestList.add(request);
        notifyUpdate(request);
    }
    @Override
    public void notifyUpdate(Request request) {
        for (TeachingAssistant teachingAssistant : teachingAssistantList) {
            teachingAssistant.update(request);
        }
    }
}
