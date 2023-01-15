package com.example.prototype2.diarydata;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototype2.DiaryActivity;
import com.example.prototype2.R;

import java.util.ArrayList;
public class ViewEntries extends AppCompatActivity{
    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<EntryModal> entryModalArrayList;
    private DBHandler dbHandler;
    private EntryRVAdapter entryRVAdapter;
    private RecyclerView entryRV;
    private Button backBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_entry);


        //takes us back to diary activity
        Button backBtn2 = findViewById(R.id.backBtn2);
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewEntries.this, DiaryActivity.class);
                startActivity(i);
            }
        });
        // initializing our all variables.
        entryModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewEntries.this);

        // getting our entry array
        // list from db handler class.
        entryModalArrayList = dbHandler.readEntries();

        // on below line passing our array lost to our adapter class.
        entryRVAdapter = new EntryRVAdapter(entryModalArrayList, ViewEntries.this);
        entryRV = findViewById(R.id.idRVEntries);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewEntries.this, RecyclerView.VERTICAL, false);
        entryRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        entryRV.setAdapter(entryRVAdapter);
    }
}
