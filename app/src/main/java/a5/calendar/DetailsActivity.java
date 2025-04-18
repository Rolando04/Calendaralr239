package a5.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import a5.calendar.model.Event;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textView = findViewById(R.id.details_text_view);

        Intent intent = getIntent();
        Event event = (Event) getIntent().getSerializableExtra("event");
        if(event != null) {
            textView.setText(String.format("Date: %d/%d\nEvent: %s\nCategory: %s\nLocation: %s\nAdmission: %s\n\n%s",
                    event.getMonth(), event.getDay(), event.getName(), event.getType(), event.getPlace(), event.getPrice(), event.getMemo()));
        }
    }
}