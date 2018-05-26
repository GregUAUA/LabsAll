package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Fragment2 extends Fragment implements  View.OnClickListener{



    public View fr2_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fr2_view = inflater.inflate(R.layout.fragment2,container,false);






        Spinner spin = (Spinner)getActivity().findViewById(R.id.ColorsSpinner);
        EditText min = (EditText)getActivity().findViewById(R.id.MinPriceText);
        EditText max  = (EditText)getActivity().findViewById(R.id.MaxPriceText);
        EditText flower = (EditText)getActivity().findViewById(R.id.FlowerTextBox);

        String minText = min.getText().toString();
        String maxText = max.getText().toString();
        String colorText = spin.getSelectedItem().toString();
        String flowerText = flower.getText().toString();


        EditText rez = (EditText)getActivity().findViewById(R.id.UpText);

        String rezText = "Your choise is " + colorText + " " +flowerText+ " "+ " in price: " + minText + " - " + maxText;


        TextView tv = fr2_view.findViewById(R.id.fr2_text);
        tv.setText(rezText);






        return  fr2_view;


    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view)
    {
        Button btnClick = (Button)view.findViewById(R.id.fr2_button);
        btnClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.fr2_button:
                getFragmentManager().beginTransaction().replace(R.id.MainLayout,  new Fragment1()).addToBackStack(null).commit();
                break;
        }
    }







}
