package lk.sliit.mad.today;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import lk.sliit.mad.today.database.DBHandler;

public class Message extends AppCompatActivity {
    private TextView textView,textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        textView = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        Intent i  = getIntent();
        String pos = i.getStringExtra("Posi");
        DBHandler db = new DBHandler(getApplicationContext());
        String message = db.loadMessage(pos);

        textView3.setText(message);
        textView.setText(pos);


    }
}