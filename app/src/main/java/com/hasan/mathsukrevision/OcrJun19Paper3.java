package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class OcrJun19Paper3 extends AppCompatActivity {

    private PDFView paper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_jun19_paper3);

        paper3 = (PDFView) findViewById(R.id.pdfOcr_Jun19_3);
        paper3.fromAsset("620509-3H-QPMS-jun19.pdf").load();
    }
}