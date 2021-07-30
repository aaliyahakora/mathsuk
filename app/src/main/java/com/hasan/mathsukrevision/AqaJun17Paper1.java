package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class AqaJun17Paper1 extends AppCompatActivity {

    private PDFView paper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqa_jun17_paper1);

        paper1 = (PDFView) findViewById(R.id.pdfAqa_Jun17_1);
        paper1.fromAsset("AQA-83001H-QPMS-jun17.pdf").load();
    }
}