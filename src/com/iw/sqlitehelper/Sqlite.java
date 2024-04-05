package com.iw.sqlitehelper;

import android.database.sqlite.SQLiteDatabase;

public interface Sqlite {
    SQLiteDatabase read();
    SQLiteDatabase write();
}
