package org.gripp.android.gripp.fragments.Turbine_EightMeterFloor_Operator;

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

public class Fragment_Other_Oil_System extends BaseFragment{

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_spraymanvv)
    EditText turbine_zeightpointfive_floor_otheroil_spraymanvv;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_bp1oillvl)
    EditText turbine_zeightpointfive_floor_otheroil_bp1oillvl;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_bp2oillvl)
    EditText turbine_zeightpointfive_floor_otheroil_bp2oillvl;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_sealsteam_cv)
    EditText turbine_zeightpointfive_floor_otheroil_sealsteam_cv;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_leaksteam_cv)
    EditText turbine_zeightpointfive_floor_otheroil_leaksteam_cv;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_vacuumbreaker)
    EditText turbine_zeightpointfive_floor_otheroil_vacuumbreaker;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_hpevacvalve)
    EditText turbine_zeightpointfive_floor_otheroil_hpevacvalve;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_motcentrifudge_waterlevel)
    EditText turbine_zeightpointfive_floor_otheroil_motcentrifudge_waterlevel;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_motcentrifudge_watertemp)
    EditText turbine_zeightpointfive_floor_otheroil_motcentrifudge_watertemp;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_motcentrifudge_gearboxoillvl)
    EditText turbine_zeightpointfive_floor_otheroil_motcentrifudge_gearboxoillvl;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_motcentrifudge_cfsucnflow)
    EditText turbine_zeightpointfive_floor_otheroil_motcentrifudge_cfsucnflow;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_motcentrifudge_heateris)
    EditText turbine_zeightpointfive_floor_otheroil_motcentrifudge_heateris;

    @BindView(R.id.turbine_zeightpointfive_floor_otheroil_motcentrifudge_boosterppis)
    EditText turbine_zeightpointfive_floor_otheroil_motcentrifudge_boosterppis;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Other_Oil_System newInstance(){
        return new Fragment_Other_Oil_System();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_eightpointfive_operator_otheroil,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("turbine_zeightpointfive_floor_otheroil_spraymanvv",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[0],""));
        map.put("turbine_zeightpointfive_floor_otheroil_bp1oillvl",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[1],""));
        map.put("turbine_zeightpointfive_floor_otheroil_bp2oillvl",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[2],""));
        map.put("turbine_zeightpointfive_floor_otheroil_sealsteam_cv",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[3],""));
        map.put("turbine_zeightpointfive_floor_otheroil_leaksteam_cv",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[4],""));
        map.put("turbine_zeightpointfive_floor_otheroil_vacuumbreaker",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[5],""));
        map.put("turbine_zeightpointfive_floor_otheroil_hpevacvalve",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[6],""));
        map.put("turbine_zeightpointfive_floor_otheroil_motcentrifudge_waterlevel",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[7],""));
        map.put("turbine_zeightpointfive_floor_otheroil_motcentrifudge_watertemp",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[8],""));
        map.put("turbine_zeightpointfive_floor_otheroil_motcentrifudge_gearboxoillvl",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[9],""));
        map.put("turbine_zeightpointfive_floor_otheroil_motcentrifudge_cfsucnflow",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[10],""));
        map.put("turbine_zeightpointfive_floor_otheroil_motcentrifudge_heateris",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[11],""));
        map.put("turbine_zeightpointfive_floor_otheroil_motcentrifudge_boosterppis",mSharedPreferences.getString(Constants.turbineeightotheroilsystem[12],""));

        turbine_zeightpointfive_floor_otheroil_spraymanvv.setText(map.get("turbine_zeightpointfive_floor_otheroil_spraymanvv"));
        turbine_zeightpointfive_floor_otheroil_bp1oillvl.setText(map.get("turbine_zeightpointfive_floor_otheroil_bp1oillvl"));
        turbine_zeightpointfive_floor_otheroil_bp2oillvl.setText(map.get("turbine_zeightpointfive_floor_otheroil_bp2oillvl"));
        turbine_zeightpointfive_floor_otheroil_sealsteam_cv.setText(map.get("turbine_zeightpointfive_floor_otheroil_sealsteam_cv"));
        turbine_zeightpointfive_floor_otheroil_leaksteam_cv.setText(map.get("turbine_zeightpointfive_floor_otheroil_leaksteam_cv"));
        turbine_zeightpointfive_floor_otheroil_vacuumbreaker.setText(map.get("turbine_zeightpointfive_floor_otheroil_vacuumbreaker"));
        turbine_zeightpointfive_floor_otheroil_hpevacvalve.setText(map.get("turbine_zeightpointfive_floor_otheroil_hpevacvalve"));
        turbine_zeightpointfive_floor_otheroil_motcentrifudge_waterlevel.setText(map.get("turbine_zeightpointfive_floor_otheroil_motcentrifudge_waterlevel"));
        turbine_zeightpointfive_floor_otheroil_motcentrifudge_watertemp.setText(map.get("turbine_zeightpointfive_floor_otheroil_motcentrifudge_watertemp"));
        turbine_zeightpointfive_floor_otheroil_motcentrifudge_gearboxoillvl.setText(map.get("turbine_zeightpointfive_floor_otheroil_motcentrifudge_gearboxoillvl"));
        turbine_zeightpointfive_floor_otheroil_motcentrifudge_cfsucnflow.setText(map.get("turbine_zeightpointfive_floor_otheroil_motcentrifudge_cfsucnflow"));
        turbine_zeightpointfive_floor_otheroil_motcentrifudge_heateris.setText(map.get("turbine_zeightpointfive_floor_otheroil_motcentrifudge_heateris"));
        turbine_zeightpointfive_floor_otheroil_motcentrifudge_boosterppis.setText(map.get("turbine_zeightpointfive_floor_otheroil_motcentrifudge_boosterppis"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[0],turbine_zeightpointfive_floor_otheroil_spraymanvv.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[1],turbine_zeightpointfive_floor_otheroil_bp1oillvl.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[2],turbine_zeightpointfive_floor_otheroil_bp2oillvl.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[3],turbine_zeightpointfive_floor_otheroil_sealsteam_cv.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[4],turbine_zeightpointfive_floor_otheroil_leaksteam_cv.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[5],turbine_zeightpointfive_floor_otheroil_vacuumbreaker.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[6],turbine_zeightpointfive_floor_otheroil_hpevacvalve.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[7],turbine_zeightpointfive_floor_otheroil_motcentrifudge_waterlevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[8],turbine_zeightpointfive_floor_otheroil_motcentrifudge_watertemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[9],turbine_zeightpointfive_floor_otheroil_motcentrifudge_gearboxoillvl.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[10],turbine_zeightpointfive_floor_otheroil_motcentrifudge_cfsucnflow.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[11],turbine_zeightpointfive_floor_otheroil_motcentrifudge_heateris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightotheroilsystem[12],turbine_zeightpointfive_floor_otheroil_motcentrifudge_boosterppis.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
