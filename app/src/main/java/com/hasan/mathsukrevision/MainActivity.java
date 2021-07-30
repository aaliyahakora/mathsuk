package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_open_formulas, btn_open_revision, btn_aqa, btn_edexcel, btn_ocr;
    ImageView insta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insta = findViewById(R.id.insta);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/mathsuk/");
            }
        });

        btn_open_formulas = (Button) findViewById(R.id.btn_open_formulas);
        btn_open_formulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewFormulas.class);
                startActivity(i);
            }
        });

        btn_open_revision = (Button) findViewById(R.id.btn_open_revision);
        btn_open_revision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRevisionActivity();
            }
        });

        btn_aqa = (Button) findViewById(R.id.btn_aqa);
        btn_aqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAqaActivity();
            }
        });

        btn_edexcel = (Button) findViewById(R.id.btn_edexcel);
        btn_edexcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdexcelActivity();
            }
        });

        btn_ocr = (Button) findViewById(R.id.btn_ocr);
        btn_ocr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOcrActivity();
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));

    }

    public void openRevisionActivity() {
            Intent i = new Intent(this, RevisionActivity.class);
            startActivity(i);
        }

        public void openAqaActivity() {
            Intent i = new Intent(this, AqaActivity.class);
            startActivity(i);
        }

        public void openEdexcelActivity() {
            Intent i = new Intent(this, EdexcelActivity.class);
            startActivity(i);
        }

        public void openOcrActivity() {
            Intent i = new Intent(this, OcrActivity.class);
            startActivity(i);
        }

}