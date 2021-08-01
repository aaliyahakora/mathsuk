package com.hasan.mathsukrevision;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floating_add;
    Adapter adapter;
    List<NotesModel> notesList;
    DbClass dbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        recyclerView = findViewById(R.id.recycler_view);
        floating_add = findViewById(R.id.floating_add);

        notesList = new ArrayList<>();
        dbClass = new DbClass(this);
        fetchAllNotes();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //New adapter instance
        adapter = new Adapter(this, NotesActivity.this, notesList);
        recyclerView.setAdapter(adapter);

        floating_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NotesActivity.this, AddNoteActivity.class);
                startActivity(i);

            }
        });
    }

    private void fetchAllNotes() {
        Cursor cursor = dbClass.fetchAllData();
        //Check if adapter is empty - No data in table
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();

        } else {
            //Whilst there are items in the table:
            while (cursor.moveToNext()) {
                notesList.add(new NotesModel(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);


        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Find notes");

        SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return true;
            }
        };
        searchView.setOnQueryTextListener(listener);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            deleteAllNotes();
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteAllNotes() {
        DbClass db = new DbClass(NotesActivity.this);
        db.deleteAllNotes();
        recreate();
    }
}