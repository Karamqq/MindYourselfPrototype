package com.example.prototype2.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.prototype2.R;
import com.example.prototype2.music.MusicActivity;

import org.w3c.dom.Text;


public class HomeFragment extends Fragment {
private TextView game1,diary1,recharge1,nhs1;
private CardView gameCard1,diaryCard1,rechargeCard1,nhsCard1;
    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        game1 = (TextView) view.findViewById(R.id.gametext);
        gameCard1 = (CardView) view.findViewById(R.id.gameCard);

        recharge1 = (TextView) view.findViewById(R.id.rechargeText);
        rechargeCard1 = (CardView) view.findViewById(R.id.rechargeCard);

        nhs1 = (TextView) view.findViewById(R.id.nhsText);
        nhsCard1 = (CardView) view.findViewById(R.id.nhsCard);

        diary1 = (TextView) view.findViewById(R.id.diaryText);
        diaryCard1 = (CardView) view.findViewById(R.id.diaryCard);

        rechargeCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recharge1.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });

        nhsCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhs1.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });


        diaryCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diary1.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });

        gameCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game1.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}