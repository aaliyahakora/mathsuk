package com.hasan.mathsukrevision;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class EdexNov17Fragment extends Fragment {

    private Button btn_paper1, btn_paper2, btn_paper3;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_edex_nov17, container, false);

        btn_paper1 = (Button) view.findViewById(R.id.btn_e_nov17_1);
        btn_paper2 = (Button) view.findViewById(R.id.btn_e_nov17_2);
        btn_paper3 = (Button) view.findViewById(R.id.btn_e_nov17_3);

        btn_paper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EdexNov17Paper1.class);
                startActivity(i);
            }
        });

        btn_paper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EdexNov17Paper2.class);
                startActivity(i);
            }
        });

        btn_paper3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EdexNov17Paper3.class);
                startActivity(i);
            }
        });

        return view;
    }
}