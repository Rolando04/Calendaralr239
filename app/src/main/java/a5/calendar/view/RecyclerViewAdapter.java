package a5.calendar.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

import java.util.ArrayList;

import a5.calendar.R;
import a5.calendar.controller.DetailsButtonListener;
import a5.calendar.model.Event;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Event> eventHolder;

    public RecyclerViewAdapter (Context context, ArrayList<Event> eventHolder){
        this.context = context;
        this.eventHolder = eventHolder;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflates the layout and look to the rows

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.eventitemlayout, parent, false);

        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        //assigns values to the views created in the layout based on the position of the recycler view (19:20)

        holder.text.setText(String.format(eventHolder.get(position).getMonth() + "/" + eventHolder.get(position).getDay() + " " + eventHolder.get(position).getType() + ": " + eventHolder.get(position).getName()));
        holder.button.setOnClickListener(new DetailsButtonListener(context,"DETAILS", position));
    }

    @Override
    public int getItemCount() {
        //total number of items in the recycler
        return eventHolder.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //grab the views from the layout file (basically an onCreate method (Long has this as a seperate file so might have to move later))
        Button button;
        TextView text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.details_button);
            text = itemView.findViewById(R.id.event_blurb);
        }
    }
}
