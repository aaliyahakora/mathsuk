package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OcrActivity extends AppCompatActivity {

    Button btn_ocr_jun17, btn_ocr_jun18, btn_ocr_jun19, btn_ocr_nov18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr);

        btn_ocr_jun17 = findViewById(R.id.btn_ocr_jun17);
        btn_ocr_jun18 = findViewById(R.id.btn_ocr_jun18);
        btn_ocr_jun19 = findViewById(R.id.btn_ocr_jun19);
        btn_ocr_nov18 = findViewById(R.id.btn_ocr_nov18);

        btn_ocr_jun17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new OcrJun17Fragment());
            }
        });

        btn_ocr_jun18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new OcrJun18Fragment());
            }
        });

        btn_ocr_jun19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new OcrJun19Fragment());
            }
        });

        btn_ocr_nov18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new OcrNov18Fragment());
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ocrFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}