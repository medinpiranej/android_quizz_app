package com.quizzapp.quizzapp;

import android.database.Cursor;

/**
 * Created by Asus on 2016-04-25.
 */
public class Pyetje {


    public Pyetje(Cursor cursor){
        pyetja = cursor.getString(cursor.getColumnIndex("pyetja"));
        pergjige1 = cursor.getString(cursor.getColumnIndex("pergj1"));
        pergjige2 = cursor.getString(cursor.getColumnIndex("pergj2"));
        pergjige3 = cursor.getString(cursor.getColumnIndex("pergj3"));
        pergjige4 = cursor.getString(cursor.getColumnIndex("pergj4"));

        pergjigjaEsakte = cursor.getInt(cursor.getColumnIndex("sakte"));
    }

    public Pyetje(){}

    private int id;

    private String pyetja;
    private String pergjige1;
    private String pergjige2;
    private String pergjige3;
    private String pergjige4;

    private int pergjigjaEsakte;

    public int getPergjigjaEsakte() {
        return pergjigjaEsakte;
    }

    public void setPergjigjaEsakte(int pergjigjaEsakte) {
        this.pergjigjaEsakte = pergjigjaEsakte;
    }

    public String getPergjige3() {
        return pergjige3;
    }

    public void setPergjige3(String pergjige3) {
        this.pergjige3 = pergjige3;
    }

    public String getPergjige4() {
        return pergjige4;
    }

    public void setPergjige4(String pergjige4) {
        this.pergjige4 = pergjige4;
    }

    public String getPergjige2() {
        return pergjige2;
    }

    public void setPergjige2(String pergjige2) {
        this.pergjige2 = pergjige2;
    }

    public String getPergjige1() {
        return pergjige1;
    }

    public void setPergjige1(String pergjige1) {
        this.pergjige1 = pergjige1;
    }

    public String getPyetja() {
        return pyetja;
    }

    public void setPyetja(String pyetja) {
        this.pyetja = pyetja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
