package com.kidzlearning.e_kids;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class learnCatFragment extends android.app.Fragment implements View.OnClickListener{
    Intent intent;


    public learnCatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_learn_cat, container, false);
        ImageButton alphabets=(ImageButton) v.findViewById(R.id.alphabets);
        TextView alp=(TextView)v.findViewById(R.id.alp);
        alp.setOnClickListener(this);
        alphabets.setOnClickListener(this);
        ImageButton numbers=(ImageButton) v.findViewById(R.id.numbers);
        TextView num=(TextView)v.findViewById(R.id.num);
        num.setOnClickListener(this);
        numbers.setOnClickListener(this);
        ImageButton colours=(ImageButton) v.findViewById(R.id.colours);
        TextView col=(TextView)v.findViewById(R.id.col);
        col.setOnClickListener(this);
        colours.setOnClickListener(this);
        ImageButton shapes=(ImageButton) v.findViewById(R.id.shapes);
        TextView sha=(TextView)v.findViewById(R.id.sha);
        sha.setOnClickListener(this);
        shapes.setOnClickListener(this);
        ImageButton fruits=(ImageButton) v.findViewById(R.id.fruits);
        TextView fru=(TextView)v.findViewById(R.id.fru);
        fru.setOnClickListener(this);
        fruits.setOnClickListener(this);


        return v;

    }
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.alphabets:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,1);
                startActivity(intent);
                break;
            case R.id.alp:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,1);
                startActivity(intent);
                break;
            case R.id.numbers:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,2);
                startActivity(intent);
                break;
            case R.id.num:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,2);
                startActivity(intent);
                break;
            case R.id.colours:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,3);
                startActivity(intent);
                break;
            case R.id.col:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,3);
                startActivity(intent);
                break;
            case R.id.shapes:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,4);
                startActivity(intent);
                break;
            case R.id.sha:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,4);
                startActivity(intent);
                break;
            case R.id.fruits:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,5);
                startActivity(intent);
                break;
            case R.id.fru:
                intent=new Intent(getActivity(),learnActivity.class);
                intent.putExtra(learnActivity.Category,5);
                startActivity(intent);
                break;
        }
    }

}
