package com.quizzapp.quizzapp;

import android.database.Cursor;

/**
 * Created by Asus on 2016-04-25.
 */
public class Perdorues {

    public Perdorues(Cursor cursor){
        emri = cursor.getString(cursor.getColumnIndex("emri"));
        password = cursor.getString(cursor.getColumnIndex("password"));
    }
    public Perdorues(){}


    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String emri;
    private String password;

}
