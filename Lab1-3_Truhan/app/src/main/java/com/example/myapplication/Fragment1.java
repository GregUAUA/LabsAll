package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

public class Fragment1 extends Fragment implements  View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view)
    {
        Button btnClick = (Button)view.findViewById(R.id.fr1_button);
        btnClick.setOnClickListener(this);
    }

    private void changeFragment()
    {

        getFragmentManager().beginTransaction().replace(R.id.MainLayout,  new Fragment2()).addToBackStack(null).commit();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.fr1_button:
                changeFragment();
                break;
        }
    }
}
