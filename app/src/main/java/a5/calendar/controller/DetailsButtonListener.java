package a5.calendar.controller;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButtonToggleGroup;

import a5.calendar.DetailsActivity;
import a5.calendar.MainActivity;
import a5.calendar.model.Event;
import a5.calendar.model.EventHolder;
import a5.calendar.view.RecyclerViewAdapter;

public class DetailsButtonListener implements View.OnClickListener {
    private static EventHolder events;
    private Context context;
    private String buttonName; //Is needed to use multiple buttons
    private int position;

    public static RecyclerViewAdapter adapt;



    public DetailsButtonListener(Context context, String buttonName, int position){
        this.buttonName = buttonName;
        this.position = position;
        this.context = context;
    }
    public DetailsButtonListener(String buttonName) {
        this.buttonName = buttonName;
    }
    public void setPosition(int i){
        this.position = i;
    }

    public static void setEvent(EventHolder event){
        events = event;
    }

    @Override
    public void onClick(View v) {
        if(buttonName.equals("NAME")){
            events.organizeByName();
            //Adjust Screen
            adapt.notifyDataSetChanged();
        }else if(buttonName.equals("DATE")){
            events.organizeByDate();
            //Adjust Screen
            adapt.notifyDataSetChanged();
        }else if(buttonName.equals("TYPE")){
            events.organizeByType();
            //Adjust Screen
            adapt.notifyDataSetChanged();
        }else if(buttonName.equals("DETAILS")){
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("event",events.getEvent(position));
            context.startActivity(intent);
        }
    }
}
