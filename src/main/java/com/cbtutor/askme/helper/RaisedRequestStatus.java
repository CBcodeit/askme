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
        if(requestStatus instanceof AcceptedRequestStatus) {
            request.setCurrentRequestStatus(AcceptedRequestStatus.getAcceptedRequestStatusInstance());
            System.out.println("Request is accepted!!");
            return;
        }

        if(requestStatus instanceof CancelledRequestStatus) {
            request.setCurrentRequestStatus(CancelledRequestStatus.getCancelledRequestStatusInstance());
            System.out.println("Request is cancelled!!");
            return;
        }

        if(requestStatus instanceof HoldRequestStatus) {
            request.setCurrentRequestStatus(HoldRequestStatus.getHoldRequestStatusInstance());
            System.out.println("Request is on Hold!!");
            return;
        }
    }
}
