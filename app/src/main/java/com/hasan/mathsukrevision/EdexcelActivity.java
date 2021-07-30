package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EdexcelActivity extends AppCompatActivity {

    Button btn_edex_jun17, btn_edex_jun18, btn_edex_nov17, btn_edex_nov18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edexcel);

        btn_edex_jun17 = findViewById(R.id.btn_edex_jun17);
        btn_edex_jun18 = findViewById(R.id.btn_edex_jun18);
        btn_edex_nov17 = findViewById(R.id.btn_edex_nov17);
        btn_edex_nov18 = findViewById(R.id.btn_edex_nov18);

        btn_edex_jun17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new EdexJun17Fragment());
            }
        });

        btn_edex_jun18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new EdexJun18Fragment());
            }
        });

        btn_edex_nov17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new EdexNov17Fragment());
            }
        });

        btn_edex_nov18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new EdexNov18Fragment());
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.edexFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}