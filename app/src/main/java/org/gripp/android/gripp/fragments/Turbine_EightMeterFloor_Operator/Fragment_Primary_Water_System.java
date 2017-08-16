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

public class Fragment_Primary_Water_System extends BaseFragment{

    @BindView(R.id.turbine_zeightpointfive_floor_pws_tanklevel)
    EditText turbine_zeightpointfive_floor_pws_tanklevel;

    @BindView(R.id.turbine_zeightpointfive_floor_pws_npressure)
    EditText turbine_zeightpointfive_floor_pws_npressure;

    @BindView(R.id.turbine_zeightpointfive_floor_pws_pumpis)
    EditText turbine_zeightpointfive_floor_pws_pumpis;

    @BindView(R.id.turbine_zeightpointfive_floor_pws_pumpdischpressure)
    EditText turbine_zeightpointfive_floor_pws_pumpdischpressure;

    @BindView(R.id.turbine_zeightpointfive_floor_pws_ftie)
    EditText turbine_zeightpointfive_floor_pws_ftie;

    @BindView(R.id.turbine_zeightpointfive_floor_pws_mcc)
    EditText turbine_zeightpointfive_floor_pws_mcc;

    @BindView(R.id.turbine_zeightpointfive_floor_pws_ci)
    EditText turbine_zeightpointfive_floor_pws_ci;

    @BindView(R.id.turbine_zeightpointfive_floor_pws_ccopt)
    EditText turbine_zeightpointfive_floor_pws_ccopt;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Primary_Water_System newInstance(){
        return new Fragment_Primary_Water_System();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_eightpointfive_operator_primarywater,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("turbine_zeightpointfive_floor_pws_tanklevel",mSharedPreferences.getString(Constants.turbineeightprimarywater[0],""));
        map.put("turbine_zeightpointfive_floor_pws_npressure",mSharedPreferences.getString(Constants.turbineeightprimarywater[1],""));
        map.put("turbine_zeightpointfive_floor_pws_pumpis",mSharedPreferences.getString(Constants.turbineeightprimarywater[2],""));
        map.put("turbine_zeightpointfive_floor_pws_pumpdischpressure",mSharedPreferences.getString(Constants.turbineeightprimarywater[3],""));
        map.put("turbine_zeightpointfive_floor_pws_ftie",mSharedPreferences.getString(Constants.turbineeightprimarywater[4],""));
        map.put("turbine_zeightpointfive_floor_pws_mcc",mSharedPreferences.getString(Constants.turbineeightprimarywater[5],""));
        map.put("turbine_zeightpointfive_floor_pws_ci",mSharedPreferences.getString(Constants.turbineeightprimarywater[6],""));
        map.put("turbine_zeightpointfive_floor_pws_ccopt",mSharedPreferences.getString(Constants.turbineeightprimarywater[7],""));

        turbine_zeightpointfive_floor_pws_tanklevel.setText(map.get("turbine_zeightpointfive_floor_pws_tanklevel"));
        turbine_zeightpointfive_floor_pws_npressure.setText(map.get("turbine_zeightpointfive_floor_pws_npressure"));
        turbine_zeightpointfive_floor_pws_pumpis.setText(map.get("turbine_zeightpointfive_floor_pws_pumpis"));
        turbine_zeightpointfive_floor_pws_pumpdischpressure.setText(map.get("turbine_zeightpointfive_floor_pws_pumpdischpressure"));
        turbine_zeightpointfive_floor_pws_ftie.setText(map.get("turbine_zeightpointfive_floor_pws_ftie"));
        turbine_zeightpointfive_floor_pws_mcc.setText(map.get("turbine_zeightpointfive_floor_pws_mcc"));
        turbine_zeightpointfive_floor_pws_ci.setText(map.get("turbine_zeightpointfive_floor_pws_ci"));
        turbine_zeightpointfive_floor_pws_ccopt.setText(map.get("turbine_zeightpointfive_floor_pws_ccopt"));

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbineeightprimarywater[0],turbine_zeightpointfive_floor_pws_tanklevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightprimarywater[1],turbine_zeightpointfive_floor_pws_npressure.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightprimarywater[2],turbine_zeightpointfive_floor_pws_pumpis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightprimarywater[3],turbine_zeightpointfive_floor_pws_pumpdischpressure.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightprimarywater[4],turbine_zeightpointfive_floor_pws_ftie.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightprimarywater[5],turbine_zeightpointfive_floor_pws_mcc.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightprimarywater[6],turbine_zeightpointfive_floor_pws_ci.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightprimarywater[7],turbine_zeightpointfive_floor_pws_ccopt.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
