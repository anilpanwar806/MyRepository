package com.kidzlearning.e_kids;


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
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class learnFragment extends android.app.Fragment implements View.OnClickListener {
    Intent intent;
    int curVal,cat;
    String table;
    FragmentManager fragmentManager;
    FragmentTransaction ft;
    android.app.Fragment fragment;
    MediaPlayer mp;

    public learnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int imageId,audioId;
        View v=inflater.inflate(R.layout.fragment_learn, container, false);
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            cat=bundle.getInt("category");
            curVal=bundle.getInt("curVal");
        }
        ImageView iv=(ImageView)v.findViewById(R.id.imageView);
        switch(cat)
        {
            case 1:table="ALPHABETS";
                break;
            case 2:table="NUMBERS";
                break;
            case 3:table="COLOURS";
                break;
            case 4:table="SHAPES";
                break;
            case 5:table="FRUITS";
                break;
        }
        try
        {
            SQLiteOpenHelper ekidsDatabaseHelper=new EkidsDatabaseHelper(getActivity());
            SQLiteDatabase db=ekidsDatabaseHelper.getReadableDatabase();
            Cursor cursor=db.query(table,
                                    new String[]{"NAME","IMAGE_RESOURCE_ID","AUDIO_RESOURCE_ID"},
                                    "_id=?",
                                    new String[]{Integer.toString(curVal)},
                                    null,null,null);
            if(cursor.moveToFirst()){
                String name=cursor.getString(0);
                imageId=cursor.getInt(1);
                audioId=cursor.getInt(2);
                iv.setImageResource(imageId);
                mp=MediaPlayer.create(getActivity(),audioId);
            }
            cursor.close();
            db.close();
        }
        catch (SQLiteException e){
            Toast toast=Toast.makeText(getActivity(),"DATABASE UNAVAILABLE",Toast.LENGTH_SHORT);
            toast.show();
        }

        ImageButton prev=(ImageButton)v.findViewById(R.id.prev);
        prev.setOnClickListener(this);
        ImageButton next=(ImageButton)v.findViewById(R.id.next);
        next.setOnClickListener(this);
        iv.setOnClickListener(this);

        return v;
    }
    public void onClick(View v)
    {
        Bundle bundle;
        fragmentManager = getFragmentManager();
        ft= fragmentManager.beginTransaction();
        fragment= new learnFragment();
        switch(v.getId()) {
            case R.id.prev:
                if(curVal!=1) {
                    curVal--;
                    bundle = new Bundle();
                    bundle.putInt("category",cat);
                    bundle.putInt("curVal", curVal);
                    fragment = new learnFragment();
                    fragment.setArguments(bundle);
                    ft.replace(R.id.content_frame, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                    ft.commit();
                }
                break;
            case R.id.next:
                int lim=0;
                switch (cat) {
                    case 1:lim=26;
                        break;
                    case 2:lim=10;
                        break;
                    case 3:lim=6;
                        break;
                    case 4:lim=5;
                        break;
                    case 5:lim=5;
                        break;
                }
                if(curVal<lim) {
                    curVal++;
                    bundle = new Bundle();
                    bundle.putInt("category",cat);
                    bundle.putInt("curVal", curVal);
                    fragment = new learnFragment();
                    fragment.setArguments(bundle);
                    ft.replace(R.id.content_frame, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                    ft.commit();
                }
                else {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                    alertDialogBuilder
                            .setMessage("WELL DONE!")
                            .setCancelable(false)
                            .setPositiveButton("START OVER", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent=new Intent(getActivity().getApplicationContext(),learnActivity.class);
                                    intent.putExtra(learnActivity.Category,cat);
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
                break;
            case R.id.imageView:
                mp.start();


        }
    }

}
