package ru.softbalance.database;

import android.database.Cursor;
import android.database.CursorWrapper;

public class SmartCursor extends CursorWrapper {

    public SmartCursor(Cursor cur) {
        super(cur);
    }

    public boolean hasColumn(String column) {
        return this.getColumnIndex(column) >= 0;
    }

    public String getString(String column) {
        return getString(column, "");
    }

    public String getString(String column, String defValue) {
        return hasColumn(column) ? getString(getColumnIndex(column)) : defValue;
    }

    public int getInt(String column) {
        return getInt(column, 0);
    }

    public int getInt(String column, int defValue) {
        return hasColumn(column) ? getInt(getColumnIndex(column)) : defValue;
    }

    public float getFloat(String column) {
        return getFloat(column, 0f);
    }

    public float getFloat(String column, float defValue) {
        return hasColumn(column) ? getFloat(getColumnIndex(column)) : defValue;
    }

    public long getLong(String column) {
        return getLong(column, 0L);
    }

    public long getLong(String column, long defValue) {
        return hasColumn(column) ? getLong(getColumnIndex(column)) : defValue;
    }

    public boolean getBoolean(String column) {
        return getBoolean(column, false);
    }

    public boolean getBoolean(String column, boolean defValue) {
        return hasColumn(column) ? getInt(getColumnIndex(column)) > 0 : defValue;
    }

    public boolean prepare() {
        return !isBeforeFirst() && !isAfterLast() || moveToNext();
    }
}
