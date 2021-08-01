package com.hasan.mathsukrevision;

public class NotesModel {

    String text_title, note_description, id;

    public NotesModel(String id, String text_title, String note_description) {
        this.text_title = text_title;
        this.note_description = note_description;
        this.id = id;
    }

    public String getText_title() {
        return text_title;
    }

    public void setText_title(String text_title) {
        this.text_title = text_title;
    }

    public String getNote_description() {
        return note_description;
    }

    public void setNote_description(String note_description) {
        this.note_description = note_description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
