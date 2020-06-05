package com.kidzlearning.e_kids;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.R.attr.fragment;

public class categoryActivity extends AppCompatActivity {
    public static final String catType="cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        int cat=(Integer) getIntent().getExtras().get(catType);
        Fragment fragment;
        switch(cat){
            case 1:
                fragment=new learnCatFragment();
                break;
            case 2:
                fragment=new identifyCatFragment();
                break;
            default:
                fragment=new learnCatFragment();
        }
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
