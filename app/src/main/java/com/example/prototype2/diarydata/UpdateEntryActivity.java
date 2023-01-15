package com.example.prototype2.diarydata;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prototype2.DiaryActivity;
import com.example.prototype2.R;

public class UpdateEntryActivity  extends AppCompatActivity{
    // variables for our edit text, button, strings and dbhandler class.
    private EditText entryNameEdt, entryDateEdt, entryDescriptionEdt;
    private Button updateEntryBtn,deleteEntryBtn;
    private DBHandler dbHandler;
    String entryName, entryDesc, entryDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_entry);
        // initializing all our variables.
        entryNameEdt = findViewById(R.id.edtEntryName);
        entryDateEdt = findViewById(R.id.edtEntryDate);
        entryDescriptionEdt = findViewById(R.id.edtEntryDetails);
        updateEntryBtn = findViewById(R.id.idBtnUpdateEntry);
        deleteEntryBtn = findViewById(R.id.BtnDelete);

        // on below line we are initialing our dbhandler class.
        dbHandler = new DBHandler(UpdateEntryActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        entryName = getIntent().getStringExtra("title");
        entryDesc = getIntent().getStringExtra("description");
        entryDate = getIntent().getStringExtra("date");

        // setting data to edit text
        // of our update activity.
        entryNameEdt.setText(entryName);
        entryDescriptionEdt.setText(entryDesc);
        entryDateEdt.setText(entryDate);


        updateEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update entry
                // method and passing all our edit text values.
                dbHandler.updateEntry(entryName, entryNameEdt.getText().toString(), entryDescriptionEdt.getText().toString(), entryDateEdt.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateEntryActivity.this, "Entry Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateEntryActivity.this, DiaryActivity.class);
                startActivity(i);
            }
        });
        // adding on click listener for delete button to delete our entry.
        deleteEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our entry.
                dbHandler.deleteEntry(entryName);
                Toast.makeText(UpdateEntryActivity.this, "Deleted the entry", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateEntryActivity.this, DiaryActivity.class);
                startActivity(i);
            }
        });
    }
}

