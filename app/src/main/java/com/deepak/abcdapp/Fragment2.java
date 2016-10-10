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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    int[] images = {R.drawable.apple, R.drawable.car, R.drawable.ball, R.drawable.elephant, R.drawable.dog};
    String[] imgname = {"Apple","Car","Ball","Elephant","Dog"};
    //HashMap<String, Integer> hashMap;


    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v2 = inflater.inflate(R.layout.fragment_fragment2, container, false);
        ImageView imageView2= (ImageView) v2.findViewById(R.id.imageView2);
        TextView textView2 = (TextView) v2.findViewById(R.id.textView2);

        /*hashMap = new LinkedHashMap<String, Integer>();

        hashMap.put("A",R.drawable.apple);
        hashMap.put("B",R.drawable.ball);
        hashMap.put("C",R.drawable.car);
        hashMap.put("D",R.drawable.dog);
        hashMap.put("E",R.drawable.elephant);*/

        Bundle b = getArguments();
        int pos = b.getInt("imageposition");

        imageView2.setImageResource(images[pos]);

        textView2.setText(imgname[pos]);

        //String alphabet = new ArrayList<String>(hashMap.keySet()).get(pos);
        MainActivity m = (MainActivity) getActivity();
        //m.setAlphaImageFromFrag(alphabet);

        return v2;
    }

}