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

public class Fragment_Turbin_CF_System extends BaseFragment{

    @BindView(R.id.turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvone)
    EditText turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvone;

    @BindView(R.id.turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvtwo)
    EditText turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvtwo;

    @BindView(R.id.turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvone)
    EditText turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvone;

    @BindView(R.id.turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvtwo)
    EditText turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvtwo;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Turbin_CF_System newInstance(){
        return new Fragment_Turbin_CF_System();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_eightpointfive_operator_turbincfpresures,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvone",mSharedPreferences.getString(Constants.turbineeightturbinecf[0],""));
        map.put("turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvtwo",mSharedPreferences.getString(Constants.turbineeightturbinecf[1],""));
        map.put("turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvone",mSharedPreferences.getString(Constants.turbineeightturbinecf[2],""));
        map.put("turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvtwo",mSharedPreferences.getString(Constants.turbineeightturbinecf[3],""));

        turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvone.setText(map.get("turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvone"));
        turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvtwo.setText(map.get("turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvtwo"));
        turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvone.setText(map.get("turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvone"));
        turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvtwo.setText(map.get("turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvtwo"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbineeightturbinecf[0],turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvone.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbinecf[1],turbine_zeightpointfive_floor_turbinecfpressure_cvposition_hpcvtwo.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbinecf[2],turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvone.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightturbinecf[3],turbine_zeightpointfive_floor_turbinecfpressure_cvposition_ipcvtwo.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
