package no.westerdals.pg4600.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "measurements.db";
    private static final int DB_VERSION = 1;

    public DbHelper(final Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        String createTablesSQL =
                "create table light ("
                        + "id integer primary key autoincrement,"
                        + "value real,"
                        + "accuracy integer);";

        db.execSQL(createTablesSQL);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        // do nothing
    }
}
