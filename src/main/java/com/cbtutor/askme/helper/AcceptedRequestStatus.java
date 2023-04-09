package com.cbtutor.askme.helper;

import com.cbtutor.askme.modal.Request;

public class AcceptedRequestStatus implements RequestStatus{

    private static volatile RequestStatus requestStatus;

    public static RequestStatus getAcceptedRequestStatusInstance(){
        if(requestStatus == null){
            synchronized (AcceptedRequestStatus.class){
                if(requestStatus == null){
                    return new AcceptedRequestStatus();
                }
            }
        }
        return requestStatus;
    }

    @Override
    public void updateRequestStatus(Request request) {
        request.setCurrentRequestStatus(ResolvedRequestStatus.getResolvedRequestStatusInstance());
        System.out.println("Request is resolved!!");
    }
}
