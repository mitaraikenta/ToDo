package llocal.hal.st42.android.todo90704

import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context, databaseName:String, factory: SQLiteDatabase.CursorFactory?, version: Int): SQLiteOpenHelper(context, databaseName, factory, version){
    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL("create table tasks (_id integer primary key autoincrement, name text not null, deadline integer, done integer default 0, note text)");
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < newVersion) {
            database?.execSQL("alter table tasks add column deleteFlag integer default 0")
        }
    }
}
