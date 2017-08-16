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

public class Fragment_TDBFP_OIL_ONE extends BaseFragment{

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_tanklevel_A)
    EditText turbine_zero_floor_tdbfpoilsystem_tanklevel_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_tanklevel_B)
    EditText turbine_zero_floor_tdbfpoilsystem_tanklevel_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_lopis_A)
    EditText turbine_zero_floor_tdbfpoilsystem_lopis_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_lopis_B)
    EditText turbine_zero_floor_tdbfpoilsystem_lopis_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_dischpr_A)
    EditText turbine_zero_floor_tdbfpoilsystem_dischpr_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_dischpr_B)
    EditText turbine_zero_floor_tdbfpoilsystem_dischpr_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_filteris_A)
    EditText turbine_zero_floor_tdbfpoilsystem_filteris_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_filteris_B)
    EditText turbine_zero_floor_tdbfpoilsystem_filteris_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_filterdp_A)
    EditText turbine_zero_floor_tdbfpoilsystem_filterdp_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_filterdp_B)
    EditText turbine_zero_floor_tdbfpoilsystem_filterdp_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_luboilpr_A)
    EditText turbine_zero_floor_tdbfpoilsystem_luboilpr_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_luboilpr_B)
    EditText turbine_zero_floor_tdbfpoilsystem_luboilpr_B;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_vefan_A)
    EditText turbine_zero_floor_tdbfpoilsystem_vefan_A;

    @BindView(R.id.turbine_zero_floor_tdbfpoilsystem_vefan_B)
    EditText turbine_zero_floor_tdbfpoilsystem_vefan_B;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_TDBFP_OIL_ONE newInstance(){
        return new Fragment_TDBFP_OIL_ONE();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_zerometer_operator_tdbfp_oil_system,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        map.put("turbine_zero_floor_tdbfpoilsystem_tanklevel_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[0],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_tanklevel_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[1],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_lopis_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[2],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_lopis_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[3],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_dischpr_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[4],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_dischpr_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[5],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_filteris_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[6],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_filteris_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[7],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_filterdp_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[8],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_filterdp_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[9],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_luboilpr_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[10],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_luboilpr_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[11],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_vefan_A",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[12],""));
        map.put("turbine_zero_floor_tdbfpoilsystem_vefan_B",mSharedPreferences.getString(Constants.turbinezerotdbfpoilone[13],""));

        turbine_zero_floor_tdbfpoilsystem_tanklevel_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_tanklevel_A"));
        turbine_zero_floor_tdbfpoilsystem_tanklevel_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_tanklevel_B"));
        turbine_zero_floor_tdbfpoilsystem_lopis_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_lopis_A"));
        turbine_zero_floor_tdbfpoilsystem_lopis_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_lopis_B"));
        turbine_zero_floor_tdbfpoilsystem_dischpr_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_dischpr_A"));
        turbine_zero_floor_tdbfpoilsystem_dischpr_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_dischpr_B"));
        turbine_zero_floor_tdbfpoilsystem_filteris_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_filteris_A"));
        turbine_zero_floor_tdbfpoilsystem_filteris_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_filteris_B"));
        turbine_zero_floor_tdbfpoilsystem_filterdp_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_filterdp_A"));
        turbine_zero_floor_tdbfpoilsystem_filterdp_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_filterdp_B"));
        turbine_zero_floor_tdbfpoilsystem_luboilpr_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_luboilpr_A"));
        turbine_zero_floor_tdbfpoilsystem_luboilpr_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_luboilpr_B"));
        turbine_zero_floor_tdbfpoilsystem_vefan_A.setText(map.get("turbine_zero_floor_tdbfpoilsystem_vefan_A"));
        turbine_zero_floor_tdbfpoilsystem_vefan_B.setText(map.get("turbine_zero_floor_tdbfpoilsystem_vefan_B"));

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[0],turbine_zero_floor_tdbfpoilsystem_tanklevel_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[1],turbine_zero_floor_tdbfpoilsystem_tanklevel_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[2],turbine_zero_floor_tdbfpoilsystem_lopis_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[3],turbine_zero_floor_tdbfpoilsystem_lopis_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[4],turbine_zero_floor_tdbfpoilsystem_dischpr_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[5],turbine_zero_floor_tdbfpoilsystem_dischpr_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[6],turbine_zero_floor_tdbfpoilsystem_filteris_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[7],turbine_zero_floor_tdbfpoilsystem_filteris_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[8],turbine_zero_floor_tdbfpoilsystem_filterdp_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[9],turbine_zero_floor_tdbfpoilsystem_filterdp_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[10],turbine_zero_floor_tdbfpoilsystem_luboilpr_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[11],turbine_zero_floor_tdbfpoilsystem_luboilpr_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[12],turbine_zero_floor_tdbfpoilsystem_vefan_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerotdbfpoilone[13],turbine_zero_floor_tdbfpoilsystem_vefan_B.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
