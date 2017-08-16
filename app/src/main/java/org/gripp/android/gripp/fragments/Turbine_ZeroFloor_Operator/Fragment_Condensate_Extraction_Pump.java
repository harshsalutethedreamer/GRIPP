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

public class Fragment_Condensate_Extraction_Pump extends BaseFragment{

    @BindView(R.id.cep_pis_A)
    EditText cep_pis_A;

    @BindView(R.id.cep_pis_B)
    EditText cep_pis_B;

    @BindView(R.id.cep_pis_C)
    EditText cep_pis_C;

    @BindView(R.id.cep_thbol_A)
    EditText cep_thbol_A;

    @BindView(R.id.cep_thbol_B)
    EditText cep_thbol_B;

    @BindView(R.id.cep_thbol_C)
    EditText cep_thbol_C;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_Condensate_Extraction_Pump newInstance(){
        return new Fragment_Condensate_Extraction_Pump();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_zerometer_operator_cep,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        map.put("cep_pis_A",mSharedPreferences.getString(Constants.turbinezerocep[0],""));
        map.put("cep_pis_B",mSharedPreferences.getString(Constants.turbinezerocep[1],""));
        map.put("cep_pis_C",mSharedPreferences.getString(Constants.turbinezerocep[2],""));
        map.put("cep_thbol_A",mSharedPreferences.getString(Constants.turbinezerocep[3],""));
        map.put("cep_thbol_B",mSharedPreferences.getString(Constants.turbinezerocep[4],""));
        map.put("cep_thbol_C",mSharedPreferences.getString(Constants.turbinezerocep[5],""));


        cep_pis_A.setText(map.get("cep_pis_A"));
        cep_pis_B.setText(map.get("cep_pis_B"));
        cep_pis_C.setText(map.get("cep_pis_C"));
        cep_thbol_A.setText(map.get("cep_thbol_A"));
        cep_thbol_B.setText(map.get("cep_thbol_B"));
        cep_thbol_C.setText(map.get("cep_thbol_C"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbinezerocep[0],cep_pis_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocep[1],cep_pis_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocep[2],cep_pis_C.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocep[3],cep_thbol_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocep[4],cep_thbol_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbinezerocep[5],cep_thbol_C.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
