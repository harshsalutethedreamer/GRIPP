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

import static org.gripp.android.gripp.utils.Constants.electrical_lttrans;

/**
 * Created by harshgupta on 10/06/17.
 */

public class Fragment_electrical_lttransformers extends BaseFragment{

    @BindView(R.id.usta_wtr)
    EditText electrical_lttrans0;

    @BindView(R.id.usta_wty)
    EditText electrical_lttrans1;

    @BindView(R.id.usta_wtb)
    EditText electrical_lttrans2;

    @BindView(R.id.ustb_wtr)
    EditText electrical_lttrans3;

    @BindView(R.id.ustb_wty)
    EditText electrical_lttrans4;

    @BindView(R.id.ustb_wtb)
    EditText electrical_lttrans5;

    @BindView(R.id.ssta_wtr)
    EditText electrical_lttrans6;

    @BindView(R.id.ssta_wty)
    EditText electrical_lttrans7;

    @BindView(R.id.ssta_wtb)
    EditText electrical_lttrans8;

    @BindView(R.id.sstb_wtr)
    EditText electrical_lttrans9;

    @BindView(R.id.sstb_wty)
    EditText electrical_lttrans10;

    @BindView(R.id.sstb_wtb)
    EditText electrical_lttrans11;


    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_lttransformers newInstance(){
        return new Fragment_electrical_lttransformers();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_lttransformers, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        for(int i=0;i<12;i++){
            String aa="electrical_lttrans"+i;
            map.put(aa,mSharedPreferences.getString(electrical_lttrans[i],""));
        }

        electrical_lttrans0.setText(map.get("electrical_lttrans0"));
        electrical_lttrans1.setText(map.get("electrical_lttrans1"));
        electrical_lttrans2.setText(map.get("electrical_lttrans2"));
        electrical_lttrans3.setText(map.get("electrical_lttrans3"));
        electrical_lttrans4.setText(map.get("electrical_lttrans4"));
        electrical_lttrans5.setText(map.get("electrical_lttrans5"));
        electrical_lttrans6.setText(map.get("electrical_lttrans6"));
        electrical_lttrans7.setText(map.get("electrical_lttrans7"));
        electrical_lttrans8.setText(map.get("electrical_lttrans8"));
        electrical_lttrans9.setText(map.get("electrical_lttrans9"));
        electrical_lttrans10.setText(map.get("electrical_lttrans10"));
        electrical_lttrans11.setText(map.get("electrical_lttrans11"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(electrical_lttrans[0],electrical_lttrans0.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[1],electrical_lttrans1.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[2],electrical_lttrans2.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[3],electrical_lttrans3.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[4],electrical_lttrans4.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[5],electrical_lttrans5.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[6],electrical_lttrans6.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[7],electrical_lttrans7.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[8],electrical_lttrans8.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[9],electrical_lttrans9.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[10],electrical_lttrans10.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_lttrans[11],electrical_lttrans11.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
