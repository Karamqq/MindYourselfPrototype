package com.example.prototype2.ui.howto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.prototype2.R;

public class HowToUseFragment  extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_howtouse, container, false);


        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
