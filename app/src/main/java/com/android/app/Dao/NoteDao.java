package com.android.app.Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NOTE".
*/
public class NoteDao extends AbstractDao<Note, Long> {

    public static final String TABLENAME = "NOTE";

    /**
     * Properties of entity Note.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Note_id = new Property(0, Long.class, "note_id", true, "_id");
        public final static Property Tittle = new Property(1, String.class, "tittle", false, "TITTLE");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public final static Property Date = new Property(3, java.util.Date.class, "date", false, "DATE");
        public final static Property Type = new Property(4, Long.class, "type", false, "TYPE");
        public final static Property Has_sound = new Property(5, boolean.class, "has_sound", false, "HAS_SOUND");
    }


    public NoteDao(DaoConfig config) {
        super(config);
    }
    
    public NoteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NOTE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: note_id
                "\"TITTLE\" TEXT," + // 1: tittle
                "\"CONTENT\" TEXT," + // 2: content
                "\"DATE\" INTEGER," + // 3: date
                "\"TYPE\" INTEGER," + // 4: type
                "\"HAS_SOUND\" INTEGER NOT NULL );"); // 5: has_sound
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NOTE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Note entity) {
        stmt.clearBindings();
 
        Long note_id = entity.getNote_id();
        if (note_id != null) {
            stmt.bindLong(1, note_id);
        }
 
        String tittle = entity.getTittle();
        if (tittle != null) {
            stmt.bindString(2, tittle);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(4, date.getTime());
        }
 
        Long type = entity.getType();
        if (type != null) {
            stmt.bindLong(5, type);
        }
        stmt.bindLong(6, entity.getHas_sound() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Note entity) {
        stmt.clearBindings();
 
        Long note_id = entity.getNote_id();
        if (note_id != null) {
            stmt.bindLong(1, note_id);
        }
 
        String tittle = entity.getTittle();
        if (tittle != null) {
            stmt.bindString(2, tittle);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(4, date.getTime());
        }
 
        Long type = entity.getType();
        if (type != null) {
            stmt.bindLong(5, type);
        }
        stmt.bindLong(6, entity.getHas_sound() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Note readEntity(Cursor cursor, int offset) {
        Note entity = new Note( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // note_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // tittle
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // content
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // date
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // type
            cursor.getShort(offset + 5) != 0 // has_sound
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Note entity, int offset) {
        entity.setNote_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTittle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDate(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setType(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setHas_sound(cursor.getShort(offset + 5) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Note entity, long rowId) {
        entity.setNote_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Note entity) {
        if(entity != null) {
            return entity.getNote_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Note entity) {
        return entity.getNote_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
