package com.android.app.Dao;

import com.android.app.Entry.NoteEntry;

import java.util.Date;

public class Note {
    private Long note_id;

    private String tittle;

    private String content;

    private Date date;

    private Long type;

    private Long user_id;

    public Note(Long note_id, String tittle, String content, Date date, Long type, Long user_id) {
        this.note_id = note_id;
        this.tittle = tittle;
        this.content = content;
        this.date = date;
        this.type = type;
        this.user_id = user_id;
    }

    public NoteEntry toEntry(){
        return new NoteEntry(note_id.intValue(),
                tittle,
                content,
                date,
                type.intValue(),
                user_id.intValue());
    }

}
