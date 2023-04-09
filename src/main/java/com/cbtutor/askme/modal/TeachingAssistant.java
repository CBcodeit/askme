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
        boolean isTaCompatibleForRequest = checkTaCompatibleForRequest(request);
        if(!isTaCompatibleForRequest){
            System.out.println("Request can not be Accepted as this TA's expertise is not matching with request");
            return;
        }

        Slot taSlot = getCompatibleSlotOfTA(request);
        if(taSlot==null){
            System.out.println("Request can not be Accepted as this TA's slot not available for requested slot");
            return;
        }

        acceptRequest(request,taSlot);
        System.out.println("Request Accepted");

    }

    private boolean checkTaCompatibleForRequest(Request request){
        return this.getTopicSet().contains(request.getTopic());
    }

    private void acceptRequest(Request request,Slot taSlot){
        //additional logic to decide/intervene TA manually if proceed to book slot
        taSlot.setBooked(true);
        request.getCurrentRequestStatus().updateRequestStatus(request,AcceptedRequestStatus.getAcceptedRequestStatusInstance());
    }

    private Slot getCompatibleSlotOfTA(Request request){
        for (Slot slot : this.getSlotSet()) {
                if(slot.getTime().equals(request.getSlot().getTime()) && slot.isActive() && !slot.isBooked()){
                       return slot;
                }
        }
        return null;
    }


    @Override
    public String toString() {
        return "TeachingAssistant{" +
                "salary=" + salary +
                ", topicSet=" + topicSet +
                '}';
    }
}
