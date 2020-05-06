package cn.edu.sdwu.android02.classroom.sn170507180202;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by dell on 2020/4/29.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    private String STUDENT_TB_SQL="create table student(id integer primary  key autoincrement,stuname text,stutel text)";
    public MyOpenHelper(Context context){
        //Context context上下文，String name数据库名称，CursorFactory factory传入NULL，int version 数据库的版本
        super(context,"stud.db",null,2);//建立一个学生的数据库stud.db
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //当打开数据库时，数据库并不存在，此时会自动创建数据库，然后调用onCreate方法
        //在本方法，完成数据库对象（表，视图，索引等）的创建
        //通过sqLiteDatabase对象，执行SQL
        sqLiteDatabase.execSQL(STUDENT_TB_SQL);
        Log.i(MyOpenHelper.class.toString(),"onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //当构造方法中制定的版本号，与手机中已有数据库的版本号更新的时候调用本方法
        sqLiteDatabase.execSQL("alter table student and column stuadd text");
    }
}

