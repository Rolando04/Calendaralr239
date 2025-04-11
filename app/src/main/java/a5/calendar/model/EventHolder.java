package a5.calendar.model;

import java.util.ArrayList;

public class EventHolder {
    private ArrayList<Event> eventHolder;
    private int numOfEvent;

    public EventHolder() {
        this.eventHolder = new ArrayList<>();
        this.numOfEvent = 0;
    }

    public void generate() { // Figure out

    }

    private void addEvent(Event e) {
        this.eventHolder.add(e);
        numOfEvent++;
    }

    public Event getEvent(int i) {
        return this.eventHolder.get(i);
    }

    public Event getEvent(String s) {
        Event found = new Event();
        Event cur;
        for (int i = 0; i < this.numOfEvent; i++) {
            cur = this.eventHolder.get(i);
            if (cur.getName().equals(s)) {
                found = cur;
                break;
            }
        }
        return found;
    }

    public void organizeByName() {
        Event cur;
        Event next;
        for (int i = 0; i < this.numOfEvent - 1; i++) {
            for (int j = 0; j < this.numOfEvent - i - 1; j++) {
                cur = this.eventHolder.get(j);
                next = this.eventHolder.get(j + 1);
                if (cur.getName().compareTo(next.getName()) > 0) {
                    Event temp = cur;
                    cur = next;
                    next = temp;
                } else if (cur.getName().compareTo(next.getName()) == 0) { //If tie
                    if (cur.getMonth() > next.getMonth()) {
                        Event temp = cur;
                        cur = next;
                        next = temp;
                    } else if (cur.getMonth() == next.getMonth()) { // If tie
                        if (cur.getDay() > next.getDay()) {
                            Event temp = cur;
                            cur = next;
                            next = temp;
                        } else if (cur.getDay() == next.getDay()) { // If tie
                            if (cur.getType().compareTo(next.getType()) > 0) {
                                Event temp = cur;
                                cur = next;
                                next = temp;
                            }
                        }
                    }

                }
            }
        }
    }


    public void organizeByDate(){

        Event cur;
        Event next;
        for(int i = 0; i < this.numOfEvent - 1; i++){
            for(int j = 0; j < this.numOfEvent - i -1; j++){
                cur = this.eventHolder.get(j);
                next = this.eventHolder.get(j+1);
                if(cur.getMonth() > next.getMonth()){
                    Event temp = cur;
                    cur = next;
                    next = temp;
                }else if(cur.getMonth() == next.getMonth()){ // If tie
                    if(cur.getDay() > next.getDay()){
                        Event temp = cur;
                        cur = next;
                        next = temp;
                    }else if(cur.getDay() == next.getDay()){ //If tie
                        if(cur.getType().compareTo(next.getType()) > 0){
                            Event temp = cur;
                            cur = next;
                            next = temp;
                        }else if(cur.getType().compareTo(next.getType()) == 0){ // If tie
                            if(cur.getName().compareTo(next.getName()) > 0){
                                Event temp = cur;
                                cur = next;
                                next = temp;
                            }
                        }
                    }

                }
            }
        }

    }
    public void organizeByType(){
        Event cur;
        Event next;
        for(int i = 0; i < this.numOfEvent - 1; i++){
            for(int j = 0; j < this.numOfEvent - i -1; j++){
                cur = this.eventHolder.get(j);
                next = this.eventHolder.get(j+1);
                if(cur.getType().compareTo(next.getType()) > 0){
                    Event temp = cur;
                    cur = next;
                    next = temp;
                }else if(cur.getType().compareTo(next.getType()) == 0){ // Tie
                    if(cur.getName().compareTo(next.getName()) > 0){
                        Event temp = cur;
                        cur = next;
                        next = temp;
                    }else if(cur.getName().compareTo(next.getName()) == 0){ //Tie
                        if(cur.getMonth() > next.getMonth()){
                            Event temp = cur;
                            cur = next;
                            next = temp;
                        }else if(cur.getMonth() == next.getMonth()){ // Tie
                            if(cur.getDay() > next.getDay()){
                                Event temp = cur;
                                cur = next;
                                next = temp;
                            }

                        }
                    }
                }

            }
        }

    }

}
