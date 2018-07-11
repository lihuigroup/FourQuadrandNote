package com.android.app.Entry;

import com.android.app.Dao.Dao;
import com.android.app.Dao.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteEntry {
    private static List<NoteEntry> noteEntries;
    private int note_id;
    private String tittle;
    private String content;
    private Date date;
    private int type;//0重要紧急  1重要不紧急 2不重要紧急 3不重要不紧急
    private boolean has_sound;



    public Note toNote(){
        Long id=null;
        if(note_id!=-1)
            id=new Long(note_id);
        return new Note(id,
                    tittle,
                    content,
                    date,
                    new Long(type),
                    has_sound);
    }

    public static void DaoToEntry(List<Note> list){
        if(noteEntries !=null&&!noteEntries.isEmpty())
            noteEntries.clear();
        else {
            getNoteEntries();
        }
        for (int i=0;i<list.size();i++){
            noteEntries.add(list.get(i).toEntry());
        }
    }

    public static void EntryToDao(){
        List<Note> list=new ArrayList<>();
        for (int i=0;i<noteEntries.size();i++){
            list.add(noteEntries.get(i).toNote());
        }
        Dao.NoteInserOrReplaceNotes(list);
    }

    public static void addNote(NoteEntry entry){
        getNoteEntries().add(entry);
    }

    public static void deleteNote(NoteEntry entry){
        for (int i=0;i<getNoteEntries().size();i++){
            if (noteEntries.get(i).getNote_id()==entry.getNote_id())
                noteEntries.remove(i);
        }
    }

    public static List<NoteEntry> getNoteEntries() {
        if(noteEntries ==null)
            noteEntries =new ArrayList<>();
        return noteEntries;
    }

    public static void setNoteEntries(List<NoteEntry> notes_) {
        noteEntries = notes_;
    }

    public NoteEntry(int note_id, String tittle, String content, Date date, int type,boolean has_sound) {
        this.note_id = note_id;
        this.tittle = tittle;
        this.content = content;
        this.date = date;
        this.type = type;
        this.has_sound=has_sound;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isHas_sound() {
        return has_sound;
    }

    public void setHas_sound(boolean has_sound) {
        this.has_sound = has_sound;
    }



}
