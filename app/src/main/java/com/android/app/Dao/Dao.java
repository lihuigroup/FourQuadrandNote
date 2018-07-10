package com.android.app.Dao;

import android.content.Context;
import android.os.Environment;

import com.android.app.Entry.NoteEntry;

import java.io.File;
import java.util.List;

public class Dao {
    //两个dao
    public static File getDatabase(int userId,Context context){
        File file=new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),String.valueOf(userId)+".json");

        return file;
    }

    public static void initDatabaseByFile(File file) {

    }

    public static List<Note> NoteQueryAllNote(int userId){

    }

    public static void NoteInserOrReplaceNote(NoteEntry entry){

    }

    public static void NoteDeleteNote(NoteEntry entry){

    }

    public static List<User> UserQueryOnline(){
        //return dao.getUserDao().queryBuilder().where(UserDao.Properties.Is_online.eq(true)).list();
    }

    public static void UserInsertUser(User user){
        //dao.getUserDao().insertOrReplace(user);
    }
}