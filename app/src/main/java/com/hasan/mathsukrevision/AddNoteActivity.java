package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    EditText enter_title, enter_description;
    Button btn_save_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        enter_title = findViewById(R.id.enter_title);
        enter_description = findViewById(R.id.enter_description);
        btn_save_note = findViewById(R.id.btn_save_note);

        btn_save_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check if new Note's Title and Description are NOT empty
                if (TextUtils.isEmpty(enter_title.getText().toString()) == false && TextUtils.isEmpty(enter_description.getText().toString()) == false) {
                    DbClass db = new DbClass(AddNoteActivity.this);
                    db.saveNote(enter_title.getText().toString(), enter_description.getText().toString());

                    //Flags set for when data has been added to Db
                    Intent i = new Intent(AddNoteActivity.this, NotesActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(AddNoteActivity.this, "Please enter both, a Title and Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}