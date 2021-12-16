package com.example.covash_demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class infoFragment extends Fragment {
    LinearLayout linfo,lsetting,llogout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        linfo = view.findViewById(R.id.layoutpi);
        lsetting = view.findViewById(R.id.layoutsettings);
        llogout = view.findViewById(R.id.layoutLogout);

        linfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),PersonalInformation.class);
                startActivity(i);
            }
        });

        lsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Settings.class);
                startActivity(i);
            }
        });
        return view;
    }
}