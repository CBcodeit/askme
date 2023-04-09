package com.cbtutor.askme.modal;

import com.cbtutor.askme.enums.Topic;
import com.cbtutor.askme.helper.RaisedRequestStatus;
import com.cbtutor.askme.helper.RequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
public class Request {
    private int id;

    private RequestStatus currentRequestStatus;

    @Enumerated(EnumType.STRING)
    private Topic topic;

    private String description;

    private Slot slot;

    public Request(Topic topic,String description,Slot slot){
        this.topic = topic;
        this.description = description;
        this.slot = slot;
        if(currentRequestStatus == null){
            currentRequestStatus = RaisedRequestStatus.getRaisedRequestStatusInstance();
        }
    }

}

/*

    Raised --> Accepted --> Resolved

    Hold
    Cancelled



 */
