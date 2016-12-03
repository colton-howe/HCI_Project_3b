package com.firstdemo.a100520095.lab8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TitleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
    }

    protected void loginButton(View view) {
        EditText username = (EditText)findViewById(R.id.txtUsername);
        EditText password = (EditText)findViewById(R.id.txtPassword);
        if (username.getText().toString().equals("Admin") && password.getText().toString().equals("password")){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ShowLocation.class);
            startActivity(intent);
        } else {
            TextView error = (TextView)findViewById(R.id.lblError);
            error.setText("Incorrect username/password combination");
            username.setText("Admin");
            password.setText("password");
        }
    }
}
