package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EdexJun18Paper1 extends AppCompatActivity {

    private PDFView paper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edex_jun18_paper1);

        paper1 = (PDFView) findViewById(R.id.pdfEdex_Jun18_1);
        paper1.fromAsset("1MA1_1H_QPMS_jun18.pdf").load();
    }
}