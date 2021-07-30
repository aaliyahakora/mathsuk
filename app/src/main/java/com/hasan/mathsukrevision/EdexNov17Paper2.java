package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EdexNov17Paper2 extends AppCompatActivity {

    private PDFView paper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edex_nov17_paper2);

        paper2 = (PDFView) findViewById(R.id.pdfEdex_Nov17_2);
        paper2.fromAsset("1MA1_2H_QPMS_nov17.pdf").load();
    }
}