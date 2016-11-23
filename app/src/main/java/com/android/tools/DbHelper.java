package com.android.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "robotsQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private SQLiteDatabase dbase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }

    private void addQuestions() {
        Question q1 = new Question("What is a robot?", "It is a machine", "It is a car", "Is a machine you can use to manipulate tasks", "Is a machine you can use to manipulate tasks");
        this.addQuestion(q1);
        Question q2 = new Question("We have two types of robots, namely _______________?", " Machine and Human robots", "Coputer robots", "Leggo robots and Industrial robots", "Leggo robots and Industrial robots");
        this.addQuestion(q2);
        Question q3 = new Question("What is the meaning of Leggo?", "Play with me", "Lets Play together", "Play well", "Play well");
        this.addQuestion(q3);
        Question q4 = new Question("In which year was Leggo founded?", "1980", "1991", "1932", "1932");
        this.addQuestion(q4);
        Question q5 = new Question("Who is the founder of Leggo foundation?", "Napolion Stardard", "Steve Meyer", "Kjeld Kirk Kristiansen", "Kjeld Kirk Kristiansen");
        this.addQuestion(q5);
        Question q6 = new Question("How may degrees is equal to one rotation?", "260 degrees", "340 degrees", "360 degrees", "360 degrees");
        this.addQuestion(q6);
        Question q7 = new Question("Given 56mm as the diameter of a wheel, calculate the circumference of the wheel?", "70mm", "10mm", "76mm", "76mm");
        this.addQuestion(q7);
        Question q8 = new Question("How many rotations are ther in 720 degrees?", "5 rotations", "10 rotations", "2 rotations", "2 rotations");
        this.addQuestion(q8);
        Question q9 = new Question("How many degrees are there for 4 rotations?", "1980 rotations", "1500 rotations", "1440 rotations", "1440 rotations");
        this.addQuestion(q9);
        Question q10 = new Question("How many wheel rotations are needed to make a U-turn?", "250 rotations", "120 rotations", "270 rotations", "270 rotations");
        this.addQuestion(q10);
        Question q11 = new Question("What is the name for information sent from robot sensors to robot controllers?", "Motor feedback", "temperature", "feedback", "feedback");
        this.addQuestion(q11);
        Question q12 = new Question("Which of the following terms refers to the rotational motion of a robot arm?", " yaw", "swivel", "roll", "roll");
        this.addQuestion(q12);
        Question q13 = new Question("What is the name for the space inside which a robot unit operates?", "spatial base", "environment", "work envelop", "work envelop");
        this.addQuestion(q13);
        Question q14 = new Question("Which of the following terms IS NOT one of the five basic parts of a robot?", "sensor", "end effectors", "peripheral tools", "peripheral tools");
        this.addQuestion(q14);
        Question q15 = new Question("Decision support programs are designed to help managers make:?", "visual presentations", "Visual support", "business decisions", "business decisions");
        this.addQuestion(q15);
        Question q16 = new Question("Which of the following tasks can you use a robot for?", "Write test", "Do measurements", "Clean toilets", "Clean toilets");
        this.addQuestion(q16);
        Question q17 = new Question("You can use a robot to?", "Steal", "Drive", "Perform dangerous tasks", "Perform dangerous tasks");
        this.addQuestion(q17);
        Question q18 = new Question("You can use _____________ to perform repetitive tasks?", "A system", "A counter", "A robot", "A robot");
        this.addQuestion(q18);
        Question q19 = new Question("Which of the following is not a robot use?", "For performing repetitive tasks", "For cleaning dirty places like toilets", "For driving", "For driving");
        this.addQuestion(q19);
        Question q20 = new Question("Robots consist of the following part, namely _________?", "visual parts", "hardware parts", "Motors", "Motors");
        this.addQuestion(q20);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }
}
