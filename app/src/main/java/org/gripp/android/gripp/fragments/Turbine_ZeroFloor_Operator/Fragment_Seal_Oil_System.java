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

public class Fragment_Seal_Oil_System extends BaseFragment{

    @BindView(R.id.sos_sotlevel)
    EditText sos_sotlevel;

    @BindView(R.id.sos_h2_dischpr)
    EditText sos_h2_dischpr;

    @BindView(R.id.sos_h2_filteris)
    EditText sos_h2_filteris;

    @BindView(R.id.sos_h2_filterdp)
    EditText sos_h2_filterdp;

    @BindView(R.id.sos_h2_cooleroltemp)
    EditText sos_h2_cooleroltemp;

    @BindView(R.id.sos_h2_soph2dp)
    EditText sos_h2_soph2dp;

    @BindView(R.id.sos_airside_sop_A_dischpr)
    EditText sos_airside_sop_A_dischpr;

    @BindView(R.id.sos_airside_sop_B_dischpr)
    EditText sos_airside_sop_B_dischpr;

    @BindView(R.id.sos_airside_filteris)
    EditText sos_airside_filteris;

    @BindView(R.id.sos_airside_filterdp)
    EditText sos_airside_filterdp;

    @BindView(R.id.sos_airside_cooleroltemp)
    EditText sos_airside_cooleroltemp;

    @BindView(R.id.h2_pressure)
    EditText h2_pressure;

    @BindView(R.id.h2_purity)
    EditText h2_purity;

    @BindView(R.id.mdbfp_lo_cooleris)
    EditText mdbfp_lo_cooleris;

    @BindView(R.id.mdbfp_lo_wocoolers)
    EditText mdbfp_lo_wocoolers;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Seal_Oil_System newInstance(){
        return new Fragment_Seal_Oil_System();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_zerometer_operator_sealoilsystem,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        map.put("sos_sotlevel",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[0],""));
        map.put("sos_h2_dischpr",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[1],""));
        map.put("sos_h2_filteris",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[2],""));
        map.put("sos_h2_filterdp",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[3],""));
        map.put("sos_h2_cooleroltemp",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[4],""));
        map.put("sos_h2_soph2dp",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[5],""));
        map.put("sos_airside_sop_A_dischpr",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[6],""));
        map.put("sos_airside_sop_B_dischpr",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[7],""));
        map.put("sos_airside_filteris",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[8],""));
        map.put("sos_airside_filterdp",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[9],""));
        map.put("sos_airside_cooleroltemp",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[10],""));
        map.put("h2_pressure",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[11],""));
        map.put("h2_purity",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[12],""));
        map.put("mdbfp_lo_cooleris",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[13],""));
        map.put("mdbfp_lo_wocoolers",mSharedPreferences.getString(Constants.turbinezerosealoilsystem[14],""));

        sos_sotlevel.setText(map.get("sos_sotlevel"));
        sos_h2_dischpr.setText(map.get("sos_h2_dischpr"));
        sos_h2_filteris.setText(map.get("sos_h2_filteris"));
        sos_h2_filterdp.setText(map.get("sos_h2_filterdp"));
        sos_h2_cooleroltemp.setText(map.get("sos_h2_cooleroltemp"));
        sos_h2_soph2dp.setText(map.get("sos_h2_soph2dp"));
        sos_airside_sop_A_dischpr.setText(map.get("sos_airside_sop_A_dischpr"));
        sos_airside_sop_B_dischpr.setText(map.get("sos_airside_sop_B_dischpr"));
        sos_airside_filteris.setText(map.get("sos_airside_filteris"));
        sos_airside_filterdp.setText(map.get("sos_airside_filterdp"));
        sos_airside_cooleroltemp.setText(map.get("sos_airside_cooleroltemp"));
        h2_pressure.setText(map.get("h2_pressure"));
        h2_purity.setText(map.get("h2_purity"));
        mdbfp_lo_cooleris.setText(map.get("mdbfp_lo_cooleris"));
        mdbfp_lo_wocoolers.setText(map.get("mdbfp_lo_wocoolers"));

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[0],sos_sotlevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[1],sos_h2_dischpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[2],sos_h2_filteris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[3],sos_h2_filterdp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[4],sos_h2_cooleroltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[5],sos_h2_soph2dp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[6],sos_airside_sop_A_dischpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[7],sos_airside_sop_B_dischpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[8],sos_airside_filteris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[9],sos_airside_filterdp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[10],sos_airside_cooleroltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[11],h2_pressure.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[12],h2_purity.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[13],mdbfp_lo_cooleris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerosealoilsystem[14],mdbfp_lo_wocoolers.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
