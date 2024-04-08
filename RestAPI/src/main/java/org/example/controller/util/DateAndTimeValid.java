package org.example.controller.util;
import java.util.regex.*;
import java.util.concurrent.ScheduledExecutorService;

public class DateAndTimeValid {

    private static DateAndTimeValid instance;
    private DateAndTimeValid(){

    }
    public static DateAndTimeValid getInstance(){
        if(instance==null)
            instance = new DateAndTimeValid();
        return instance;
    }
    public boolean checkValidDate(String date){
         Pattern DATE_PATTERN = Pattern.compile(
                "^\\d{4}-\\d{2}-\\d{2}$");
            return DATE_PATTERN.matcher(date).matches();
    }

    public boolean checkValidTime(String time){
        Pattern TIME_PATTERN = Pattern.compile(
                "^\\d{2}:\\d{2}:\\d{2}$");
        return TIME_PATTERN.matcher(time).matches();
    }

}
