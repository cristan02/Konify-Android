package com.example.konify;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter {
    DbHelper myhelper;
    public DbAdapter(Context context)
    {
        myhelper = new DbHelper(context);
    }

    public boolean login(String nam, String pass) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {DbHelper.ID, DbHelper.NAME, DbHelper.PASSWORD};
        Cursor cursor =db.query(DbHelper.TABLE_NAME,columns,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            int idCol = cursor.getColumnIndex(DbHelper.ID);
            int nameCol = cursor.getColumnIndex(DbHelper.NAME);
            int passwordCol = cursor.getColumnIndex(DbHelper.PASSWORD);
            int id = cursor.getInt(idCol);
            String name =cursor.getString(nameCol);
            String  password =cursor.getString(passwordCol);
            if (name.equals(nam) && password.equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public long insertData(String email, String name, String pass)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.EMAIL, email);
        contentValues.put(DbHelper.NAME, name);
        contentValues.put(DbHelper.PASSWORD, pass);
        long id = dbb.insert(DbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {DbHelper.ID, DbHelper.EMAIL, DbHelper.NAME, DbHelper.PASSWORD};
        Cursor cursor =db.query(DbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int idCol = cursor.getColumnIndex(DbHelper.ID);
            int emailCol = cursor.getColumnIndex(DbHelper.EMAIL);
            int nameCol = cursor.getColumnIndex(DbHelper.NAME);
            int passwordCol = cursor.getColumnIndex(DbHelper.PASSWORD);
            int id = cursor.getInt(idCol);
            String email = cursor.getString(emailCol);
            String name =cursor.getString(nameCol);
            String  password =cursor.getString(passwordCol);
            buffer.append(id + "   " + email  + "   " + name + "   " + password +" \n");
        }
        return buffer.toString();
    }

    public  int delete(String uname)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uname};

        int count = db.delete(DbHelper.TABLE_NAME ,DbHelper.NAME+" = ?",whereArgs);
        return  count;
    }

    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(DbHelper.TABLE_NAME,contentValues, DbHelper.NAME+" = ?",whereArgs );
        return count;
    }

    static class DbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "Database";
        private static final String TABLE_NAME = "Users";
        private static final int DATABASE_Version = 1;
        private static final String ID ="user_id";
        private static final String EMAIL = "email";
        private static final String NAME = "name";
        private static final String PASSWORD = "password";

        private static final String CREATE_TABLE = String.format("create table %s (%s integer primary key autoincrement, %s varchar(255), %s varchar(255), %s varchar(255));", TABLE_NAME, ID, EMAIL, NAME, PASSWORD);
        private static final String DROP_TABLE = String.format("drop table if exists %s", TABLE_NAME);

        private Context context;

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}
