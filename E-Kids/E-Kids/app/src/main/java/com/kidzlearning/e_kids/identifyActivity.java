package com.kidzlearning.e_kids;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class identifyActivity extends AppCompatActivity {
    public static final String Category="category";
    public static final String curVal="current";
    int cat,current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);
        cat=(int)getIntent().getExtras().get(Category);
        Fragment fragment=new identifyFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("category",cat);
        bundle.putInt("curVal",1);
        fragment.setArguments(bundle);
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
