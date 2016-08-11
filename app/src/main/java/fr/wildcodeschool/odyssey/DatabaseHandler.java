package fr.wildcodeschool.odyssey;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by romain on 11/08/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String QUEST_TABLE_NAME = "Quest";
    public static final String QUEST_PK = "id";
    public static final String QUEST_TITLE = "title";
    public static final String QUEST_ABSTRACT = "abstract";
    public static final String QUEST_OBJECTIVES = "objectives";
    public static final String QUEST_CHALLENGE_TITLE = "challenge-title";
    public static final String QUEST_CHALLENGE_BODY = "challenge-body";
    public static final String QUEST_CHALLENGE_CRITERIA = "challenge-criteria";
    public static final String QUEST_TABLE_CREATE =
            "CREATE TABLE " + QUEST_TABLE_NAME + " (" +
                    QUEST_PK + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    QUEST_TITLE + " TEXT" +
                    QUEST_ABSTRACT + " TEXT" +
                    QUEST_OBJECTIVES + " TEXT" +
                    QUEST_CHALLENGE_TITLE + " TEXT" +
                    QUEST_CHALLENGE_BODY + " TEXT" +
                    QUEST_CHALLENGE_CRITERIA + " TEXT);";
    public static final String QUEST_LOAD_DATA =
            " ";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUEST_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
