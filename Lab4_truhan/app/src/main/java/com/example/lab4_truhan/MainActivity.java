package com.example.lab4_truhan;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {


    int constPos = -1;

    boolean MusicPause;
    MediaPlayer mp;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Field[] field = R.raw.class.getFields();

        String[] fieldsNames = new String[field.length];

       for(int i = 0; i < field.length; i++)
       {
           fieldsNames[i] = field[i].getName();
       }

         spin = findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,fieldsNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(adapter);
        mp = MediaPlayer.create(this,R.raw.adelle_hello);
    }


    public void Start(View v)
    {

        if(MusicPause==true)
        {
            mp.start();
        }
else
       if(!mp.isPlaying() || spin.getSelectedItemPosition() != constPos) {


           if(mp.isPlaying()){
               mp.stop(); MusicPause = false;}


                constPos = spin.getSelectedItemPosition();


            Field[] field = R.raw.class.getFields();


               int id = getResources().getIdentifier(field[constPos].getName(), "raw", getPackageName());

                mp = MediaPlayer.create(this,id);

                mp.start();


        }



    }

    public void Pause(View v)
    {
        if(mp.isPlaying()) {
            mp.pause();
            MusicPause = true;
        }

    }

    public void Continue(View v)
    {
        if(MusicPause == true)
        {
            mp.start();
        }
    }

    public void Stop(View v)
    {
        MusicPause = false;
        mp.stop();
    }
}
