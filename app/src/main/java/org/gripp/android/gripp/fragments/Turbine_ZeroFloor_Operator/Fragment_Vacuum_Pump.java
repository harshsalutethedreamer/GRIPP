package org.gripp.android.gripp.fragments.Turbine_ZeroFloor_Operator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.gripp.android.gripp.R;
import org.gripp.android.gripp.R2;
import org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator.BaseFragment;
import org.gripp.android.gripp.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 27/05/17.
 */

public class Fragment_Vacuum_Pump extends BaseFragment{

    @BindView(R.id.vacuum_pump_sealwateriloltemp_A)
    EditText vacuum_pump_sealwateriloltemp_A;

    @BindView(R.id.vacuum_pump_sealwateriloltemp_B)
    EditText vacuum_pump_sealwateriloltemp_B;

    @BindView(R.id.vacuum_pump_fisdp_A)
    EditText vacuum_pump_fisdp_A;

    @BindView(R.id.vacuum_pump_fisdp_B)
    EditText vacuum_pump_fisdp_B;

    @BindView(R.id.vacuum_pump_cwilpressure_A)
    EditText vacuum_pump_cwilpressure_A;

    @BindView(R.id.vacuum_pump_cwilpressure_B)
    EditText vacuum_pump_cwilpressure_B;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Vacuum_Pump newInstance(){
        return new Fragment_Vacuum_Pump();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_zerometer_operator_vacuumpumps,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("vacuum_pump_sealwateriloltemp_A",mSharedPreferences.getString(Constants.turbinezerovp[0],""));
        map.put("vacuum_pump_sealwateriloltemp_B",mSharedPreferences.getString(Constants.turbinezerovp[1],""));
        map.put("vacuum_pump_fisdp_A",mSharedPreferences.getString(Constants.turbinezerovp[2],""));
        map.put("vacuum_pump_fisdp_B",mSharedPreferences.getString(Constants.turbinezerovp[3],""));
        map.put("vacuum_pump_cwilpressure_A",mSharedPreferences.getString(Constants.turbinezerovp[4],""));
        map.put("vacuum_pump_cwilpressure_B",mSharedPreferences.getString(Constants.turbinezerovp[5],""));
        
        vacuum_pump_sealwateriloltemp_A.setText(map.get("vacuum_pump_sealwateriloltemp_A"));
        vacuum_pump_sealwateriloltemp_B.setText(map.get("vacuum_pump_sealwateriloltemp_B"));
        vacuum_pump_fisdp_A.setText(map.get("vacuum_pump_fisdp_A"));
        vacuum_pump_fisdp_B.setText(map.get("vacuum_pump_fisdp_B"));
        vacuum_pump_cwilpressure_A.setText(map.get("vacuum_pump_cwilpressure_A"));
        vacuum_pump_cwilpressure_B.setText(map.get("vacuum_pump_cwilpressure_B"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbinezerovp[0],vacuum_pump_sealwateriloltemp_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerovp[1],vacuum_pump_sealwateriloltemp_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerovp[2],vacuum_pump_fisdp_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerovp[3],vacuum_pump_fisdp_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerovp[4],vacuum_pump_cwilpressure_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerovp[5],vacuum_pump_cwilpressure_B.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
