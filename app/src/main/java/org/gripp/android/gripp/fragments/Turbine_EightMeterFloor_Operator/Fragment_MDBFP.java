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

public class Fragment_MDBFP extends BaseFragment{

    @BindView(R.id.turbine_zeightpointfive_floor_mdbfp_hctanklevel)
    EditText turbine_zeightpointfive_floor_mdbfp_hctanklevel;

    @BindView(R.id.turbine_zeightpointfive_floor_mdbfp_lofilteris)
    EditText turbine_zeightpointfive_floor_mdbfp_lofilteris;

    @BindView(R.id.turbine_zeightpointfive_floor_mdbfp_lofilterdp)
    EditText turbine_zeightpointfive_floor_mdbfp_lofilterdp;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_MDBFP newInstance(){
        return new Fragment_MDBFP();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_eightpointfive_operator_mdbfp,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("turbine_zeightpointfive_floor_mdbfp_hctanklevel",mSharedPreferences.getString(Constants.turbineeightmdbfp[0],""));
        map.put("turbine_zeightpointfive_floor_mdbfp_lofilteris",mSharedPreferences.getString(Constants.turbineeightmdbfp[1],""));
        map.put("turbine_zeightpointfive_floor_mdbfp_lofilterdp",mSharedPreferences.getString(Constants.turbineeightmdbfp[2],""));

        turbine_zeightpointfive_floor_mdbfp_hctanklevel.setText(map.get("turbine_zeightpointfive_floor_mdbfp_hctanklevel"));
        turbine_zeightpointfive_floor_mdbfp_lofilteris.setText(map.get("turbine_zeightpointfive_floor_mdbfp_lofilteris"));
        turbine_zeightpointfive_floor_mdbfp_lofilterdp.setText(map.get("turbine_zeightpointfive_floor_mdbfp_lofilterdp"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbineeightmdbfp[0],turbine_zeightpointfive_floor_mdbfp_hctanklevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightmdbfp[1],turbine_zeightpointfive_floor_mdbfp_lofilteris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineeightmdbfp[2],turbine_zeightpointfive_floor_mdbfp_lofilterdp.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
