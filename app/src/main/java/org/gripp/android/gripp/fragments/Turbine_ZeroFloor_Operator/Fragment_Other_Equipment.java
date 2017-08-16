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

public class Fragment_Other_Equipment extends BaseFragment{

    @BindView(R.id.turbine_zero_floor_pheinservice)
    EditText turbine_zero_floor_pheinservice;

    @BindView(R.id.turbine_zero_floor_condenserpitdewatering)
    EditText turbine_zero_floor_condenserpitdewatering;

    @BindView(R.id.turbine_zero_floor_cylinderstatus_h2)
    EditText turbine_zero_floor_cylinderstatus_h2;

    @BindView(R.id.turbine_zero_floor_cylinderstatus_co2)
    EditText turbine_zero_floor_cylinderstatus_co2;

    @BindView(R.id.turbine_zero_floor_cylinderstatus_n2)
    EditText turbine_zero_floor_cylinderstatus_n2;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Other_Equipment newInstance(){
        return new Fragment_Other_Equipment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_zerometer_operator_otherequipment,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("turbine_zero_floor_pheinservice",mSharedPreferences.getString(Constants.turbinezerocfs[0],""));
        map.put("turbine_zero_floor_condenserpitdewatering",mSharedPreferences.getString(Constants.turbinezerocfs[1],""));
        map.put("turbine_zero_floor_cylinderstatus_h2",mSharedPreferences.getString(Constants.turbinezerocfs[2],""));
        map.put("turbine_zero_floor_cylinderstatus_co2",mSharedPreferences.getString(Constants.turbinezerocfs[3],""));
        map.put("turbine_zero_floor_cylinderstatus_n2",mSharedPreferences.getString(Constants.turbinezerocfs[4],""));

        turbine_zero_floor_pheinservice.setText(map.get("turbine_zero_floor_pheinservice"));
        turbine_zero_floor_condenserpitdewatering.setText(map.get("turbine_zero_floor_condenserpitdewatering"));
        turbine_zero_floor_cylinderstatus_h2.setText(map.get("turbine_zero_floor_cylinderstatus_h2"));
        turbine_zero_floor_cylinderstatus_co2.setText(map.get("turbine_zero_floor_cylinderstatus_co2"));
        turbine_zero_floor_cylinderstatus_n2.setText(map.get("turbine_zero_floor_cylinderstatus_n2"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbinezerocfs[0],turbine_zero_floor_pheinservice.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocfs[1],turbine_zero_floor_condenserpitdewatering.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocfs[2],turbine_zero_floor_cylinderstatus_h2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocfs[3],turbine_zero_floor_cylinderstatus_co2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocfs[4],turbine_zero_floor_cylinderstatus_n2.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
