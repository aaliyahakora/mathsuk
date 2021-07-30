package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class OcrJun18Paper2 extends AppCompatActivity {

    private PDFView paper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_jun18_paper2);

        paper2 = (PDFView) findViewById(R.id.pdfOcr_Jun18_2);
        paper2.fromAsset("528855-2H-QPMS-jun18.pdf").load();
    }
}