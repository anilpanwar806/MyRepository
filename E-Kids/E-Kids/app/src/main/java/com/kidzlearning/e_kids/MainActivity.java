package com.kidzlearning.e_kids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void learnMod(View view)
    {
        Intent intent=new Intent(this,categoryActivity.class);
        intent.putExtra(categoryActivity.catType,1);
        startActivity(intent);
    }
    public void identifyMod(View view)
    {
        Intent intent=new Intent(this,categoryActivity.class);
        intent.putExtra(categoryActivity.catType,2);
        startActivity(intent);
    }
    public void playMod(View view)
    {
        Intent intent=new Intent(this,PlayActivity.class);
        startActivity(intent);
    }

}
