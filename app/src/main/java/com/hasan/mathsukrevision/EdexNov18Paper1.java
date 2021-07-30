package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EdexNov18Paper1 extends AppCompatActivity {

    private PDFView paper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edex_nov18_paper1);

        paper1 = (PDFView) findViewById(R.id.pdfEdex_Nov18_1);
        paper1.fromAsset("1MA1_1H_QPMS_nov18.pdf").load();
    }
}