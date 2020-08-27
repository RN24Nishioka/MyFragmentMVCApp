package com.example.myfragmentmvcapp;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1Model {


    Activity mActivity;

    public Fragment1Model(Context context){

    }

    public Fragment1Model(Activity activity){ this.mActivity = activity;
    }

    public void swc_cl_swc(FragmentManager fragmentManager, int color){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.addToBackStack(null);


        switch (color){
            case 1:
                fragmentTransaction.replace(R.id.container, Fragment1.newInstance(mActivity));
                fragmentTransaction.commit();
                break;

            case 2:
                fragmentTransaction.replace(R.id.container, Fragment2.newInstance(mActivity));
                fragmentTransaction.commit();
                break;

            case 3:
                fragmentTransaction.replace(R.id.container, Fragment3.newInstance(mActivity));
                fragmentTransaction.commit();
                break;

        }
    }
}
