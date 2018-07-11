package com.android.app.model;

import com.android.app.Dao.Dao;
import com.android.app.Entry.NoteEntry;

public class NoteModel {
    public static void addNote(NoteEntry entry){
        NoteEntry.addNote(entry);
        NoteEntry.EntryToDao();
        NoteEntry.DaoToEntry(Dao.NoteQueryAllNote());
    }
}
