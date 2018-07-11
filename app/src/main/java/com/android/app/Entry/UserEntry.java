package com.android.app.Entry;

import com.android.app.Dao.Dao;
import com.android.app.Dao.User;

public class UserEntry {
    private static UserEntry userEntry;
    public static int id;
    private int user_id;
    private boolean is_online;

    public static void DaoToEntry(User _user){
        userEntry =_user.toEntry();
    }

    public static void EntryToDao(){
        Dao.UserInsertUser(userEntry.toUser());
    }

    public static UserEntry getUserEntry() {
        if (userEntry ==null)
            userEntry =new UserEntry();
        return userEntry;
    }

    public static void setUserEntry(UserEntry user_) {
        userEntry = user_;
    }
    public User toUser(){
        return new User(new Long(user_id),is_online);
    }

    private UserEntry() {
        user_id=-1;
    }

    public UserEntry(int user_id, boolean is_online) {
        this.user_id = user_id;
        this.is_online = is_online;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isIs_online() {
        return is_online;
    }

    public void setIs_online(boolean is_online) {
        this.is_online = is_online;
    }


}
