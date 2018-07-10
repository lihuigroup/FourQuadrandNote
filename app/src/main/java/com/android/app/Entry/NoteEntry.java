package com.android.app.Entry;

import com.android.app.Dao.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteEntry {
    private static List<NoteEntry> notes;
    private int note_id;
    private String tittle;
    private String content;
    private Date date;
    private int type;
    private int user_id;

    public Note toNote(){
        Long id=null;
        if(note_id!=-1)
            id=new Long(note_id);
        return new Note(id,
                    tittle,
                    content,
                    date,
                    new Long(type),
                    new Long(user_id));
    }

    public static void DaoToEntry(List<Note> list){
        if(notes!=null&&!notes.isEmpty())
            notes.clear();
        else {
            getNotes();
        }
        for (int i=0;i<list.size();i++){
            notes.add(list.get(i).toEntry());
        }
    }

    public static void EntryToDao(){
        //todo
    }

    public static List<NoteEntry> getNotes() {
        if(notes==null)
            notes=new ArrayList<>();
        return notes;
    }

    public static void setNotes(List<NoteEntry> notes_) {
        notes = notes_;
    }

    public NoteEntry(int note_id, String tittle, String content, Date date, int type, int user_id) {
        this.note_id = note_id;
        this.tittle = tittle;
        this.content = content;
        this.date = date;
        this.type = type;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


}
