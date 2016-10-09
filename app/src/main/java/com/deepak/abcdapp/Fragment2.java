package com.deepak.abcdapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    int[] images = {R.drawable.apple, R.drawable.ball, R.drawable.car, R.drawable.dog, R.drawable.elephant};

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v2 = inflater.inflate(R.layout.fragment_fragment2, container, false);
        ImageView imageView2= (ImageView) v2.findViewById(R.id.imageView2);

        Bundle b = getArguments();
        int pos = b.getInt("imageposition");

        imageView2.setImageResource(images[pos]);

        return v2;
    }

}
