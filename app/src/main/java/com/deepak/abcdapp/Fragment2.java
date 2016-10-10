package com.deepak.abcdapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    int[] images = {R.drawable.apple, R.drawable.ball, R.drawable.car, R.drawable.dog, R.drawable.elephant};
    String[] imgname = {"Apple","Ball","Car","Dog","Elephant"};
    LinkedHashMap<String, Integer> linkedHashMap;


    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v2 = inflater.inflate(R.layout.fragment_fragment2, container, false);
        ImageView imageView2= (ImageView) v2.findViewById(R.id.imageView2);
        TextView textView2 = (TextView) v2.findViewById(R.id.textView2);

        linkedHashMap = new LinkedHashMap<String, Integer>();

        linkedHashMap.put("A",R.drawable.apple);
        linkedHashMap.put("B",R.drawable.ball);
        linkedHashMap.put("C",R.drawable.car);
        linkedHashMap.put("D",R.drawable.dog);
        linkedHashMap.put("E",R.drawable.elephant);

        Bundle b = getArguments();
        int pos = b.getInt("imageposition");

        imageView2.setImageResource(images[pos]);

        textView2.setText(imgname[pos]);

        String alphabet = new ArrayList<String>(linkedHashMap.keySet()).get(pos);
        MainActivity m = (MainActivity) getActivity();
        m.setAlphaImageFromFrag(alphabet);

        return v2;
    }

}