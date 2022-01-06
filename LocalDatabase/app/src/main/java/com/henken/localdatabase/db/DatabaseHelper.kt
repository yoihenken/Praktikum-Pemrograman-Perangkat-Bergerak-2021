package com.henken.localdatabase.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.henken.localdatabase.db.DatabaseContract.QuoteColumns.Companion.TABLE_QUOTE

internal class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME,
    null, DATABASE_VERSION
) {
    companion object {
        private const val DATABASE_NAME = "dbquoteapp"
        private const val DATABASE_VERSION = 5
        private const val SQL_CREATE_TABLE_QUOTE = "CREATE TABLE $TABLE_QUOTE" +
                " (${DatabaseContract.QuoteColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ${DatabaseContract.QuoteColumns.TITLE} TEXT NOT NULL," +
                " ${DatabaseContract.QuoteColumns.DESCRIPTION} TEXT NOT NULL," +
                " ${DatabaseContract.QuoteColumns.CATEGORY} TEXT NOT NULL," +
                " ${DatabaseContract.QuoteColumns.DATE} TEXT NOT NULL)"
    }

    //CTRL + ALT + L
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(SQL_CREATE_TABLE_QUOTE)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_QUOTE")
        }
        onCreate(db)
    }
}