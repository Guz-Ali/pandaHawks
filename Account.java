package com.example.ctaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Account extends AppCompatActivity {
    String name;
    TextView txtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Bundle extras= getIntent().getExtras();
        name = extras.getString("StringName");//tarnfers prctaice number
        txtname= (TextView) findViewById(R.id.txtuser);
        txtname.setText(name);
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
                View v = new View(Account.this);
                Intent intent = new Intent (v.getContext(), Account.class);
                Bundle extras = new Bundle();
                extras.putString("StringName", name + "");
                //extras.putString("coins", money + "");
                //extras.putString("picture",items+"" );
                intent.putExtras(extras);
                startActivityForResult(intent, 0);

                return true;
            case R.id.menu_history:
                View v2 = new View(Account.this);
                Intent intent2 = new Intent (v2.getContext(), History.class);
                Bundle extras2 = new Bundle();
                extras2.putString("StringName", name + "");
                intent2.putExtras(extras2);
                startActivityForResult(intent2, 0);
                return true;
            case R.id.menu_setting:
                //showHelp();
                return true;
            case R.id.menu_home:
                View v4 =  new View(Account.this);
                Intent intent4 = new Intent (v4.getContext(), LogIn.class);
                Bundle extras4 = new Bundle();
                extras4.putString("StringName", name + "");
                intent4.putExtras(extras4);
                startActivityForResult(intent4, 0);

                //showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
