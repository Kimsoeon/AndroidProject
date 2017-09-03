package soeonkim.kr.hs.emirim.androidproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context) {
        super(context, "noteDB", null , 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table noteTable(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " title text, contents text, create_date date)";
        //id INTEGER PRIMARY KEY AUTOINCREMENT,
        db.execSQL(sql); //DATETIME('NOW', 'LOCALTIME
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int ocdldVersion, int newVersion) {
        String sql = "drop table if exists noteTable";
        db.execSQL(sql);
        onCreate(db);
    }
}