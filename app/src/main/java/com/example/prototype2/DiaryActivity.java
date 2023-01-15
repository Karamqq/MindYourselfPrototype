package com.example.prototype2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prototype2.diarydata.DBHandler;
import com.example.prototype2.diarydata.ViewEntries;
import com.example.prototype2.ui.features.FeaturesFragment;

public class DiaryActivity extends AppCompatActivity {
    // creating variables for our edittext, button and dbhandler
    private EditText entryNameEdt,entryDateEdt, entryDescriptionEdt;
    private Button addEntryBtn,readEntryBtn,backBtn;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        // initializing all our variables.
        entryNameEdt = findViewById(R.id.edtEntryName);
        entryDateEdt = findViewById(R.id.edtEntryDate);
        entryDescriptionEdt = findViewById(R.id.edtEntryDetails);
        addEntryBtn = findViewById(R.id.addEntry);
        readEntryBtn = findViewById(R.id.BtnReadEntry);
        backBtn = findViewById(R.id.BtnBacktoHome);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(DiaryActivity.this);

        //button takes you back to homepage
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DiaryActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        // below line is to add on click listener for our add entry button.
        addEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String entryName = entryNameEdt.getText().toString();
                String entryDate = entryDateEdt.getText().toString();
                String entryDescription = entryDescriptionEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (entryName.isEmpty() && entryDate.isEmpty() && entryDescription.isEmpty()) {
                    Toast.makeText(DiaryActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();

                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewEntry(entryName, entryDate, entryDescription);

                readEntryBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // opening a new activity via a intent.
                        Intent i = new Intent(DiaryActivity.this, ViewEntries.class);
                        startActivity(i);
                    }
                });

                // after adding the data we are displaying a toast message.
                Toast.makeText(DiaryActivity.this, "Entry has been added.", Toast.LENGTH_SHORT).show();
                entryNameEdt.setText("");
                entryDateEdt.setText("");
                entryDescriptionEdt.setText("");
            }
        });

        //opens the view entry class
        readEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(DiaryActivity.this, ViewEntries.class);
                startActivity(i);
            }
        });

    }

    }


