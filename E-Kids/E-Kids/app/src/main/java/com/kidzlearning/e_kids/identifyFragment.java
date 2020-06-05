package com.kidzlearning.e_kids;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link android.app.Fragment} subclass.
 */

public class identifyFragment extends android.app.Fragment implements View.OnClickListener {
    Intent intent;
    int curVal,cat,ans,opt1,opt2,opt3,opt4;
    String table;
    FragmentManager fragmentManager;
    FragmentTransaction ft;
    android.app.Fragment fragment;
    MediaPlayer mp;

    public identifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_identify, container, false);
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            cat=bundle.getInt("category");
            curVal=bundle.getInt("curVal");
        }
        ImageView op1=(ImageView)v.findViewById(R.id.opt1);
        ImageView op2=(ImageView)v.findViewById(R.id.opt2);
        ImageView op3=(ImageView)v.findViewById(R.id.opt3);
        ImageView op4=(ImageView)v.findViewById(R.id.opt4);
        TextView t=(TextView)v.findViewById(R.id.t1);


        switch(cat)
        {
            case 1:table="iCOLOURS";
                break;
            case 2:table="iSHAPES";
                break;
            case 3:table="iFRUITS";
                break;
        }
        try
        {
            SQLiteOpenHelper ekidsDatabaseHelper=new EkidsDatabaseHelper(getActivity());
            SQLiteDatabase db=ekidsDatabaseHelper.getReadableDatabase();
            Cursor cursor=db.query(table,
                    new String[]{"QUESTION","OPT1","OPT2","OPT3","OPT4","ANSWER"},
                    "_id=?",
                    new String[]{Integer.toString(curVal)},
                    null,null,null);
            if(cursor.moveToFirst()){
                String question=cursor.getString(0);
                opt1=cursor.getInt(1);
                opt2=cursor.getInt(2);
                opt3=cursor.getInt(3);
                opt4=cursor.getInt(4);
                ans=cursor.getInt(5);
                t.setText(question);

                op1.setImageResource(opt1);
                op2.setImageResource(opt2);
                op3.setImageResource(opt3);
                op4.setImageResource(opt4);

            }
            cursor.close();
            db.close();
        }
        catch (SQLiteException e){
            Toast toast=Toast.makeText(getActivity(),"DATABASE UNAVAILABLE",Toast.LENGTH_SHORT);
            toast.show();
        }
        op1.setOnClickListener(this);
        op2.setOnClickListener(this);
        op3.setOnClickListener(this);
        op4.setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {
        Bundle bundle;
        int fl=0;
        fragmentManager = getFragmentManager();
        ft = fragmentManager.beginTransaction();
        fragment = new identifyFragment();
        switch (v.getId()) {
            case R.id.opt1:
                if (opt1 == ans) {
                    fl=1;
                } else {
                    fl=0;
                }
                break;
            case R.id.opt2:
                if (opt2 == ans) {
                    fl=1;
                } else {
                    fl=0;
                }
                break;
            case R.id.opt3:
                if (opt3 == ans) {
                    fl=1;
                } else {
                    fl=0;
                }
                break;
            case R.id.opt4:
                if (opt4 == ans) {
                    fl=1;
                } else {
                    fl=0;
                }
                break;
        }
        int lim=0;
        switch (cat) {
            case 1:lim=6;
                break;
            case 2:lim=5;
                break;
            case 3:lim=5;
                break;
        }
        if(fl==1)
        {
            Toast.makeText(getActivity(), "Correct Answer", Toast.LENGTH_SHORT).show();
            if(curVal<lim) {
                mp=MediaPlayer.create(getActivity(),R.raw.correct);
                mp.start();
                curVal++;
                bundle = new Bundle();
                bundle.putInt("category", cat);
                bundle.putInt("curVal", curVal);
                fragment = new identifyFragment();
                fragment.setArguments(bundle);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ft.replace(R.id.content_frame, fragment);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                        ft.commit();
                    }
                }, 1000);
            }
            else {
                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                alertDialogBuilder
                        .setMessage("WELL DONE!")
                        .setCancelable(false)
                        .setPositiveButton("START OVER", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(getActivity().getApplicationContext(),identifyActivity.class);
                                intent.putExtra(identifyActivity.Category,cat);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                getActivity().finish();
                            }
                        });
                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();
            }
        }
        else{
            mp=MediaPlayer.create(getActivity(),R.raw.wrong);
            mp.start();
            Toast.makeText(getActivity(), "Wrong Answer", Toast.LENGTH_SHORT).show();
        }
    }

}
