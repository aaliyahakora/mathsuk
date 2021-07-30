package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class AqaJun15Paper3 extends AppCompatActivity {

    private PDFView paper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqa_jun15_paper3);

        paper3 = (PDFView) findViewById(R.id.pdfAqa_Jun15_3);
        paper3.fromAsset("AQA-83003H-QPMS-jun15.pdf").load();
    }
}