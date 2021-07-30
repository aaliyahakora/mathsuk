package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EdexNov18Paper3 extends AppCompatActivity {

    private PDFView paper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edex_nov18_paper3);

        paper3 = (PDFView) findViewById(R.id.pdfEdex_Nov18_3);
        paper3.fromAsset("1MA1_3H_QPMS_nov18.pdf").load();
    }
}