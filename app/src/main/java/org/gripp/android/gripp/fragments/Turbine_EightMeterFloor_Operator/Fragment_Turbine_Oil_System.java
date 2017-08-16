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

public class Fragment_Turbine_Oil_System extends BaseFragment{

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_tanklevel)
    EditText turbine_zeightpointfive_floor_turbineoil_tanklevel;

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_cooleris)
    EditText turbine_zeightpointfive_floor_turbineoil_cooleris;

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_cooleroltemp)
    EditText turbine_zeightpointfive_floor_turbineoil_cooleroltemp;

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_vefanis)
    EditText turbine_zeightpointfive_floor_turbineoil_vefanis;

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_motis)
    EditText turbine_zeightpointfive_floor_turbineoil_motis;

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_motdp)
    EditText turbine_zeightpointfive_floor_turbineoil_motdp;

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_ipcv)
    EditText turbine_zeightpointfive_floor_turbineoil_ipcv;

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_hpcvone)
    EditText turbine_zeightpointfive_floor_turbineoil_hpcvone;

    @BindView(R.id.turbine_zeightpointfive_floor_turbineoil_hpcvtwo)
    EditText turbine_zeightpointfive_floor_turbineoil_hpcvtwo;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Turbine_Oil_System newInstance(){
        return new Fragment_Turbine_Oil_System();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_eightpointfive_operator_turbineoil,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("turbine_zeightpointfive_floor_turbineoil_tanklevel",mSharedPreferences.getString(Constants.turbineeightturbineoil[0],""));
        map.put("turbine_zeightpointfive_floor_turbineoil_cooleris",mSharedPreferences.getString(Constants.turbineeightturbineoil[1],""));
        map.put("turbine_zeightpointfive_floor_turbineoil_cooleroltemp",mSharedPreferences.getString(Constants.turbineeightturbineoil[2],""));
        map.put("turbine_zeightpointfive_floor_turbineoil_vefanis",mSharedPreferences.getString(Constants.turbineeightturbineoil[3],""));
        map.put("turbine_zeightpointfive_floor_turbineoil_motis",mSharedPreferences.getString(Constants.turbineeightturbineoil[4],""));
        map.put("turbine_zeightpointfive_floor_turbineoil_motdp",mSharedPreferences.getString(Constants.turbineeightturbineoil[5],""));
        map.put("turbine_zeightpointfive_floor_turbineoil_ipcv",mSharedPreferences.getString(Constants.turbineeightturbineoil[6],""));
        map.put("turbine_zeightpointfive_floor_turbineoil_hpcvone",mSharedPreferences.getString(Constants.turbineeightturbineoil[7],""));
        map.put("turbine_zeightpointfive_floor_turbineoil_hpcvtwo",mSharedPreferences.getString(Constants.turbineeightturbineoil[8],""));

        turbine_zeightpointfive_floor_turbineoil_tanklevel.setText(map.get("turbine_zeightpointfive_floor_turbineoil_tanklevel"));
        turbine_zeightpointfive_floor_turbineoil_cooleris.setText(map.get("turbine_zeightpointfive_floor_turbineoil_cooleris"));
        turbine_zeightpointfive_floor_turbineoil_cooleroltemp.setText(map.get("turbine_zeightpointfive_floor_turbineoil_cooleroltemp"));
        turbine_zeightpointfive_floor_turbineoil_vefanis.setText(map.get("turbine_zeightpointfive_floor_turbineoil_vefanis"));
        turbine_zeightpointfive_floor_turbineoil_motis.setText(map.get("turbine_zeightpointfive_floor_turbineoil_motis"));
        turbine_zeightpointfive_floor_turbineoil_motdp.setText(map.get("turbine_zeightpointfive_floor_turbineoil_motdp"));
        turbine_zeightpointfive_floor_turbineoil_ipcv.setText(map.get("turbine_zeightpointfive_floor_turbineoil_ipcv"));
        turbine_zeightpointfive_floor_turbineoil_hpcvone.setText(map.get("turbine_zeightpointfive_floor_turbineoil_hpcvone"));
        turbine_zeightpointfive_floor_turbineoil_hpcvtwo.setText(map.get("turbine_zeightpointfive_floor_turbineoil_hpcvtwo"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[0],turbine_zeightpointfive_floor_turbineoil_tanklevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[1],turbine_zeightpointfive_floor_turbineoil_cooleris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[2],turbine_zeightpointfive_floor_turbineoil_cooleroltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[3],turbine_zeightpointfive_floor_turbineoil_vefanis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[4],turbine_zeightpointfive_floor_turbineoil_motis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[5],turbine_zeightpointfive_floor_turbineoil_motdp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[6],turbine_zeightpointfive_floor_turbineoil_ipcv.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[7],turbine_zeightpointfive_floor_turbineoil_hpcvone.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbineoil[8],turbine_zeightpointfive_floor_turbineoil_hpcvtwo.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
