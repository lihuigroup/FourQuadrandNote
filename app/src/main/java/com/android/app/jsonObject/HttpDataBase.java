package com.android.app.jsonObject;

import com.android.app.Dao.Note;
import com.android.app.Dao.User;

import java.util.List;

public class HttpDataBase {
    private User user;
    private List<Note> list;


    public HttpDataBase(User user, List<Note> list) {
        this.user = user;
        this.list = list;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Note> getList() {
        return list;
    }

    public void setList(List<Note> list) {
        this.list = list;
    }


}
