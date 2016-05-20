package no.westerdals.pg4600.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class LightDataSource {
    private SQLiteDatabase db;
    private DbHelper dbHelper;

    public LightDataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void saveLight(Light light) {
        ContentValues contentValues = new ContentValues();
        // table -> value
        contentValues.put("value", light.getValue());
        contentValues.put("accuracy", light.getAccuracy());

        long id = db.insert("light", null, contentValues);
    }

    public List<Light> getLightMeasurements() {
        List<Light> lights = new ArrayList<>();

        String[] columns = { "id", "value", "accuracy" };

        Cursor cursor = db.query("light", columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lights.add(lightFromCursor(cursor));
            cursor.moveToNext();
        }

        return lights;
    }

    private Light lightFromCursor(final Cursor cursor) {
        Light light = new Light();

        light.setId(cursor.getInt(0));
        light.setValue(cursor.getFloat(1));
        light.setAccuracy(cursor.getInt(2));

        return light;
    }
}
