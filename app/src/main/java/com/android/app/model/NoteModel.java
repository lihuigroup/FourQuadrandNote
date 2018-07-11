package com.android.app.model;

import com.android.app.Dao.Dao;
import com.android.app.Entry.NoteEntry;

import java.util.List;

public class NoteModel {
    public static void addNote(NoteEntry entry){
        NoteEntry.addNote(entry);
        NoteEntry.EntryToDao();
        NoteEntry.DaoToEntry(Dao.NoteQueryAllNote());
    }

    public static List<NoteEntry> getEntries(){
        NoteEntry.DaoToEntry(Dao.NoteQueryAllNote());
        return NoteEntry.getNoteEntries();
    }

    public static void deleteNote(NoteEntry entry){
        NoteEntry.deleteNote(entry);
        NoteEntry.EntryToDao();
        NoteEntry.DaoToEntry(Dao.NoteQueryAllNote());
    }
}
