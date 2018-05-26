package com.example.myapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
import com.example.myapplication.FragmentOne;
import com.example.myapplication.FragmentTwo;*/


public class MainActivity extends AppCompatActivity
 {

    String FileName = "File12";

    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       spin = (Spinner)findViewById(R.id.ColorsSpinner);




       //////////////////////////////////

        getSupportFragmentManager().beginTransaction().replace(R.id.MainLayout, new Fragment1()).addToBackStack(null).commit();
    }

    public void ButtonClicked(View v) {
/*Лаба 1*/
        EditText min = findViewById(R.id.MinPriceText);
        EditText max = findViewById(R.id.MaxPriceText);
        EditText flower = findViewById(R.id.FlowerTextBox);

        String minText = min.getText().toString();
        String maxText = max.getText().toString();
        String colorText = spin.getSelectedItem().toString();
        String flowerText = flower.getText().toString();
        EditText rez = findViewById(R.id.UpText);

        String rezText = "Your choise is " + colorText + " " +flowerText+ " "+ " in price: " + minText + " - " + maxText;
        rez.setText(rezText, TextView.BufferType.EDITABLE);





        writeFile(rezText);


    }


     public void ReadFromFileButtonClicked(View v)
     {
         List<String> readList = readFile();

         String[] strArr = new String[readList.size()];

         for(int i = 0; i < readList.size(); i++)
         {
          strArr[i] = readList.get(i);
         }
         Intent intent = new Intent(this, ViewActivity.class);
                 intent.putExtra("StringArr",strArr);
         startActivity(intent);
     }




     public List<String> readFile() {
         List<String> strArr = new ArrayList();
         try {
             // открываем поток для чтения
             BufferedReader br = new BufferedReader(new InputStreamReader(
                     openFileInput(FileName)));
             String str = "";
             // читаем содержимое
             while ((str = br.readLine()) != null) {
                 strArr.add(str);
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return strArr;
     }

     public void writeFile(String str) {
         try {
             // отрываем поток для записи
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                     openFileOutput(FileName, MODE_APPEND)));
             // пишем данные
             bw.write(str + "\n");
             // закрываем поток
             bw.close();


             AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
             builder.setTitle("Важное сообщение!")
                     .setMessage("Строка: \n" + str + "\n успешно записана в файл " + FileName )
                     .setIcon(R.drawable.ic_launcher_background)
                     .setCancelable(false)
                     .setNegativeButton("ОК",
                             new DialogInterface.OnClickListener() {
                                 public void onClick(DialogInterface dialog, int id) {
                                     dialog.cancel();
                                 }
                             });
             AlertDialog alert = builder.create();
             alert.show();


         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
