package a5.calendar;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import a5.calendar.controller.DetailsButtonListener;
import a5.calendar.model.Event;
import a5.calendar.model.EventHolder;
import a5.calendar.view.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button nameButton = findViewById(R.id.sort_by_name);
        Button dateButton = findViewById(R.id.sort_by_date);
        Button categoryButton = findViewById(R.id.sort_by_category);

        nameButton.setOnClickListener(new DetailsButtonListener("NAME"));
        dateButton.setOnClickListener(new DetailsButtonListener("DATE"));
        categoryButton.setOnClickListener(new DetailsButtonListener("TYPE"));

        EventHolder eventHolder = new EventHolder();
        eventHolder.generate(this);

        eventHolder.organizeByDate();
        RecyclerView recView = createRecyclerView(eventHolder.getArrayList());

        DetailsButtonListener.setEvent(eventHolder);
    }

    public RecyclerView createRecyclerView(ArrayList<Event> eventHolder){
        RecyclerView rV = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapt = new RecyclerViewAdapter(this, eventHolder);
        rV.setAdapter(adapt);
        rV.setLayoutManager(new LinearLayoutManager(this));
        DetailsButtonListener.adapt = adapt;
        return rV;
    }
}