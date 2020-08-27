package com.example.myfragmentmvcapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;


public class Fragment3 extends Fragment {

    public static final String STATE_MODEL = "STATE_MODEL";
    private Fragment1Model mModel = new Fragment1Model(this.getActivity());



    public static Fragment3 newInstance(Activity mActivity) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        TextView clock = view.findViewById(R.id.textView);
        ToggleButton switchColor = (ToggleButton) view.findViewById(R.id.toggleButton);

        //時刻表示するコードを追加
        Calendar cal = Calendar.getInstance();
        int iYear = cal.get(Calendar.YEAR);         //年を取得
        int iMonth = cal.get(Calendar.MONTH);       //月を取得
        int iDate = cal.get(Calendar.DATE);         //日を取得
        int iHour = cal.get(Calendar.HOUR);         //時を取得
        int iMinute = cal.get(Calendar.MINUTE);    //分を取得
        int iSecond = cal.get(Calendar.SECOND);    //分を取得

        String strDay = iYear + "年" + iMonth + "月" + iDate + "日";     //日付を表示形式で設定
        String strTime = iHour + "時" + iMinute + "分" + iSecond + "秒"; //時刻を表示形式で設

        clock.setText( strDay + "\n"+ strTime);
        //ここまで

        final FragmentManager fragmentManager = getFragmentManager();

        if (savedInstanceState == null) {

            switchColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mModel.swc_cl_swc(fragmentManager, 3);
                    }else {
                        mModel.swc_cl_swc(fragmentManager, 1);

                    }
                }

            });



        }

    }}