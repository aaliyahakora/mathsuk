package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EdexNov18Paper2 extends AppCompatActivity {

    private PDFView paper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edex_nov18_paper2);

        paper2 = (PDFView) findViewById(R.id.pdfEdex_Nov18_2);
        paper2.fromAsset("1MA1_2H_QPMS_nov18.pdf").load();
    }
}