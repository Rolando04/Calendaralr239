package a5.calendar.model;

import android.content.res.AssetManager;
import android.content.Context;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class EventHolder {
    private ArrayList<Event> eventHolder;
    private int numOfEvent;

    public EventHolder() {
        this.eventHolder = new ArrayList<Event>();
        this.numOfEvent = 0;
    }

    public ArrayList<Event> getArrayList(){
        return this.eventHolder;
    }

    public void generate(Context context) {
        AssetManager am = context.getAssets();

        try {
            InputStream inStream = am.open("events.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split(",");

                if (parts.length <= 7) {
                    Event e = new Event();
                    e.setEventType(parts[0].trim());
                    e.setEventName(parts[1].trim());
                    e.setEventPlace(parts[2].trim());
                    e.setEventMonth(Integer.parseInt(parts[3]));
                    e.setEventDay(Integer.parseInt(parts[4]));
                    e.setEventPrice(parts[5].trim());
                    e.setEventMemo(parts[6].trim());
                    this.addEvent(e);
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                this.eventHolder.set(j,cur);
                this.eventHolder.set(j+1,next);
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
                this.eventHolder.set(j,cur);
                this.eventHolder.set(j+1,next);
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
                this.eventHolder.set(j,cur);
                this.eventHolder.set(j+1,next);

            }
        }

    }

}
