package com.example.romanm.a1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentInfo extends Fragment {
    private static final String ARG_NUMBER = "arg_number";

    // TODO: Rename and change types of parameters
    private int number;


    public FragmentInfo() {
        // Required empty public constructor
    }


    public static FragmentInfo newInstance(int number) {
        FragmentInfo fragment = new FragmentInfo();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBER, number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            number = getArguments().getInt(ARG_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        TextView text = (TextView) view.findViewById(R.id.fragment_text);
        text.setText("Fragment " + number);
        return view;
    }

}
