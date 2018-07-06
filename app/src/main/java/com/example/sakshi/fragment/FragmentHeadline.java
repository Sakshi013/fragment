package com.example.sakshi.fragment;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentHeadline extends Fragment {

    TextView  headline;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_fragment_headline,container,false);

        headline =v.findViewById(R.id.head);
        headline.setText("India");
        return v;
    }

    public static void setOnClickListener(View.OnClickListener news) {
    }
}


