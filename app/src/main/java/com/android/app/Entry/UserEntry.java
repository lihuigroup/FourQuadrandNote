package com.android.app.Entry;

import com.android.app.Dao.User;

public class UserEntry {
    private static UserEntry user;
    private int user_id;
    private boolean is_online;

    public static void DaoToEntry(User _user){
        user=_user.toEntry();
    }

    public static void EntryToDao(){
        //todo
    }

    public static UserEntry getUser() {
        if (user==null)
            user=new UserEntry();
        return user;
    }

    public static void setUser(UserEntry user_) {
        user = user_;
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
