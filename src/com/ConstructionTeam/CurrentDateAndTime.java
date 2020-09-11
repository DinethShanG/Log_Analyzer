package com.ConstructionTeam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateAndTime {

    public String getCurrentDateAndTime(){
        DateTimeFormatter datf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();

        return datf.format(now);
    }
}
