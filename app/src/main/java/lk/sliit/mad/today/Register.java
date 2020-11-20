package lk.sliit.mad.today;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import lk.sliit.mad.today.database.DBHandler;

public class Register extends AppCompatActivity {

    private EditText etNameRegister, etPasswordRegister;
    private RadioButton radioButtonTeacher, radioButtonStudent;
    private Button btnRegister;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNameRegister = findViewById(R.id.etNameRegister);
        etPasswordRegister = findViewById(R.id.etPasswordRegister);
        radioButtonTeacher = findViewById(R.id.radioButtonTeacher);
        radioButtonStudent = findViewById(R.id.radioButtonStudent);
        btnRegister = findViewById(R.id.btnRegister);
        radioButtonStudent.setChecked(true);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etNameRegister.getText().toString().trim();
                String password = etPasswordRegister.getText().toString().trim();
                if(name.equals("") || password.equals("")){
                    Toast.makeText(Register.this, "Enter Data", Toast.LENGTH_SHORT).show();
                }else{
                    if(radioButtonTeacher.isChecked()){
                        type = "Teacher";
                    }else {
                        type = "Student";
                    }
                    DBHandler db = new DBHandler(getApplicationContext());
                    long i = db.saveUser(name,password,type);
                    if(i > 0) {
                        Toast.makeText(Register.this, "Su", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Register.this, "ERRRR", Toast.LENGTH_SHORT).show();
                    }
                    Intent ii  = new Intent(Register.this,Login.class);
                    startActivity(ii);

                }

            }
        });


    }
}