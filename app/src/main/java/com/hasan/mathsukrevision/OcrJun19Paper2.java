package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class OcrJun19Paper2 extends AppCompatActivity {

    private PDFView paper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_jun19_paper2);

        paper2 = (PDFView) findViewById(R.id.pdfOcr_Jun19_2);
        paper2.fromAsset("620508-2H-QPMS-jun19.pdf").load();
    }
}