package com.example.ctaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {
    String name;
    TextView points,speak;
    ImageView pandaPic;
    ProgressBar progressBar;
    int pts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        pandaPic = (ImageView)findViewById(R.id.imgPanda);
        points = (TextView) findViewById(R.id.lblpts);
        speak = (TextView)findViewById(R.id.txtspeech);
        progressBar =(ProgressBar)findViewById(R.id.pb);
        points.setText("300");
        pts = Integer.parseInt(points.getText().toString());
        //progressBar.setProgress((pts/500)*100);
        Bundle extras = getIntent().getExtras();
        name = extras.getString("StringName");//tarnfers prctaice number
        if(pts<250){
            String uri = "@drawable/sad_panda_clear1";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable pic = getResources().getDrawable(imageResource);
            pandaPic.setImageDrawable(pic);
        }
        else{
            String uri = "@drawable/happy_panda_clear";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable pic = getResources().getDrawable(imageResource);
            pandaPic.setImageDrawable(pic);
        }

        speach();
    }

    public void speach(){
        pandaPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak.setText("hi "+ name+"! only 200 more points for a free ride");

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
                View v = new View(LogIn.this);
                Intent intent = new Intent (v.getContext(), Account.class);
                Bundle extras = new Bundle();
                extras.putString("StringName", name + "");
                intent.putExtras(extras);
                startActivityForResult(intent, 0);
                return true;
            case R.id.menu_history:
                //showHelp();
                View v2 = new View(LogIn.this);
                Intent intent2 = new Intent (v2.getContext(), History.class);
                Bundle extras2 = new Bundle();
                extras2.putString("StringName", name + "");
                intent2.putExtras(extras2);
                startActivityForResult(intent2, 0);
                return true;
            case R.id.menu_setting:
                View v3 = new View(LogIn.this);
                Intent intent3 = new Intent (v3.getContext(), Settings.class);
                Bundle extras3 = new Bundle();
                extras3.putString("StringName", name + "");
                intent3.putExtras(extras3);
                startActivityForResult(intent3, 0);
                return true;
            case R.id.menu_home:
                View v4 =  new View(LogIn.this);
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
