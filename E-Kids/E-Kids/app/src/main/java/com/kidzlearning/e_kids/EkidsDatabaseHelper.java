package com.kidzlearning.e_kids;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class EkidsDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="ekids";
    private static final int DB_VERSION=1;

    EkidsDatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE ALPHABETS(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "NAME TEXT,"
                    + "IMAGE_RESOURCE_ID INTEGER,"
                    +"AUDIO_RESOURCE_ID INTEGER);");

        db.execSQL("CREATE TABLE NUMBERS(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT,"
                + "IMAGE_RESOURCE_ID INTEGER,"
                +"AUDIO_RESOURCE_ID INTEGER);");

        db.execSQL("CREATE TABLE COLOURS(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT,"
                + "IMAGE_RESOURCE_ID INTEGER,"
                +"AUDIO_RESOURCE_ID INTEGER);");

        db.execSQL("CREATE TABLE SHAPES(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT,"
                + "IMAGE_RESOURCE_ID INTEGER,"
                +"AUDIO_RESOURCE_ID INTEGER);");

        db.execSQL("CREATE TABLE FRUITS(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT,"
                + "IMAGE_RESOURCE_ID INTEGER,"
                +"AUDIO_RESOURCE_ID INTEGER);");

        db.execSQL("CREATE TABLE iCOLOURS(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "QUESTION TEXT,"
                + "OPT1 INTEGER,"
                + "OPT2 INTEGER,"
                + "OPT3 INTEGER,"
                + "OPT4 INTEGER,"
                + "ANSWER INTEGER);");

        db.execSQL("CREATE TABLE iSHAPES(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "QUESTION TEXT,"
                + "OPT1 INTEGER,"
                + "OPT2 INTEGER,"
                + "OPT3 INTEGER,"
                + "OPT4 INTEGER,"
                + "ANSWER INTEGER);");

        db.execSQL("CREATE TABLE iFRUITS(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "QUESTION TEXT,"
                + "OPT1 INTEGER,"
                + "OPT2 INTEGER,"
                + "OPT3 INTEGER,"
                + "OPT4 INTEGER,"
                + "ANSWER INTEGER);");





        insertAlphabet(db,"A",R.drawable.a,R.raw.a);
        insertAlphabet(db,"B",R.drawable.b,R.raw.b);
        insertAlphabet(db,"C",R.drawable.c,R.raw.c);
        insertAlphabet(db,"D",R.drawable.d,R.raw.d);
        insertAlphabet(db,"E",R.drawable.e,R.raw.e);
        insertAlphabet(db,"F",R.drawable.f,R.raw.f);
        insertAlphabet(db,"G",R.drawable.g,R.raw.g);
        insertAlphabet(db,"H",R.drawable.h,R.raw.h);
        insertAlphabet(db,"I",R.drawable.i,R.raw.i);
        insertAlphabet(db,"J",R.drawable.j,R.raw.j);
        insertAlphabet(db,"K",R.drawable.k,R.raw.k);
        insertAlphabet(db,"L",R.drawable.l,R.raw.l);
        insertAlphabet(db,"M",R.drawable.m,R.raw.m);
        insertAlphabet(db,"N",R.drawable.n,R.raw.n);
        insertAlphabet(db,"O",R.drawable.o,R.raw.o);
        insertAlphabet(db,"P",R.drawable.p,R.raw.p);
        insertAlphabet(db,"Q",R.drawable.q,R.raw.q);
        insertAlphabet(db,"R",R.drawable.r,R.raw.r);
        insertAlphabet(db,"S",R.drawable.s,R.raw.s);
        insertAlphabet(db,"T",R.drawable.t,R.raw.t);
        insertAlphabet(db,"U",R.drawable.u,R.raw.u);
        insertAlphabet(db,"V",R.drawable.v,R.raw.v);
        insertAlphabet(db,"W",R.drawable.w,R.raw.w);
        insertAlphabet(db,"X",R.drawable.x,R.raw.x);
        insertAlphabet(db,"Y",R.drawable.y,R.raw.y);
        insertAlphabet(db,"Z",R.drawable.z,R.raw.z);
        insertNumbers(db,"one",R.drawable.one,R.raw.one);
        insertNumbers(db,"two",R.drawable.two,R.raw.two);
        insertNumbers(db,"three",R.drawable.three,R.raw.three);
        insertNumbers(db,"four",R.drawable.four,R.raw.four);
        insertNumbers(db,"five",R.drawable.five,R.raw.five);
        insertNumbers(db,"six",R.drawable.six,R.raw.six);
        insertNumbers(db,"seven",R.drawable.seven,R.raw.seven);
        insertNumbers(db,"eight",R.drawable.eight,R.raw.eight);
        insertNumbers(db,"nine",R.drawable.nine,R.raw.nine);
        insertNumbers(db,"ten",R.drawable.ten,R.raw.ten);
        insertColours(db,"black",R.drawable.black,R.raw.black);
        insertColours(db,"blue",R.drawable.blue,R.raw.blue);
        insertColours(db,"red",R.drawable.red,R.raw.red);
        insertColours(db,"black",R.drawable.yellow,R.raw.yellow);
        insertColours(db,"black",R.drawable.orange,R.raw.orange1);
        insertColours(db,"black",R.drawable.green,R.raw.green);

        insertShapes(db,"circle",R.drawable.circle,R.raw.circle);
        insertShapes(db,"square",R.drawable.square,R.raw.square);
        insertShapes(db,"oval",R.drawable.oval,R.raw.oval);
        insertShapes(db,"rectangle",R.drawable.rect,R.raw.rectangle);
        insertShapes(db,"triangle",R.drawable.triangle,R.raw.triangle);

        insertFruits(db,"orange",R.drawable.orangefr,R.raw.orange);
        insertFruits(db,"mango",R.drawable.mango,R.raw.mango);
        insertFruits(db,"grapes",R.drawable.grapes,R.raw.grapes);
        insertFruits(db,"apple",R.drawable.apple,R.raw.apple);
        insertFruits(db,"banana",R.drawable.banana,R.raw.banana);

        insertiColours(db,"Click on BLACK colour",R.drawable.black,R.drawable.blue,R.drawable.yellow,R.drawable.green,R.drawable.black);
        insertiColours(db,"Click on BLUE colour",R.drawable.black,R.drawable.blue,R.drawable.yellow,R.drawable.green,R.drawable.blue);
        insertiColours(db,"Click on YELLOW colour",R.drawable.orange,R.drawable.blue,R.drawable.yellow,R.drawable.green,R.drawable.yellow);
        insertiColours(db,"Click on RED colour",R.drawable.orange,R.drawable.red,R.drawable.yellow,R.drawable.green,R.drawable.red);
        insertiColours(db,"Click on GREEN colour",R.drawable.green,R.drawable.blue,R.drawable.yellow,R.drawable.orange,R.drawable.green);
        insertiColours(db,"Click on ORANGE colour",R.drawable.orange,R.drawable.blue,R.drawable.yellow,R.drawable.green,R.drawable.orange);

        insertiShapes(db,"Tap on SQUARE",R.drawable.circle,R.drawable.square,R.drawable.oval,R.drawable.triangle,R.drawable.square);
        insertiShapes(db,"Tap on CIRCLE",R.drawable.square,R.drawable.circle,R.drawable.triangle,R.drawable.oval,R.drawable.circle);
        insertiShapes(db,"Tap on RECTANGLE",R.drawable.circle,R.drawable.square,R.drawable.rect,R.drawable.triangle,R.drawable.rect);
        insertiShapes(db,"Tap on OVAL",R.drawable.oval,R.drawable.rect,R.drawable.circle,R.drawable.triangle,R.drawable.oval);
        insertiShapes(db,"Tap on TRIANGLE",R.drawable.circle,R.drawable.square,R.drawable.triangle,R.drawable.oval,R.drawable.triangle);

        insertiFruits(db,"Touch the MANGO",R.drawable.banana,R.drawable.mango,R.drawable.grapes,R.drawable.apple,R.drawable.mango);
        insertiFruits(db,"Touch the ORANGE",R.drawable.orangefr,R.drawable.banana,R.drawable.apple,R.drawable.mango,R.drawable.orangefr);
        insertiFruits(db,"Touch the GRAPES",R.drawable.banana,R.drawable.grapes,R.drawable.mango,R.drawable.apple,R.drawable.grapes);
        insertiFruits(db,"Touch the APPLE",R.drawable.grapes,R.drawable.apple,R.drawable.orangefr,R.drawable.banana,R.drawable.apple);
        insertiFruits(db,"Touch the BANANA",R.drawable.banana,R.drawable.mango,R.drawable.grapes,R.drawable.apple,R.drawable.banana);




    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }

    private static void insertAlphabet(SQLiteDatabase db,String name,int imageResouceId,int audioResourceId){
        ContentValues alphabetValues=new ContentValues();
        alphabetValues.put("NAME",name);
        alphabetValues.put("IMAGE_RESOURCE_ID",imageResouceId);
        alphabetValues.put("AUDIO_RESOURCE_ID",audioResourceId);
        db.insert("ALPHABETS",null,alphabetValues);
    }

    private static void insertNumbers(SQLiteDatabase db,String name,int imageResouceId,int audioResourceId){
        ContentValues alphabetValues=new ContentValues();
        alphabetValues.put("NAME",name);
        alphabetValues.put("IMAGE_RESOURCE_ID",imageResouceId);
        alphabetValues.put("AUDIO_RESOURCE_ID",audioResourceId);
        db.insert("NUMBERS",null,alphabetValues);
    }

    private static void insertShapes(SQLiteDatabase db,String name,int imageResouceId,int audioResourceId){
        ContentValues alphabetValues=new ContentValues();
        alphabetValues.put("NAME",name);
        alphabetValues.put("IMAGE_RESOURCE_ID",imageResouceId);
        alphabetValues.put("AUDIO_RESOURCE_ID",audioResourceId);
        db.insert("SHAPES",null,alphabetValues);
    }

    private static void insertColours(SQLiteDatabase db,String name,int imageResouceId,int audioResourceId){
        ContentValues alphabetValues=new ContentValues();
        alphabetValues.put("NAME",name);
        alphabetValues.put("IMAGE_RESOURCE_ID",imageResouceId);
        alphabetValues.put("AUDIO_RESOURCE_ID",audioResourceId);
        db.insert("COLOURS",null,alphabetValues);
    }

    private static void insertFruits(SQLiteDatabase db,String name,int imageResouceId,int audioResourceId){
        ContentValues alphabetValues=new ContentValues();
        alphabetValues.put("NAME",name);
        alphabetValues.put("IMAGE_RESOURCE_ID",imageResouceId);
        alphabetValues.put("AUDIO_RESOURCE_ID",audioResourceId);
        db.insert("FRUITS",null,alphabetValues);
    }
    private static void insertiColours(SQLiteDatabase db,String question,int opt1,int opt2,int opt3,int opt4,int ans){
        ContentValues alphabetValues=new ContentValues();
        alphabetValues.put("QUESTION",question);
        alphabetValues.put("OPT1",opt1);
        alphabetValues.put("OPT2",opt2);
        alphabetValues.put("OPT3",opt3);
        alphabetValues.put("OPT4",opt4);
        alphabetValues.put("ANSWER",ans);
        db.insert("iCOLOURS",null,alphabetValues);
    }

    private static void insertiShapes(SQLiteDatabase db,String question,int opt1,int opt2,int opt3,int opt4,int ans){
        ContentValues alphabetValues=new ContentValues();
        alphabetValues.put("QUESTION",question);
        alphabetValues.put("OPT1",opt1);
        alphabetValues.put("OPT2",opt2);
        alphabetValues.put("OPT3",opt3);
        alphabetValues.put("OPT4",opt4);
        alphabetValues.put("ANSWER",ans);
        db.insert("iSHAPES",null,alphabetValues);
    }

    private static void insertiFruits(SQLiteDatabase db,String question,int opt1,int opt2,int opt3,int opt4,int ans){
        ContentValues alphabetValues=new ContentValues();
        alphabetValues.put("QUESTION",question);
        alphabetValues.put("OPT1",opt1);
        alphabetValues.put("OPT2",opt2);
        alphabetValues.put("OPT3",opt3);
        alphabetValues.put("OPT4",opt4);
        alphabetValues.put("ANSWER",ans);
        db.insert("iFRUITS",null,alphabetValues);
    }

}
