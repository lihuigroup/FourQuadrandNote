package com.android.app.Dao;

import com.android.app.Entry.NoteEntry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Note {
    @Id
    private Long note_id;
    @Property
    private String tittle;
    @Property
    private String content;
    @Property
    private Date date;
    @Property
    private Long type;
    @Property
    private boolean has_sound;




    @Generated(hash = 714366158)
    public Note(Long note_id, String tittle, String content, Date date, Long type,
            boolean has_sound) {
        this.note_id = note_id;
        this.tittle = tittle;
        this.content = content;
        this.date = date;
        this.type = type;
        this.has_sound = has_sound;
    }




    @Generated(hash = 1272611929)
    public Note() {
    }




    public NoteEntry toEntry(){
        return new NoteEntry(note_id.intValue(),
                tittle,
                content,
                date,
                type.intValue(),
                has_sound);
    }




    public Long getNote_id() {
        return this.note_id;
    }




    public void setNote_id(Long note_id) {
        this.note_id = note_id;
    }




    public String getTittle() {
        return this.tittle;
    }




    public void setTittle(String tittle) {
        this.tittle = tittle;
    }




    public String getContent() {
        return this.content;
    }




    public void setContent(String content) {
        this.content = content;
    }




    public Date getDate() {
        return this.date;
    }




    public void setDate(Date date) {
        this.date = date;
    }




    public Long getType() {
        return this.type;
    }




    public void setType(Long type) {
        this.type = type;
    }




    public boolean getHas_sound() {
        return this.has_sound;
    }




    public void setHas_sound(boolean has_sound) {
        this.has_sound = has_sound;
    }


}
