package com.cbtutor.askme.helper;

import com.cbtutor.askme.modal.Request;

public class CancelledRequestStatus implements RequestStatus{

    private static volatile RequestStatus requestStatus;

    public static RequestStatus getCancelledRequestStatusInstance(){
        if(requestStatus == null){
            synchronized (CancelledRequestStatus.class){
                if(requestStatus == null){
                    return new CancelledRequestStatus();
                }
            }
        }
        return requestStatus;
    }

    @Override
    public void updateRequestStatus(Request request) {
        System.out.println("Request is Cancelled!!");
    }
}
