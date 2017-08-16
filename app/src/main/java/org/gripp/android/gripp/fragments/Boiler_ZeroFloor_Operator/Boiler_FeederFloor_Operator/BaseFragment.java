package org.gripp.android.gripp.fragments.Boiler_ZeroFloor_Operator.Boiler_FeederFloor_Operator;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import org.gripp.android.gripp.utils.Constants;

import java.io.File;
import java.util.Date;

/**
 * Created by harshgupta on 02/03/17.
 */

public class BaseFragment extends Fragment{
    protected SharedPreferences mSharedPreferences;
    protected File root;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences=getActivity().getSharedPreferences(Constants.USER_INFO_PREFERENCE, Context.MODE_PRIVATE);
        mSharedPreferences.edit().putLong(Constants.lastLogin,new Date().getTime()).commit();

        Long lastLogin,currentTime;
        lastLogin=mSharedPreferences.getLong(Constants.lastLogin,0);
        currentTime=new Date().getTime();

        if((currentTime-lastLogin)>36000000){
            mSharedPreferences.edit().clear().commit();
        }

        root=new File(Environment.getExternalStorageDirectory(),"GRIPP");
        if(!root.exists()){
            root.mkdirs();
        }
    }
}
