package a5.calendar.model;

import java.io.Serializable;

public class Event implements Serializable {

    // eventType, eventName, eventMonth, eventDay, eventPrice, eventMemo
    private String eventType;
    private String eventName;
    private String eventPlace;
    private int eventMonth;
    private int eventDay;
    private String eventPrice;
    private String eventMemo;

    public Event(){
        this.eventType = "Invalid";
        this.eventName = "Invalid";
        this.eventPlace = "Invalid";
        this.eventMonth = -1;
        this.eventDay = -1;
        this.eventPrice = "Invalid";
        this.eventMemo = "Invalid";
    }

    public Event(String eventType, String eventName, String eventPlace, int eventMonth, int eventDay, String eventPrice, String eventMemo){
        this.eventType = eventType;
        this.eventName = eventName;
        this.eventPlace = eventPlace;
        this.eventMonth = eventMonth;
        this.eventDay = eventDay;
        this.eventPrice = eventPrice;
        this.eventMemo = eventMemo;
    }

    public String getType(){
        return this.eventType;
    }

    public String getName(){
        return this.eventName;
    }

    public String getPlace(){
        return this.eventPlace;
    }

    public int getMonth(){
        return this.eventMonth;
    }

    public int getDay(){
        return this.eventDay;
    }

    public String getPrice(){
        return this.eventPrice;
    }

    public String getMemo(){
        return this.eventMemo;
    }


    public void setEventMemo(String eventMemo) {
        this.eventMemo = eventMemo;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public void setEventMonth(int eventMonth) {
        this.eventMonth = eventMonth;
    }

    public void setEventDay(int eventDay) {
        this.eventDay = eventDay;
    }

    public void setEventPrice(String eventPrice) {
        this.eventPrice = eventPrice;
    }
}
