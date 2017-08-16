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

public class Fragment_Generator_Parameters extends BaseFragment{

    @BindView(R.id.turbine_zeightpointfive_floor_genrator_hdrier)
    EditText turbine_zeightpointfive_floor_genrator_hdrier;

    @BindView(R.id.turbine_zeightpointfive_floor_genrator_drieril)
    EditText turbine_zeightpointfive_floor_genrator_drieril;

    @BindView(R.id.turbine_zeightpointfive_floor_generator_drierol)
    EditText turbine_zeightpointfive_floor_generator_drierol;

    @BindView(R.id.turbine_zeightpointfive_floor_genrator_sealoildp)
    EditText turbine_zeightpointfive_floor_genrator_sealoildp;

    @BindView(R.id.turbine_zeightpointfive_floor_lldtegcee)
    EditText turbine_zeightpointfive_floor_lldtegcee;

    @BindView(R.id.turbine_zeightpointfive_floor_busductgcbairpressure)
    EditText turbine_zeightpointfive_floor_busductgcbairpressure;



    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Generator_Parameters newInstance(){
        return new Fragment_Generator_Parameters();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_eightpointfive_operator_generatorparameters,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("turbine_zeightpointfive_floor_genrator_hdrier",mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[0],""));
        map.put("turbine_zeightpointfive_floor_genrator_drieril",mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[1],""));
        map.put("turbine_zeightpointfive_floor_generator_drierol",mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[2],""));
        map.put("turbine_zeightpointfive_floor_genrator_sealoildp",mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[3],""));
        map.put("turbine_zeightpointfive_floor_lldtegcee",mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[4],""));
        map.put("turbine_zeightpointfive_floor_busductgcbairpressure",mSharedPreferences.getString(Constants.turbineeightgeneratorparameters[5],""));


        turbine_zeightpointfive_floor_genrator_hdrier.setText(map.get("turbine_zeightpointfive_floor_genrator_hdrier"));
        turbine_zeightpointfive_floor_genrator_drieril.setText(map.get("turbine_zeightpointfive_floor_genrator_drieril"));
        turbine_zeightpointfive_floor_generator_drierol.setText(map.get("turbine_zeightpointfive_floor_generator_drierol"));
        turbine_zeightpointfive_floor_genrator_sealoildp.setText(map.get("turbine_zeightpointfive_floor_genrator_sealoildp"));
        turbine_zeightpointfive_floor_lldtegcee.setText(map.get("turbine_zeightpointfive_floor_lldtegcee"));
        turbine_zeightpointfive_floor_busductgcbairpressure.setText(map.get("turbine_zeightpointfive_floor_busductgcbairpressure"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbineeightgeneratorparameters[0],turbine_zeightpointfive_floor_genrator_hdrier.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightgeneratorparameters[1],turbine_zeightpointfive_floor_genrator_drieril.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightgeneratorparameters[2],turbine_zeightpointfive_floor_generator_drierol.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightgeneratorparameters[3],turbine_zeightpointfive_floor_genrator_sealoildp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightgeneratorparameters[4],turbine_zeightpointfive_floor_lldtegcee.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightgeneratorparameters[5],turbine_zeightpointfive_floor_busductgcbairpressure.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
