package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class OcrNov18Paper2 extends AppCompatActivity {

    private PDFView paper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_nov18_paper2);

        paper2 = (PDFView) findViewById(R.id.pdfOcr_Nov18_2);
        paper2.fromAsset("563121-2H-QPMS-nov18.pdf").load();
    }
}