package lk.sliit.mad.today;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import lk.sliit.mad.today.database.DBHandler;

public class Student extends AppCompatActivity {
   private ListView listViewMessage;
   private TextView textView;
   private Intent intent;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        listViewMessage = findViewById(R.id.listViewMessage);
        DBHandler db = new DBHandler(getApplicationContext());
        textView = findViewById(R.id.textViewStudent);

        intent = getIntent();
        textView.setText("Welcome "+intent.getStringExtra("Name"));

        ArrayAdapter<List> arrayAdapter = new ArrayAdapter<List>(this, android.R.layout.simple_list_item_1,db.loadAllMessage());
        listViewMessage.setAdapter(arrayAdapter);

        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String posii = listViewMessage.getItemAtPosition(position).toString();
                Intent intent = new Intent(Student.this,Message.class);
                intent.putExtra("Posi",posii);
                startActivity(intent);
            }
        });

    }
}