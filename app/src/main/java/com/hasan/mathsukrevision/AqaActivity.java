package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AqaActivity extends AppCompatActivity {

    Button btn_aqa_jun15, btn_aqa_jun17, btn_aqa_jun18, btn_aqa_jun19, btn_aqa_nov17, btn_aqa_nov18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqa);
        btn_aqa_jun15 = findViewById(R.id.btn_aqa_jun15);
        btn_aqa_jun17 = findViewById(R.id.btn_aqa_jun17);
        btn_aqa_jun18 = findViewById(R.id.btn_aqa_jun18);
        btn_aqa_jun19 = findViewById(R.id.btn_aqa_jun19);
        btn_aqa_nov17 = findViewById(R.id.btn_aqa_nov17);
        btn_aqa_nov18 = findViewById(R.id.btn_aqa_nov18);

        btn_aqa_jun15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AqaJun15Fragment());
            }
        });

        btn_aqa_jun17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AqaJun17Fragment());
            }
        });

        btn_aqa_jun18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AqaJun18Fragment());
            }
        });

        btn_aqa_jun19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AqaJun19Fragment());
            }
        });

        btn_aqa_nov17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AqaNov17Fragment());
            }
        });

        btn_aqa_nov18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AqaNov18Fragment());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.aqaFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}