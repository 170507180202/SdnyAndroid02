package cn.edu.sdwu.android02.classroom.sn170507180202;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2020/4/29 0029.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    private MyOpenHelper myOpenHelper;
    private String STUDENT_TB_SQL="creat table student(id integer primary key autoincrement,stuname text,stutel text)";
    public MyOpenHelper(Context context){
        //Context context上下文 String name数据库名称 CursorFctory传入MULL int version数据库的版本
        super(context,"stud.db",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //当打开数据库时候 发现数据库并不存在 此时会自动创建数据库 然后调用oncreat 方法
        //在本方法中完成数据库对象的创建 比如表 视图 索引等
        //通过SQLLiteDatabase对象 完成SQL的执行
        sqLiteDatabase.execSQL(STUDENT_TB_SQL);
        Log.i(MyOpenHelper.class.toString(),"onCreate.");


    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("alter table student add column stuadd text");
    }
}
