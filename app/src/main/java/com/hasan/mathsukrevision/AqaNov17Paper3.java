package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class AqaNov17Paper3 extends AppCompatActivity {

    private PDFView paper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqa_nov17_paper3);

        paper3 = (PDFView) findViewById(R.id.pdfAqa_Nov17_3);
        paper3.fromAsset("AQA-83003H-QPMS-nov17.pdf").load();
    }
}