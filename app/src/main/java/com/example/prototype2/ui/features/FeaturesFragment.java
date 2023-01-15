package com.example.prototype2.ui.features;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.prototype2.SleepActivity;
import com.example.prototype2.music.MusicActivity;
import com.example.prototype2.DiaryActivity;
import com.example.prototype2.QuotesActivity;
import com.example.prototype2.R;

public class FeaturesFragment extends Fragment {

    //creates buttons
    Button button,button1, button2,button3;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_features, container, false);
            //sets buttons to view
            button = (Button) view.findViewById(R.id.button);
            button1 = (Button) view.findViewById(R.id.button1);
            button2 = (Button) view.findViewById(R.id.button2);
            button3 = (Button) view.findViewById(R.id.button3);

            //opens music activity
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), MusicActivity.class);
                    startActivity(intent);
                }
            });

            //opens quotes activity
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), QuotesActivity.class);
                    startActivity(intent);
                }
            });

            //opens diary activity
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), DiaryActivity.class);
                    startActivity(intent);
                }
            });

            //opens sleep activity
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), SleepActivity.class);
                    startActivity(intent);
                }
            });
            return view;
        }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    }





