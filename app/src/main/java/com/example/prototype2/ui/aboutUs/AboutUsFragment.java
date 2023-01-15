package com.example.prototype2.ui.aboutUs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.prototype2.R;


public class AboutUsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aboutus, container, false);


        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}