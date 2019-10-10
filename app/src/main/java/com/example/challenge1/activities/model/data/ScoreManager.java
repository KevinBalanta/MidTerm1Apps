package com.example.challenge1.activities.model.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.challenge1.activities.ArithmeticOperation;
import com.example.challenge1.activities.model.driver.DBDriver;
import com.example.challenge1.activities.model.entity.Score;
import com.example.challenge1.app.ArithGoApp;

import java.util.ArrayList;
import java.util.Random;

public class ScoreManager {



    private static Context context;
   // private static ArithmeticOperation arithm;

   /* public ScoreManager(ArithmeticOperation ar) {
        arithm = ar;

    }*/

    public ScoreManager(Context context) {
    this.context = context;
    }

    public static void sumScore(){
    DBDriver driver = new DBDriver(context, DBDriver.DBNAME, null, DBDriver.DBVERSION );
    SQLiteDatabase db = driver.getWritableDatabase();

    ArrayList<Score> scores = getScores();




    if(scores.isEmpty()){
        ContentValues contentValues = new ContentValues();
        contentValues.put("score", 1);
        db.insert(DBDriver.TABLE_SCORES, null, contentValues);
    }else{
        Score score = scores.get(0);
        int scoreNew = score.getScore()+1;
        ContentValues contentValues = new ContentValues();
        contentValues.put("score", scoreNew);
        db.update(DBDriver.TABLE_SCORES,contentValues, DBDriver.SCORE_ID+" = "+score.getId(),null);
    }


    db.close();
}

    public static void restScore(){
        DBDriver driver = new DBDriver(context, DBDriver.DBNAME, null, DBDriver.DBVERSION );
        SQLiteDatabase db = driver.getWritableDatabase();

        ArrayList<Score> scores = getScores();

        if(scores.isEmpty()){
            ContentValues contentValues = new ContentValues();
            contentValues.put("score", -1);
            db.insert(DBDriver.TABLE_SCORES, null, contentValues);
        }else{
            Score score = scores.get(0);
            int scoreNew = score.getScore()-1;
            ContentValues contentValues = new ContentValues();
            contentValues.put("score", scoreNew);
            db.update(DBDriver.TABLE_SCORES,contentValues, DBDriver.SCORE_ID+"="+score.getId(),null);


        }


        db.close();
    }

public static ArrayList<Score> getScores(){
    DBDriver driver = new DBDriver(context, DBDriver.DBNAME, null, DBDriver.DBVERSION );
    SQLiteDatabase db = driver.getReadableDatabase();

    ArrayList<Score> scores = new ArrayList<>();

    String sql = "SELECT * FROM "+DBDriver.TABLE_SCORES;
    Cursor cursor = db.rawQuery(sql, null);

    if(cursor.moveToFirst()){
        do{

            long id = cursor.getLong(cursor.getColumnIndex(DBDriver.SCORE_ID));
            int score = cursor.getInt(cursor.getColumnIndex(DBDriver.SCORE));

            Score scoreA = new Score(id, score);
            scores.add(scoreA);

        }while(cursor.moveToNext());
    }

    db.close();

    return scores;
}

public void setPoint(boolean a){
 if(a){
     sumScore();
 }else{
     restScore();
 }
}

public Score getScore(){
        ArrayList<Score> scores = getScores();
        if(scores.isEmpty()) {
            return null;
        }

        return  scores.get(0);
}

public void setScore(int scoreP){
    DBDriver driver = new DBDriver(context, DBDriver.DBNAME, null, DBDriver.DBVERSION );
    SQLiteDatabase db = driver.getWritableDatabase();
    ArrayList<Score> scores = getScores();
    ContentValues contentValues = new ContentValues();
    Score score = scores.get(0);
    contentValues.put("score", scoreP);
    db.update(DBDriver.TABLE_SCORES,contentValues, DBDriver.SCORE_ID+"="+score.getId(),null);



    db.close();
}

}
