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

public class Fragment_TDBFP_OIL_TWO extends BaseFragment{

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_waterlevel_A)
    EditText turbine_zero_floor_tdbfpoilsystem_waterlevel_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_waterlevel_B)
    EditText turbine_zero_floor_tdbfpoilsystem_waterlevel_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_watertemp_A)
    EditText turbine_zero_floor_tdbfpoilsystem_watertemp_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_watertemp_B)
    EditText turbine_zero_floor_tdbfpoilsystem_watertemp_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_A)
    EditText turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_B)
    EditText turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_cfsucnflow_A)
    EditText turbine_zero_floor_tdbfpoilsystem_cfsucnflow_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_cfsucnflow_B)
    EditText turbine_zero_floor_tdbfpoilsystem_cfsucnflow_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_heateris_A)
    EditText turbine_zero_floor_tdbfpoilsystem_heateris_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_heateris_B)
    EditText turbine_zero_floor_tdbfpoilsystem_heateris_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_boosterppis_A)
    EditText turbine_zero_floor_tdbfpoilsystem_boosterppis_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_boosterppis_B)
    EditText turbine_zero_floor_tdbfpoilsystem_boosterppis_B;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_TDBFP_OIL_TWO newInstance(){
        return new Fragment_TDBFP_OIL_TWO();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_zerometer_operator_tdbfp_oil_system2,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("turbine_zero_floor_tdbfpoilsystem_waterlevel_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[0],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_waterlevel_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[1],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_watertemp_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[2],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_watertemp_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[3],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[4],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[5],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_cfsucnflow_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[6],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_cfsucnflow_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[7],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_heateris_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[8],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_heateris_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[9],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_boosterppis_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[10],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_boosterppis_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoiltwo[11],""));
        turbine_zero_floor_tdbfpoilsystem_waterlevel_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_waterlevel_A"));
        turbine_zero_floor_tdbfpoilsystem_waterlevel_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_waterlevel_B"));
        turbine_zero_floor_tdbfpoilsystem_watertemp_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_watertemp_A"));
        turbine_zero_floor_tdbfpoilsystem_watertemp_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_watertemp_B"));
        turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_A"));
        turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_B"));
        turbine_zero_floor_tdbfpoilsystem_cfsucnflow_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_cfsucnflow_A"));
        turbine_zero_floor_tdbfpoilsystem_cfsucnflow_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_cfsucnflow_B"));
        turbine_zero_floor_tdbfpoilsystem_heateris_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_heateris_A"));
        turbine_zero_floor_tdbfpoilsystem_heateris_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_heateris_B"));
        turbine_zero_floor_tdbfpoilsystem_boosterppis_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_boosterppis_A"));
        turbine_zero_floor_tdbfpoilsystem_boosterppis_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_boosterppis_B"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[0],turbine_zero_floor_tdbfpoilsystem_waterlevel_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[1],turbine_zero_floor_tdbfpoilsystem_waterlevel_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[2],turbine_zero_floor_tdbfpoilsystem_watertemp_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[3],turbine_zero_floor_tdbfpoilsystem_watertemp_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[4],turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[5],turbine_zero_floor_tdbfpoilsystem_gearboxoillvl_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[6],turbine_zero_floor_tdbfpoilsystem_cfsucnflow_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[7],turbine_zero_floor_tdbfpoilsystem_cfsucnflow_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[8],turbine_zero_floor_tdbfpoilsystem_heateris_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[9],turbine_zero_floor_tdbfpoilsystem_heateris_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[10],turbine_zero_floor_tdbfpoilsystem_boosterppis_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoiltwo[11],turbine_zero_floor_tdbfpoilsystem_boosterppis_B.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
