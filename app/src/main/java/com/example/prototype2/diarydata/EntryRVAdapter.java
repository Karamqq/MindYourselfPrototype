package com.example.prototype2.diarydata;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototype2.R;

import java.util.ArrayList;
public class EntryRVAdapter extends RecyclerView.Adapter<EntryRVAdapter.ViewHolder>{
    // variable for our array list and context
    private ArrayList<EntryModal> entryModalArrayList;
    private Context context;
    // constructor
    public EntryRVAdapter(ArrayList<EntryModal> entryModalArrayList, Context context) {
        this.entryModalArrayList = entryModalArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_rv_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        EntryModal modal = entryModalArrayList.get(position);
        holder.entryNameTV.setText(modal.getEntryName());
        holder.entryDescTV.setText(modal.getEntryDescription());
        holder.entryDateTV.setText(modal.getEntryDate());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateEntryActivity.class);

                // below we are passing all our values.
                i.putExtra("title", modal.getEntryName());
                i.putExtra("description", modal.getEntryDescription());
                i.putExtra("date", modal.getEntryDate());

                // starting our activity.
                context.startActivity(i);
            }
        });

    }
    @Override
    public int getItemCount() {
        // returning the size of our array list
        return entryModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView entryNameTV, entryDescTV, entryDateTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            entryNameTV = itemView.findViewById(R.id.idTVEntryName);
            entryDescTV = itemView.findViewById(R.id.idTVEntryDescription);
            entryDateTV = itemView.findViewById(R.id.idTVEntryDate);
        }
    }

}
