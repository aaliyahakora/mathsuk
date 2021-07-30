package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class OcrJun19Paper1 extends AppCompatActivity {

    private PDFView paper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_jun19_paper1);

        paper1 = (PDFView) findViewById(R.id.pdfOcr_Jun19_1);
        paper1.fromAsset("620507-1H-QPMS-jun19.pdf").load();
    }
}