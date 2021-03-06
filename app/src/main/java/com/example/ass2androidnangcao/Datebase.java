package com.example.ass2androidnangcao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Datebase extends SQLiteOpenHelper {

    public Datebase(Context context) {
        super(context, "databse.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE monHoc " +
                "(monhoc VARCHAR PRIMARY KEY" +
                ",TrangThai INT" +
                ",Lop VARCHAR" +
                ",LichHoc VARCHAR" +
                ",NgayThi VARCHAR)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long inset(ModelCourse modelCourse) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("monhoc", modelCourse.getMonHoc());
        contentValues.put("TrangThai", modelCourse.getTrangThai());
        contentValues.put("Lop", modelCourse.getLop());
        contentValues.put("LichHoc", modelCourse.getLichHoc());
        contentValues.put("NgayThi", modelCourse.getNgayThi());
        return sqLiteDatabase.insert("monHoc", null, contentValues);
    }

    public List<ModelCourse> getAllCourse() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String select = "SELECT * FROM monHoc ";
        List<ModelCourse> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ModelCourse modelCourse = new ModelCourse();
                modelCourse.setMonHoc(cursor.getString(cursor.getColumnIndex("monhoc")));
                modelCourse.setTrangThai(cursor.getInt(cursor.getColumnIndex("TrangThai")));
                modelCourse.setLop(cursor.getString(cursor.getColumnIndex("Lop")));
                modelCourse.setLichHoc(cursor.getString(cursor.getColumnIndex("LichHoc")));
                modelCourse.setNgayThi(cursor.getString(cursor.getColumnIndex("NgayThi")));
                list.add(modelCourse);
                cursor.moveToNext();
            }
        }
        return list;
    }
    public void update(ModelCourse course ){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TrangThai",course.getTrangThai());
        sqLiteDatabase.update("monHoc",contentValues,"monhoc =?", new String[]{course.getMonHoc()});
    }
}
