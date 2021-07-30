package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class AqaNov17Paper2 extends AppCompatActivity {

    private PDFView paper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqa_nov17_paper2);

        paper2 = (PDFView) findViewById(R.id.pdfAqa_Nov17_2);
        paper2.fromAsset("AQA-83002H-QPMS-nov17.pdf").load();
    }
}