package com.android.app.Dao;

import com.android.app.Entry.UserEntry;

public class User {
    private Long user_id;


    private boolean is_online;

    public User(Long user_id, boolean is_online) {
        this.user_id = user_id;
        this.is_online = is_online;
    }

    public UserEntry toEntry(){
        return new UserEntry(user_id.intValue(),is_online);
    }

}
