package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EdexJun17Paper2 extends AppCompatActivity {

    private PDFView paper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edex_jun17_paper2);

        paper2 = (PDFView) findViewById(R.id.pdfEdex_Jun17_2);
        paper2.fromAsset("1MA1_2H_QPMS_jun17.pdf").load();
    }
}