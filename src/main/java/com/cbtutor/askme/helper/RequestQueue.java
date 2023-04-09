package com.cbtutor.askme.helper;

import com.cbtutor.askme.modal.Request;
import com.cbtutor.askme.modal.TeachingAssistant;

import java.util.ArrayList;
import java.util.List;

public interface RequestQueue {

    public void publish(Request request);
    public void attach(TeachingAssistant teachingAssistant);
    public void detach(TeachingAssistant teachingAssistant);
    public void notifyUpdate(Request request);

    public List<Request> getRequestList();
}


