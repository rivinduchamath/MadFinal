package lk.sliit.mad.today;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lk.sliit.mad.today.database.DBHandler;

public class Teacher extends AppCompatActivity {

    private EditText etSendMailTeacher, etSubjectTeacher;
    private DBHandler db;
    private Intent intent;
    private Button btnSendMsg;
    private TextView textViewTeacher;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        etSendMailTeacher = findViewById(R.id.etSendMailTeacher);
        etSubjectTeacher = findViewById(R.id.etSubjectTeacher);
        textViewTeacher = findViewById(R.id.textViewTeacher);

        btnSendMsg  = findViewById(R.id.btnSendMsg);

        db = new DBHandler(getApplicationContext());
        intent = getIntent();
        textViewTeacher.setText("Welcome "+ intent.getStringExtra("Name"));


        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long i = db.saveMessage( intent.getStringExtra("Name") , etSubjectTeacher.getText().toString() , etSendMailTeacher.getText().toString() );
                if(i > 0){
                    Toast.makeText(Teacher.this, "AAAAAAAAA", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Teacher.this,Login.class));
                }else {
                    Toast.makeText(Teacher.this, "BBBBBBBB", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}