package a5.calendar.model;

public class Event {

    // eventType, eventName, eventMonth, eventDay, eventPrice, eventMemo
    private String eventType;
    private String eventName;
    private int eventMonth;
    private int eventDay;
    private String eventPrice;
    private String eventMemo;

    public Event(){
        this.eventType = "Invalid";
        this.eventName = "Invalid";
        this.eventMonth = -1;
        this.eventDay = -1;
        this.eventPrice = "Invalid";
        this.eventMemo = "Invalid";
    }

    public Event(String eventType, String eventName, int eventMonth, int eventDay, String eventPrice, String eventMemo){
        this.eventType = eventType;
        this.eventName = eventName;
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


}
