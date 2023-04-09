package com.cbtutor.askme.modal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Slot {
    private int id;
    private String date;
    private String time;
    private boolean isActive;
    private boolean isBooked;

    public Slot(String time, boolean isActive, boolean isBooked) {
        this.date="";
       this.time = time;
        this.isActive = isActive;
        this.isBooked = isBooked;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "date='" + date + '\'' +
                "time='" + time + '\'' +
                ", isActive=" + isActive +
                ", isBooked=" + isBooked +
                '}';
    }
}
