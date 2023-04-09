package com.cbtutor.askme.helper;

import com.cbtutor.askme.modal.Request;

public class HoldRequestStatus implements RequestStatus{

    private static volatile RequestStatus requestStatus;

    public static RequestStatus getHoldRequestStatusInstance(){
        if(requestStatus == null){
            synchronized (HoldRequestStatus.class){
                if(requestStatus == null){
                    return new HoldRequestStatus();
                }
            }
        }
        return requestStatus;
    }

    @Override
    public void updateRequestStatus(Request request) {
        System.out.println("Request is on Hold!!");
    }
}
