package com.example.ctaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button signin;
    EditText username;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =(EditText)findViewById(R.id.txtname);

        signin = (Button)findViewById(R.id.btnSignIn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), LogIn.class);
                name = username.getText().toString();
               // name="hey";
                Bundle extras = new Bundle();
                extras.putString("StringName", name + "");
                intent.putExtras(extras);
                startActivityForResult(intent, 0);
            }
        });

    }



}
