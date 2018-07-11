package com.android.app.Dao;

import android.content.Context;
import android.os.Environment;

import com.android.app.Entry.NoteEntry;

import java.io.File;
import java.util.List;

public class Dao {
    private Dao(){}

    public static Dao getDao() {
        return dao;
    }

    public static void setDao(Dao dao) {
        Dao.dao = dao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public Dao(UserDao userDao, NoteDao noteDao) {
        this.userDao = userDao;
        this.noteDao = noteDao;
    }

    public static void initDao(DaoSession daoSession){
        dao=new Dao();
        getDao().setUserDao(daoSession.getUserDao());
        getDao().setNoteDao(daoSession.getNoteDao());
    }

    private static Dao dao;
    private UserDao userDao;
    private NoteDao noteDao;

    public static File getDatabase(int userId,Context context){
        File file=new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),String.valueOf(userId)+".json");

        return file;
    }

    public static void initDatabaseByFile(File file) {

    }

    public static List<Note> NoteQueryAllNote(){
        return dao.getNoteDao().queryBuilder().list();//??????
    }

    public static void NoteInserOrReplaceNote(NoteEntry entry){

    }

    public static void NoteInserOrReplaceNotes(List<Note> list){
        dao.getNoteDao().insertOrReplaceInTx(list);
    }

    public static void NoteDeleteNote(NoteEntry entry){

    }

    public static List<User> UserQueryOnline(){
        return dao.getUserDao().queryBuilder().where(UserDao.Properties.Is_online.eq(true)).list();
    }

    public static void UserInsertUser(User user){
        dao.getUserDao().insertOrReplace(user);
    }
}