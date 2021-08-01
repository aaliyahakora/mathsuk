package com.hasan.mathsukrevision;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbClass extends SQLiteOpenHelper {
    Context context;
    private static final String DbName = "Notes";
    private static final int DbVersion = 1;
    private static final String TableName = "notes";
    private static final String ColumnId = "id";
    private static final String ColumnTitle = "title";
    private static final String ColumnDescription = "description";

    public DbClass(@Nullable Context context) {
        super(context, DbName, null, DbVersion);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Db initialisation
        String query = "CREATE TABLE " + TableName + " (" + ColumnId + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ColumnTitle
                + " TEXT, " + ColumnDescription + " TEXT);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);

    }

    public void saveNote(String note_title, String note_description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ColumnTitle, note_title);
        cv.put(ColumnDescription, note_description);
        long rValue = db.insert(TableName, null, cv);

        //Data added from user input to Db - if successful or unsuccessful
        if (rValue == -1) {
            Toast.makeText(context, "Unsuccessful, Note not saved", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "Successful! Note has been saved", Toast.LENGTH_SHORT).show();
        }
    }

    //Create method in DbClass and retrieve notes from Db Class first to fetch from NotesActivity
    //Select * all notes from existing table
    public Cursor fetchAllData() {
        String query = "SELECT * FROM " + TableName;
        SQLiteDatabase dataBase = this.getReadableDatabase();
        //Pointer to the Db table
        Cursor cursor = null;
        if (dataBase != null) {
            cursor = dataBase.rawQuery(query, null);

        } return cursor;
    }

    public void deleteAllNotes() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TableName;
        db.execSQL(query);

    }
}
