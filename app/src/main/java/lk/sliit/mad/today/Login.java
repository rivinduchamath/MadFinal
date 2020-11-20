package lk.sliit.mad.today;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lk.sliit.mad.today.database.DBHandler;
import lk.sliit.mad.today.database.FeedReaderContract;

public class Login extends AppCompatActivity {

    private Button btnRegisterLogin,btnLogin;
    private EditText etNameLogin, etPasswordLogin;
    private DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegisterLogin = findViewById(R.id.btnRegisterLogin);
        etNameLogin = findViewById(R.id.etNameLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);

        btnLogin = findViewById(R.id.btnLogin);
        db = new DBHandler(getApplicationContext());

        btnRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,Register.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name = etNameLogin.getText().toString().trim();
               String password = etPasswordLogin.getText().toString().trim();

               if(password.equals("") || name.equals("")){
                   Toast.makeText(Login.this, "Enter Data", Toast.LENGTH_SHORT).show();
               }else {

                   Cursor cursor = db.loadUser(name,password);
                   boolean bool = cursor.moveToFirst();
                   if(bool){
                       String type = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntryUser.COLUMN_TYPE));
                       if(type.equals("Teacher")){
                           Intent i = new Intent(Login.this,Teacher.class);
                           i.putExtra("Name",name);
                           startActivity(i);
                           Toast.makeText(Login.this, "Teacher Lo", Toast.LENGTH_SHORT).show();
                       }else {
                           Intent i = new Intent(Login.this,Student.class);
                           i.putExtra("Name",name);
                           startActivity(i);
                           Toast.makeText(Login.this, "Student Lo", Toast.LENGTH_SHORT).show();
                       }

                   }else {
                       Toast.makeText(Login.this, "ERRRRRRRRRRRRRRRRRRRRR", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
    }
}