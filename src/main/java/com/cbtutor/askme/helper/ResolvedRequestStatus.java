package com.cbtutor.askme.helper;

import com.cbtutor.askme.modal.Request;

public class ResolvedRequestStatus implements RequestStatus{

    private static volatile RequestStatus requestStatus;

    public static RequestStatus getResolvedRequestStatusInstance(){
        if(requestStatus == null){
            synchronized (ResolvedRequestStatus.class){
                if(requestStatus == null){
                    return new ResolvedRequestStatus();
                }
            }
        }
        return requestStatus;
    }

    @Override
    public void updateRequestStatus(Request request) {
        System.out.println("Request is Resolved!!");
    }
}
