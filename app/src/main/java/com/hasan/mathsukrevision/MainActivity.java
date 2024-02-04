package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_open_formulas, btn_open_revision, btn_timer, btn_notes, btn_open_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_open_formulas = (Button) findViewById(R.id.btn_open_formulas);
        btn_open_formulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewFormulas.class);
                startActivity(i);
            }
        });

        btn_open_questions = (Button) findViewById(R.id.btn_open_questions);
        btn_open_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewQuestions.class);
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

        btn_timer = (Button) findViewById(R.id.btn_timer);
        btn_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimerActivity();
            }
        });

        btn_notes = (Button) findViewById(R.id.btn_notes);
        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotesActivity();
            }
        });


    }

    public void openRevisionActivity() {
            Intent i = new Intent(this, RevisionActivity.class);
            startActivity(i);
        }
        

    public void openTimerActivity() {
        Intent i = new Intent(this, TimerActivity.class);
        startActivity(i);
    }

    public void openNotesActivity() {
        Intent i = new Intent(this, NotesActivity.class);
        startActivity(i);
    }

}