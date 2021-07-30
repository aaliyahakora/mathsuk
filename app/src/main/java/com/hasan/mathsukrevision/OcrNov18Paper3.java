package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class OcrNov18Paper3 extends AppCompatActivity {

    private PDFView paper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_nov18_paper3);

        paper3 = (PDFView) findViewById(R.id.pdfOcr_Nov18_3);
        paper3.fromAsset("563122-3H-QPMS-nov18.pdf").load();
    }
}