package com.cbtutor.askme.helper;

import com.cbtutor.askme.modal.Request;

public class RaisedRequestStatus implements RequestStatus{

    private static volatile RequestStatus requestStatus;

    public static RequestStatus getRaisedRequestStatusInstance(){
        if(requestStatus == null){
            synchronized (RaisedRequestStatus.class){
                if(requestStatus == null){
                    return new RaisedRequestStatus();
                }
            }
        }
        return requestStatus;
    }

    @Override
    public void updateRequestStatus(Request request,RequestStatus requestStatus) {
        if(requestStatus.equals())
        //accept request
        request.setCurrentRequestStatus(AcceptedRequestStatus.getAcceptedRequestStatusInstance());
        System.out.println("Request is accepted!!");
    }
}
