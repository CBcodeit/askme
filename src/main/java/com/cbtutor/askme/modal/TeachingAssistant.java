package com.cbtutor.askme.modal;

import com.cbtutor.askme.enums.Topic;
import com.cbtutor.askme.helper.AcceptedRequestStatus;
import com.cbtutor.askme.helper.Resolver;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TeachingAssistant extends User implements Resolver {

    private double salary;
    private Set<Topic> topicSet;

    public TeachingAssistant(int id,String name,double salary){
        super(id,name);
        this.salary = salary;
        topicSet = new HashSet<>();
        this.getSlotSet().add(new Slot("10.00AM",true,false));
        this.getSlotSet().add(new Slot("11.00AM",true,false));
        this.getSlotSet().add(new Slot("12.00AM",true,false));
        this.getSlotSet().add(new Slot("1.00PM",true,false));
        this.getSlotSet().add(new Slot("2.00PM",true,false));
        this.getSlotSet().add(new Slot("3.00PM",true,false));
        this.getSlotSet().add(new Slot("4.00PM",true,false));
    }


    @Override
    public void update(Request request) {
        //conditionally accept request with synchronization
        if(this.getTopicSet().contains(request.getTopic())){
            Slot slot = getCompatibleSlot(request);
            if(slot==null){
                //this TA's slot not available for requested slot and hence keep request in queue
                System.out.println("Request can not be Accepted");
                return;
            }
            //process request
            //....
            //....
            //....
            request.getCurrentRequestStatus().updateRequestStatus(request,AcceptedRequestStatus.getAcceptedRequestStatusInstance());
            System.out.println("Request Accepted");
            return;
        }
        System.out.println("Request can not be Accepted");
    }

    private void bookSlot(Request request){
        //additional logic to decide/intervene TA manually if proceed to book slot
        slot.setBooked(true);
        request.getCurrentRequestStatus().updateRequestStatus(request);

    }

    public Slot getCompatibleSlot(Request request){
        for (Slot slot : this.getSlotSet()) {
                if(slot.getTime().equals(request.getSlot().getTime()) && slot.isActive() && !slot.isBooked()){
                       return slot;
                }
        }
        return null;
    }
}
