package fr.wildcodeschool.odyssey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by romain on 11/08/16.
 */
public class QuestDAO extends DAOBase {
    public static final String TABLE_NAME = "quest";
    public static final String PK = "_id";
    public static final String TITLE = "title";
    public static final String ABSTRACT = "abstract";
    public static final String OBJECTIVES = "objectives";
    public static final String CHALLENGE_TITLE = "challenge-title";
    public static final String CHALLENGE_BODY = "challenge-body";
    public static final String CHALLENGE_CRITERIA = "challenge-criteria";
    public static final String PARCOURS = "parcours";
    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    PK + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TITLE + " TEXT" +
                    ABSTRACT + " TEXT" +
                    OBJECTIVES + " TEXT" +
                    CHALLENGE_TITLE + " TEXT" +
                    CHALLENGE_BODY + " TEXT" +
                    CHALLENGE_CRITERIA + " TEXT" +
                    PARCOURS + " TEXT);";
    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public QuestDAO(Context pContext) {
        super(pContext);
    }

    public void add(Quest q) {
        ContentValues value = new ContentValues();
        value.put(TITLE, q.getTitle());
        value.put(ABSTRACT, q.get_abstract());
        value.put(OBJECTIVES, q.getObjectives());
        value.put(CHALLENGE_TITLE, q.getChallengeTitle());
        value.put(CHALLENGE_BODY, q.getChallengeBody());
        value.put(CHALLENGE_CRITERIA, q.getChallengeCriteria());
        value.put(PARCOURS, q.getParcours());
        mDb.insert(TABLE_NAME, null, value);
    }

    public void remove(Quest q) {
        mDb.delete(TABLE_NAME, PK + " = ?", new String[] {String.valueOf(q.getId())});
    }

    public void update(Quest q) {
        ContentValues value = new ContentValues();
        value.put(TITLE, q.getTitle());
        value.put(ABSTRACT, q.get_abstract());
        value.put(OBJECTIVES, q.getObjectives());
        value.put(CHALLENGE_TITLE, q.getChallengeTitle());
        value.put(CHALLENGE_BODY, q.getChallengeBody());
        value.put(CHALLENGE_CRITERIA, q.getChallengeCriteria());
        value.put(PARCOURS, q.getParcours());
        mDb.update(TABLE_NAME, value, PK  + " = ?", new String[] {String.valueOf(q.getId())});
    }

    public Quest find(long id) throws Exception {
        Cursor c = mDb.rawQuery("select * from " + TABLE_NAME + " where " + PK + " = ?", new String[]{String.valueOf(id)});
        if (c.getCount() != 1) throw new Exception("Wrong number of quests");
        c.moveToFirst();
        Quest q = new Quest(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7));
        c.close();
        return q;
    }
}
