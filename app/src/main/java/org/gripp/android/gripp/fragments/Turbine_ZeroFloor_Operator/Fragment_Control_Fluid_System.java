package org.gripp.android.gripp.fragments.Turbine_ZeroFloor_Operator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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

public class Fragment_Control_Fluid_System extends BaseFragment{

    @BindView(R.id.cft_level)
    EditText cft_level;

    @BindView(R.id.cft_pumpis)
    EditText cft_pumpis;

    @BindView(R.id.cft_dischprhp)
    EditText cft_dischprhp;

    @BindView(R.id.cft_dischprlp)
    EditText cft_dischprlp;

    @BindView(R.id.cft_vefis)
    EditText cft_vefis;

    @BindView(R.id.cft_cooleris)
    EditText cft_cooleris;

    @BindView(R.id.cft_tanktemp)
    EditText cft_tanktemp;

    @BindView(R.id.cft_filterisdp)
    EditText cft_filterisdp;

    @BindView(R.id.cft_rcppisdischpr)
    EditText cft_rcppisdischpr;

    @BindView(R.id.cft_dotlevel)
    EditText cft_dotlevel;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Control_Fluid_System newInstance(){
        return new Fragment_Control_Fluid_System();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_zerometer_operator_contro_fluid_system,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("cft_level",mSharedPreferences.getString(Constants.turbinezerocontrofluid[0],""));
        Log.d("hello",mSharedPreferences.getString(Constants.turbinezerocontrofluid[0],""));
        map.put("cft_pumpis",mSharedPreferences.getString(Constants.turbinezerocontrofluid[1],""));
        map.put("cft_dischprhp",mSharedPreferences.getString(Constants.turbinezerocontrofluid[2],""));
        map.put("cft_dischprlp",mSharedPreferences.getString(Constants.turbinezerocontrofluid[3],""));
        map.put("cft_vefis",mSharedPreferences.getString(Constants.turbinezerocontrofluid[4],""));
        map.put("cft_cooleris",mSharedPreferences.getString(Constants.turbinezerocontrofluid[5],""));
        map.put("cft_tanktemp",mSharedPreferences.getString(Constants.turbinezerocontrofluid[6],""));
        map.put("cft_filterisdp",mSharedPreferences.getString(Constants.turbinezerocontrofluid[7],""));
        map.put("cft_rcppisdischpr",mSharedPreferences.getString(Constants.turbinezerocontrofluid[8],""));
        map.put("cft_dotlevel",mSharedPreferences.getString(Constants.turbinezerocontrofluid[9],""));

        cft_level.setText(map.get("cft_level"));
        cft_pumpis.setText(map.get("cft_pumpis"));
        cft_dischprhp.setText(map.get("cft_dischprhp"));
        cft_dischprlp.setText(map.get("cft_dischprlp"));
        cft_vefis.setText(map.get("cft_vefis"));
        cft_cooleris.setText(map.get("cft_cooleris"));
        cft_tanktemp.setText(map.get("cft_tanktemp"));
        cft_filterisdp.setText(map.get("cft_filterisdp"));
        cft_rcppisdischpr.setText(map.get("cft_rcppisdischpr"));
        cft_dotlevel.setText(map.get("cft_dotlevel"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[0],cft_level.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[1],cft_pumpis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[2],cft_dischprhp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[3],cft_dischprlp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[4],cft_vefis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[5],cft_cooleris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[6],cft_tanktemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[7],cft_filterisdp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[8],cft_rcppisdischpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocontrofluid[9],cft_dotlevel.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
