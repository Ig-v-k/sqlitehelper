package com.iw.sqlitehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class SqliteHelper extends SQLiteOpenHelper implements Sqlite {

    private Sql sql;

    public SqliteHelper(final Context context,
                        final String databaseName,
                        final int version,
                        final Sql sql) {
        this(context, databaseName, null, version, sql);
    }

    private SqliteHelper(final Context context,
                         final String databaseName,
                         final SQLiteDatabase.CursorFactory factory,
                         final int version,
                         final Sql sql) {
        super(context, databaseName, factory, version);
        this.sql = sql;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql.asString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.setVersion(newVersion);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.setVersion(newVersion);
    }

    @Override
    public SQLiteDatabase read() {
        return getReadableDatabase();
    }

    @Override
    public SQLiteDatabase write() {
        return getWritableDatabase();
    }
}
