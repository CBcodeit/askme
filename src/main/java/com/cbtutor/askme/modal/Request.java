package com.cbtutor.askme.modal;

import com.cbtutor.askme.enums.Topic;
import com.cbtutor.askme.helper.RaisedRequestStatus;
import com.cbtutor.askme.helper.RequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

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

    public Request(int id, Topic topic,String description,Slot slot){
        this.id = id;
        this.topic = topic;
        this.description = description;
        this.slot = slot;
        if(currentRequestStatus == null){
            currentRequestStatus = RaisedRequestStatus.getRaisedRequestStatusInstance();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return getId() == request.getId() && getTopic() == request.getTopic() && Objects.equals(getDescription(), request.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTopic(),getDescription());
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", topic=" + topic +
                ", description='" + description + '\'' +
                ", slot=" + slot +
                '}';
    }
}

/*

    Raised --> Accepted --> Resolved

    Hold
    Cancelled



 */
