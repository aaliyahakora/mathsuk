package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewQuestions extends AppCompatActivity {

    PDFView pdf_formulas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_questions);

        pdf_formulas = (PDFView)findViewById(R.id.pdfQuestions);
        pdf_formulas.fromAsset("mathsquestions.pdf").load();
    }
}
