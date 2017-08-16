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
import org.gripp.android.gripp.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 10/06/17.
 */

public class Fragment_electrical_gtphase extends BaseFragment{

    @BindView(R.id.wti_r)
    EditText electrical_0;

    @BindView(R.id.wti_y)
    EditText electrical_1;

    @BindView(R.id.wti_b)
    EditText electrical_2;

    @BindView(R.id.oti_r)
    EditText electrical_3;

    @BindView(R.id.oti_y)
    EditText electrical_4;

    @BindView(R.id.oti_b)
    EditText electrical_5;

    @BindView(R.id.col_r)
    EditText electrical_6;

    @BindView(R.id.col_y)
    EditText electrical_7;

    @BindView(R.id.col_b)
    EditText electrical_8;

    @BindView(R.id.fps_r)
    EditText electrical_9;

    @BindView(R.id.fps_y)
    EditText electrical_10;

    @BindView(R.id.fps_b)
    EditText electrical_11;

    @BindView(R.id.olia_r)
    EditText electrical_12;

    @BindView(R.id.olia_y)
    EditText electrical_13;

    @BindView(R.id.olia_b)
    EditText electrical_14;

    @BindView(R.id.tp_r)
    EditText electrical_15;

    @BindView(R.id.tp_y)
    EditText electrical_16;

    @BindView(R.id.tp_b)
    EditText electrical_17;

    @BindView(R.id.sgc_r)
    EditText electrical_18;

    @BindView(R.id.sgc_y)
    EditText electrical_19;

    @BindView(R.id.sgc_b)
    EditText electrical_20;

    @BindView(R.id.dvo_r)
    EditText electrical_21;

    @BindView(R.id.dvo_y)
    EditText electrical_22;

    @BindView(R.id.dvo_b)
    EditText electrical_23;

    @BindView(R.id.swp_r)
    EditText electrical_24;

    @BindView(R.id.swp_y)
    EditText electrical_25;

    @BindView(R.id.swp_b)
    EditText electrical_26;

    @BindView(R.id.slp_r)
    EditText electrical_27;

    @BindView(R.id.slp_y)
    EditText electrical_28;

    @BindView(R.id.slp_b)
    EditText electrical_29;


    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_gtphase newInstance(){
        return new Fragment_electrical_gtphase();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_gtphase, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        for(int i=0;i<30;i++){
            String aa="electrical_"+i;
            map.put(aa,mSharedPreferences.getString(Constants.electricalgtphase[i],""));
        }

        electrical_0.setText(map.get("electrical_0"));
        electrical_1.setText(map.get("electrical_1"));
        electrical_2.setText(map.get("electrical_2"));
        electrical_3.setText(map.get("electrical_3"));
        electrical_4.setText(map.get("electrical_4"));
        electrical_5.setText(map.get("electrical_5"));
        electrical_6.setText(map.get("electrical_6"));
        electrical_7.setText(map.get("electrical_7"));
        electrical_8.setText(map.get("electrical_8"));
        electrical_9.setText(map.get("electrical_9"));
        electrical_10.setText(map.get("electrical_10"));
        electrical_11.setText(map.get("electrical_11"));
        electrical_12.setText(map.get("electrical_12"));
        electrical_13.setText(map.get("electrical_13"));
        electrical_14.setText(map.get("electrical_14"));
        electrical_15.setText(map.get("electrical_15"));
        electrical_16.setText(map.get("electrical_16"));
        electrical_17.setText(map.get("electrical_17"));
        electrical_18.setText(map.get("electrical_18"));
        electrical_19.setText(map.get("electrical_19"));
        electrical_20.setText(map.get("electrical_20"));
        electrical_21.setText(map.get("electrical_21"));
        electrical_22.setText(map.get("electrical_22"));
        electrical_23.setText(map.get("electrical_23"));
        electrical_24.setText(map.get("electrical_24"));
        electrical_25.setText(map.get("electrical_25"));
        electrical_26.setText(map.get("electrical_26"));
        electrical_27.setText(map.get("electrical_27"));
        electrical_28.setText(map.get("electrical_28"));
        electrical_29.setText(map.get("electrical_29"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){

        mSharedPreferences.edit().putString(Constants.electricalgtphase[0],electrical_0.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[1],electrical_1.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[2],electrical_2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[3],electrical_3.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[4],electrical_4.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[5],electrical_5.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[6],electrical_6.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[7],electrical_7.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[8],electrical_8.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[9],electrical_9.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[10],electrical_10.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[11],electrical_11.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[12],electrical_12.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[13],electrical_13.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[14],electrical_14.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[15],electrical_15.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[16],electrical_16.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[17],electrical_17.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[18],electrical_18.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[19],electrical_19.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[20],electrical_20.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[21],electrical_21.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[22],electrical_22.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[23],electrical_23.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[24],electrical_24.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[25],electrical_25.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[26],electrical_26.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[27],electrical_27.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[28],electrical_28.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricalgtphase[29],electrical_29.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
