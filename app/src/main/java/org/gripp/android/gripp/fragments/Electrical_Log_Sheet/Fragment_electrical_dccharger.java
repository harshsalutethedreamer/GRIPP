package org.gripp.android.gripp.fragments.Electrical_Log_Sheet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.gripp.android.gripp.R;
import org.gripp.android.gripp.R2;
import org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static org.gripp.android.gripp.utils.Constants.electrical_dccharger;

/**
 * Created by harshgupta on 10/06/17.
 */

public class Fragment_electrical_dccharger extends BaseFragment{

    @BindView(R.id.lts_ch1_acvolt)
    EditText electrical_dccharger0;

    @BindView(R.id.lts_ch1_dcvolt)
    EditText electrical_dccharger1;

    @BindView(R.id.lts_ch1_dc)
    EditText electrical_dccharger2;

    @BindView(R.id.lts_ch2_acvolt)
    EditText electrical_dccharger3;

    @BindView(R.id.lts_ch2_dcvolt)
    EditText electrical_dccharger4;

    @BindView(R.id.lts_ch2_dc)
    EditText electrical_dccharger5;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_dccharger newInstance(){
        return new Fragment_electrical_dccharger();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_dccharger, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        for(int i=0;i<6;i++){
            String aa="electrical_dccharger"+i;
            map.put(aa,mSharedPreferences.getString(electrical_dccharger[i],""));
        }

        electrical_dccharger0.setText(map.get("electrical_dccharger0"));
        electrical_dccharger1.setText(map.get("electrical_dccharger1"));
        electrical_dccharger2.setText(map.get("electrical_dccharger2"));
        electrical_dccharger3.setText(map.get("electrical_dccharger3"));
        electrical_dccharger4.setText(map.get("electrical_dccharger4"));
        electrical_dccharger5.setText(map.get("electrical_dccharger5"));

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(electrical_dccharger[0],electrical_dccharger0.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dccharger[1],electrical_dccharger1.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dccharger[2],electrical_dccharger2.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dccharger[3],electrical_dccharger3.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dccharger[4],electrical_dccharger4.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dccharger[5],electrical_dccharger5.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
