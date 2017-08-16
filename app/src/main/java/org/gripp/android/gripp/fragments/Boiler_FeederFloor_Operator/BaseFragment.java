package org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.gripp.android.gripp.utils.Constants;

import java.io.File;
import java.util.Date;

/**
 * Created by harshgupta on 02/03/17.
 */

public class BaseFragment extends Fragment{
    protected SharedPreferences mSharedPreferences;
    protected File root,roota;
    private static final int EXTERNAL_STORAGE_PERMISSION_CONSTANT = 100;
    private SharedPreferences permissionStatus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences=getActivity().getSharedPreferences(Constants.USER_INFO_PREFERENCE, Context.MODE_PRIVATE);
        mSharedPreferences.edit().putLong(Constants.lastLogin,new Date().getTime()).commit();

        Long lastLogin,currentTime;
        lastLogin=mSharedPreferences.getLong(Constants.lastLogin,0);
        currentTime=new Date().getTime();
        Log.i("currenttime",currentTime.toString());
        Log.i("lastLogin",lastLogin.toString());

        if((currentTime-lastLogin)>36000000){
            mSharedPreferences.edit().clear().commit();
        }

        root=new File(Environment.getExternalStorageDirectory(),"GRIPP");
        if(!root.exists()){
            root.mkdirs();
        }
        roota=new File(Environment.getExternalStorageDirectory()+"/GRIPP","PDF");
        if(!root.exists()){
            roota.mkdirs();
        }
    }

    public void checkforpermission(){
        if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},EXTERNAL_STORAGE_PERMISSION_CONSTANT);
        }
//        SharedPreferences.Editor editor=permissionStatus.edit();
//        editor.putBoolean(Manifest.permission.CAMERA,true);
//        editor.commit();
    }
}
