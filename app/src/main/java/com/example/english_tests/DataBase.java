package com.example.english_tests;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(name TEXT primary key, password TEXT, birthday TEXT,age TEXT, gender TEXT,image BLOB,level_reached INTEGER,right_answers1 INTEGER,right_answers2 INTEGER,right_answers3 INTEGER,right_answers4 INTEGER,right_answers5 INTEGER,overall INTEGER,state INTEGER,rate REAL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level1(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level2(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level3(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level4(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level5(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
        db.execSQL("create table contact(firstName TEXT, lastName TEXT, email TEXT,message TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public boolean insertMessage(String firstName, String lastName, String email, String message){
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put("firstName", firstName);
        cv.put("lastName", lastName);
        cv.put("email", email);
        cv.put("message", message);

        long insert = db.insert("contact", null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertUser(String name, String password, String birthday, String age ,String gender , byte[] image, int levelReached,int ra1,int ra2,int ra3,int ra4,int ra5,int oa,int state,float rate) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("password", password);
        cv.put("birthday", birthday);
        cv.put("gender", gender);
        cv.put("image", image);
        cv.put("age", age);
        cv.put("level_reached", levelReached);
        cv.put("right_answers1",ra1);
        cv.put("right_answers2",ra2);
        cv.put("right_answers3",ra3);
        cv.put("right_answers4",ra4);
        cv.put("right_answers5",ra5);
        cv.put("overall",oa);
        cv.put("state",state);
        cv.put("rate",rate);


        long insert = db.insert("users", null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean checkUsername(String user_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String ReadUsers = "SELECT * FROM users WHERE name = ?";
        Cursor cursor = db.rawQuery(ReadUsers, new String[]{user_name});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean checkUserLogged() {
        SQLiteDatabase db = this.getWritableDatabase();
        String ReadUsers = "SELECT name FROM users WHERE state=1";
        Cursor cursor = db.rawQuery(ReadUsers,null);
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    @SuppressLint("Range")
    public String userLogged() {
        SQLiteDatabase db = this.getReadableDatabase();
        String ReadUsers = "SELECT name FROM users WHERE state=1";
        Cursor cursor = db.rawQuery(ReadUsers, null);
        String name = "";
        if (cursor.moveToFirst()) {
            name = cursor.getString(cursor.getColumnIndex("name"));
        }
        return name;
    }


    public boolean checkNamePassword(String user_name, String user_password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String ReadUsers = "SELECT * FROM users WHERE name = ? AND password = ?";
        Cursor cursor = db.rawQuery(ReadUsers, new String[]{user_name, user_password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkNameBirthday(String user_name, String user_birthday) {
        SQLiteDatabase db = this.getWritableDatabase();
        String ReadUsers = "SELECT * FROM users WHERE name = ? AND birthday = ?";
        Cursor cursor = db.rawQuery(ReadUsers, new String[]{user_name, user_birthday});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addColumnToTable(String tableName, String columnName, String columnType) {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean success = false;
        try {
            String query = "ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " " + columnType;
            db.execSQL(query);
            success = true;
        } catch (Exception e) {
        }
        db.close();
        return success;
    }

    public boolean deleteTable(String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean success = false;
        try {
            db.execSQL("DROP TABLE IF EXISTS " + tableName);
            success = true;
        } catch (Exception e) {
        }
        db.close();
        return success;
    }

    @SuppressLint("Range")
    public String selectPasswordByBirthday(String user_birthday, String user_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT password FROM users WHERE birthday = ? AND name = ?";
        String[] selectionArgs = new String[]{user_birthday, user_name};

        String password = null;
        Cursor cursor = db.rawQuery(query, selectionArgs);

        if (cursor.moveToFirst()) {
            password = cursor.getString(cursor.getColumnIndex("password"));
        }

        cursor.close();
        return password;
    }

    Cursor readAlldata() {
        String ReadTableStatement = "SELECT * FROM users ORDER BY overall DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(ReadTableStatement, null);
        }
        return cursor;
    }
    Cursor readUserdata(String user_name) {
        String ReadTableStatement = "SELECT * FROM users WHERE name  = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(ReadTableStatement, new String[]{user_name});
        }
        return cursor;
    }

    public boolean deleteRow(String user_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result1 = db.delete("users", "name=?", new String[]{user_name});
        int result2 =db.delete("users_progress_level1", "name=?", new String[]{user_name});
        int result3 =db.delete("users_progress_level2", "name=?", new String[]{user_name});
        int result4 =db.delete("users_progress_level3", "name=?", new String[]{user_name});
        int result5 =db.delete("users_progress_level4", "name=?", new String[]{user_name});
        int result6 =db.delete("users_progress_level5", "name=?", new String[]{user_name});

        return (result1 > 0 && result2 > 0 &&  result3 > 0 &&  result4 > 0 &&  result5 > 0 && result6>0);
    }
    public boolean createUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("create table users(name TEXT primary key, password TEXT, birthday TEXT,age TEXT, gender TEXT,image BLOB,level_reached INTEGER,right_answers1 INTEGER,right_answers2 INTEGER,right_answer3 INTEGER,right_answers4 INTEGER,right_answers5 INTEGER,overall INTEGER)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean createUsersProgress1Table() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level1(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean createUsersProgress2Table() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level2(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean createUsersProgress3Table() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level3(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean createUsersProgress4Table() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level4(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean createUsersProgress5Table() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS users_progress_level5(name TEXT PRIMARY KEY, question_1 TEXT, question_2 TEXT, question_3 TEXT, question_4 TEXT, question_5 TEXT,question_6 TEXT,question_7 TEXT,question_8 TEXT,question_9 TEXT,question_10 TEXT, right_answers INTEGER, count_answers INTEGER,count_length INTEGER, count_first_letter INTEGER,count_suggestions INTEGER)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean createContactTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("create table contact(firstName TEXT, lastName TEXT, email TEXT,message TEXT)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    public boolean insertUserProgress1(String name, String q1, String q2, String q3, String q4, String q5, String q6,String q7,String q8,String q9,String q10, Integer rightAnswers, Integer countAnswers, Integer countLength, Integer countFirstLetter, Integer countSuggestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("question_1", q1);
        cv.put("question_2", q2);
        cv.put("question_3", q3);
        cv.put("question_4", q4);
        cv.put("question_5", q5);
        cv.put("question_6", q6);
        cv.put("question_7", q7);
        cv.put("question_8", q8);
        cv.put("question_9", q9);
        cv.put("question_10", q10);
        cv.put("right_answers", rightAnswers);
        cv.put("count_answers", countAnswers);
        cv.put("count_length", countLength);
        cv.put("count_first_letter", countFirstLetter);
        cv.put("count_suggestions", countSuggestions);
        long insert = db.insert("users_progress_level1", null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertUserProgress2(String name, String q1, String q2, String q3, String q4, String q5, String q6,String q7,String q8,String q9,String q10, Integer rightAnswers, Integer countAnswers, Integer countLength, Integer countFirstLetter, Integer countSuggestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();  cv.put("name", name);
        cv.put("question_1", q1);
        cv.put("question_2", q2);
        cv.put("question_3", q3);
        cv.put("question_4", q4);
        cv.put("question_5", q5);
        cv.put("question_6", q6);
        cv.put("question_7", q7);
        cv.put("question_8", q8);
        cv.put("question_9", q9);
        cv.put("question_10", q10);
        cv.put("right_answers", rightAnswers);
        cv.put("count_answers", countAnswers);
        cv.put("count_length", countLength);
        cv.put("count_first_letter", countFirstLetter);
        cv.put("count_suggestions", countSuggestions);
        long insert = db.insert("users_progress_level2", null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertUserProgress3(String name, String q1, String q2, String q3, String q4, String q5, String q6,String q7,String q8,String q9,String q10, Integer rightAnswers, Integer countAnswers, Integer countLength, Integer countFirstLetter, Integer countSuggestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();  cv.put("name", name);
        cv.put("question_1", q1);
        cv.put("question_2", q2);
        cv.put("question_3", q3);
        cv.put("question_4", q4);
        cv.put("question_5", q5);
        cv.put("question_6", q6);
        cv.put("question_7", q7);
        cv.put("question_8", q8);
        cv.put("question_9", q9);
        cv.put("question_10", q10);
        cv.put("right_answers", rightAnswers);
        cv.put("count_answers", countAnswers);
        cv.put("count_length", countLength);
        cv.put("count_first_letter", countFirstLetter);
        cv.put("count_suggestions", countSuggestions);
        long insert = db.insert("users_progress_level3", null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertUserProgress4(String name, String q1, String q2, String q3, String q4, String q5, String q6,String q7,String q8,String q9,String q10, Integer rightAnswers, Integer countAnswers, Integer countLength, Integer countFirstLetter, Integer countSuggestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();  cv.put("name", name);
        cv.put("question_1", q1);
        cv.put("question_2", q2);
        cv.put("question_3", q3);
        cv.put("question_4", q4);
        cv.put("question_5", q5);
        cv.put("question_6", q6);
        cv.put("question_7", q7);
        cv.put("question_8", q8);
        cv.put("question_9", q9);
        cv.put("question_10", q10);
        cv.put("right_answers", rightAnswers);
        cv.put("count_answers", countAnswers);
        cv.put("count_length", countLength);
        cv.put("count_first_letter", countFirstLetter);
        cv.put("count_suggestions", countSuggestions);
        long insert = db.insert("users_progress_level4", null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertUserProgress5(String name, String q1, String q2, String q3, String q4, String q5, String q6,String q7,String q8,String q9,String q10, Integer rightAnswers, Integer countAnswers, Integer countLength, Integer countFirstLetter, Integer countSuggestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();  cv.put("name", name);
        cv.put("question_1", q1);
        cv.put("question_2", q2);
        cv.put("question_3", q3);
        cv.put("question_4", q4);
        cv.put("question_5", q5);
        cv.put("question_6", q6);
        cv.put("question_7", q7);
        cv.put("question_8", q8);
        cv.put("question_9", q9);
        cv.put("question_10", q10);
        cv.put("right_answers", rightAnswers);
        cv.put("count_answers", countAnswers);
        cv.put("count_length", countLength);
        cv.put("count_first_letter", countFirstLetter);
        cv.put("count_suggestions", countSuggestions);
        long insert = db.insert("users_progress_level5", null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean updateStringColumn(String table, String name, String column, String newValue) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = " UPDATE " + table + " SET " + column + " = '" + newValue + "' WHERE name=?";
        try {
            db.execSQL(query, new String[]{name});
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateColumnValuePlusOne(String tableName, String columnName, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT " + columnName + " FROM " + tableName + " WHERE name = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{name});

        if (cursor.moveToFirst()) {
            @SuppressLint("Range") int currentValue = cursor.getInt(cursor.getColumnIndex(columnName));
            int newValue = currentValue + 1;

            ContentValues values = new ContentValues();
            values.put(columnName, newValue);

            int rowsAffected = db.update(tableName, values, "name = ?", new String[]{name});
            cursor.close();

            return (rowsAffected > 0);
        } else {
            cursor.close();
            return false;
        }
    }

    public boolean updateIntColumn(String table, String name, String column, int newValue) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = " UPDATE " + table + " SET " + column + " = '" + newValue + "' WHERE name=?";
        try {
            db.execSQL(query, new String[]{name});
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean updateRealColumn(String table, String name, String column, float newValue) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = " UPDATE " + table + " SET " + column + " = '" + newValue + "' WHERE name=?";
        try {
            db.execSQL(query, new String[]{name});
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressLint("Range")
    public int getIntColumn(String tableName, String columnName, String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT " + columnName + " FROM " + tableName + " WHERE name = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{name});
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex(columnName));
        }
        cursor.close();
        return count;
    }
    @SuppressLint("Range")
    public String getStringColumn(String tableName, String columnName, String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT " + columnName + " FROM " + tableName + " WHERE name = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{name});
        String count ="";
        if (cursor.moveToFirst()) {
            count = cursor.getString(cursor.getColumnIndex(columnName));
        }
        cursor.close();
        return count;
    }


    public boolean updateAllColumns(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = " UPDATE users_progress SET right_answers = '0', count_answers= '0', count_length= '0', count_first_letter= '0', count_suggestions= '0',question_1='NaN',question_2='NaN',question_3='NaN',question_4='NaN',question_5='NaN' WHERE name=?";
        try {
            db.execSQL(query, new String[]{name});
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public int getNumberOfUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        int count = 0;
        try {
            Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM users", null);
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
            cursor.close();
        } catch (Exception e) {
            /*do nothing*/
        } finally {
            db.close();
        }
        return count;
    }
}
