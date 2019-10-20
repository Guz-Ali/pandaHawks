package com.example.ctaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {
    String name;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Bundle extras = getIntent().getExtras();
        name = extras.getString("StringName");

        logout = (Button)findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                Bundle extras = new Bundle();
                extras.putString("StringName", name + "");
                intent.putExtras(extras);
                startActivityForResult(intent, 0);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_acc:
                View v = new View(Settings.this);
                Intent intent = new Intent (v.getContext(), Account.class);
                Bundle extras = new Bundle();
                extras.putString("StringName", name + "");
                intent.putExtras(extras);
                startActivityForResult(intent, 0);

                return true;
            case R.id.menu_history:
                View v2 = new View(Settings.this);
                Intent intent2 = new Intent (v2.getContext(), History.class);
                Bundle extras2 = new Bundle();
                extras2.putString("StringName", name + "");
                intent2.putExtras(extras2);
                startActivityForResult(intent2, 0);
                return true;
            case R.id.menu_setting:
                View v3 = new View(Settings.this);
                Intent intent3 = new Intent (v3.getContext(), Settings.class);
                Bundle extras3 = new Bundle();
                extras3.putString("StringName", name + "");
                intent3.putExtras(extras3);
                startActivityForResult(intent3, 0);

                return true;
            case R.id.menu_home:
                View v4 =  new View(Settings.this);
                Intent intent4 = new Intent (v4.getContext(), LogIn.class);
                Bundle extras4 = new Bundle();
                extras4.putString("StringName", name + "");
                intent4.putExtras(extras4);
                startActivityForResult(intent4, 0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
