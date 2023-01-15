package com.example.prototype2.diarydata;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "diarydbFinal";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "myEntries";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our entry title column
    private static final String NAME_COL = "title";

    // below variable id for our entry date column.
    private static final String DATE_COL = "date";

    // below variable for our entry description column.
    private static final String DESCRIPTION_COL = "description";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DATE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    /**
     *
     * @param entryName
     * @param entryDate
     * @param entryDescription
     */
    public void addNewEntry(String entryName, String entryDate, String entryDescription) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, entryName);
        values.put(DATE_COL, entryDate);
        values.put(DESCRIPTION_COL, entryDescription);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // we have created a new method for reading all the entries.
    public ArrayList<EntryModal> readEntries() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorEntries = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<EntryModal> entryModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorEntries.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                entryModalArrayList.add(new EntryModal(cursorEntries.getString(1),
                        cursorEntries.getString(2),
                        cursorEntries.getString(3)));
            } while (cursorEntries.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorEntries.close();
        return entryModalArrayList;
    }

    // below is the method for updating our entries
    public void updateEntry(String originalEntryName, String entryName, String entryDescription,
                            String entryDate) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, entryName);
        values.put(DATE_COL, entryDate);
        values.put(DESCRIPTION_COL, entryDescription);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "title=?", new String[]{originalEntryName});
        db.close();
    }
    // below is the method for deleting our entries.
    public void deleteEntry(String entryName) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // entry and we are comparing it with our entry name.
        db.delete(TABLE_NAME, "title=?", new String[]{entryName});
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



}
