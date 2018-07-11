package com.android.app.Dao;

import com.android.app.Entry.UserEntry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id
    private Long user_id;
    @Property
    private boolean is_online;


    @Generated(hash = 2058383500)
    public User(Long user_id, boolean is_online) {
        this.user_id = user_id;
        this.is_online = is_online;
    }


    @Generated(hash = 586692638)
    public User() {
    }


    public UserEntry toEntry(){
        return new UserEntry(user_id.intValue(),is_online);
    }


    public Long getUser_id() {
        return this.user_id;
    }


    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


    public boolean getIs_online() {
        return this.is_online;
    }


    public void setIs_online(boolean is_online) {
        this.is_online = is_online;
    }

}
