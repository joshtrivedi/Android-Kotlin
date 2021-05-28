package com.example.loginapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class myDBMS(ct: Context):SQLiteOpenHelper(ct,"University",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE STUDENT (SID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT, PASSWD TEXT)")
        db?.execSQL("INSERT INTO STUDENT (UNAME, PASSWD) VALUES ('ROOT','ADMIN')")
        db?.execSQL("INSERT INTO STUDENT (UNAME, PASSWD) VALUES ('JOSH','12345')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}