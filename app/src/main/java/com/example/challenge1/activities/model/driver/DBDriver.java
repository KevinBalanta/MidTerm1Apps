package com.example.challenge1.activities.model.driver;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBDriver extends SQLiteOpenHelper {


    private static DBDriver instance;

    public static synchronized DBDriver getInstance(Context context){
        if(instance == null){
            instance = new DBDriver(context);
        }
        return instance;
    }


    public static final String DBNAME = "arithgoapp";
    public static final int DBVERSION = 1;


    public static final String TABLE_SCORES = "scores";
    public static final String SCORE_ID = "id";
    public static final String SCORE = "score";



    private DBDriver(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    public DBDriver(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_SCORE = "CREATE TABLE $TABLE($ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, $SCORE INTEGER NOT NULL)";

        CREATE_TABLE_SCORE = CREATE_TABLE_SCORE.replace("$TABLE", TABLE_SCORES)
                .replace("$ID", SCORE_ID)
                .replace("$SCORE", SCORE);

        sqLiteDatabase.execSQL(CREATE_TABLE_SCORE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);

        onCreate(sqLiteDatabase);
    }
}
