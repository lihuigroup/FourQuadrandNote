package com.android.app.model;

import com.android.app.Dao.Dao;
import com.android.app.Dao.User;
import com.android.app.Entry.UserEntry;

import java.util.List;

public class UserModel {
    public static int checkUserOnline(){
        List<User> list= Dao.UserQueryOnline();
        if (!list.isEmpty()){
            UserEntry.setUserEntry(list.get(0).toEntry());
        }

        return UserEntry.getUserEntry().getUser_id();
    }

    public static UserEntry getUserEntry(){
        return UserEntry.getUserEntry();
    }

    public static void LoginSuccess(int id){
        UserEntry.setUserEntry(new UserEntry(id,true));
        UserEntry.EntryToDao();
    }

    public static void Logout(){
        UserEntry.getUserEntry().setIs_online(false);
        UserEntry.EntryToDao();
        UserEntry.getUserEntry().setUser_id(-1);
    }
}
