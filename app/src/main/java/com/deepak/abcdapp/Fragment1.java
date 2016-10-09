package com.deepak.abcdapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    String[] alpha = {"A","B","C","D","E"};

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);
        TextView textView1 = (TextView) v.findViewById(R.id.textView1);
        //ImageView imageView = (ImageView) v.findViewById(R.id.imageView1);

        Bundle b = getArguments();
        int pos = b.getInt("imgposition");

        textView1.setText(alpha[pos]);
        //imageView.setImageResource(images[pos]);
        MainActivity m = (MainActivity) getActivity();


        return v;
    }

}
