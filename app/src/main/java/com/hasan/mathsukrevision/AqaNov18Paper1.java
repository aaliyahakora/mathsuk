package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class AqaNov18Paper1 extends AppCompatActivity {

    private PDFView paper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqa_nov18_paper1);

        paper1 = (PDFView) findViewById(R.id.pdfAqa_Nov18_1);
        paper1.fromAsset("AQA-83001H-QPMS-nov18.pdf").load();
    }
}