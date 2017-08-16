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

import static org.gripp.android.gripp.utils.Constants.electrical_htswgr;

/**
 * Created by harshgupta on 10/06/17.
 */

public class Fragment_electrical_htswgr extends BaseFragment{

    @BindView(R.id.ua_volt)
    EditText electrical_htswgr0;

    @BindView(R.id.ua_current)
    EditText electrical_htswgr1;

    @BindView(R.id.ua_bcstatus)
    EditText electrical_htswgr2;

    @BindView(R.id.ub_volt)
    EditText electrical_htswgr3;

    @BindView(R.id.ub_current)
    EditText electrical_htswgr4;

    @BindView(R.id.ub_bcstatus)
    EditText electrical_htswgr5;

    @BindView(R.id.sa_volt)
    EditText electrical_htswgr6;

    @BindView(R.id.sa_current)
    EditText electrical_htswgr7;

    @BindView(R.id.sa_bcstatus)
    EditText electrical_htswgr8;

    @BindView(R.id.sb_volt)
    EditText electrical_htswgr9;

    @BindView(R.id.sb_current)
    EditText electrical_htswgr10;

    @BindView(R.id.sb_bcstatus)
    EditText electrical_htswgr11;

    @BindView(R.id.uaaa_volt)
    EditText electrical_htswgr12;

    @BindView(R.id.uaaa_current)
    EditText electrical_htswgr13;

    @BindView(R.id.uaaa_bcstatus)
    EditText electrical_htswgr14;

    @BindView(R.id.uaab_volt)
    EditText electrical_htswgr15;

    @BindView(R.id.uaab_current)
    EditText electrical_htswgr16;

    @BindView(R.id.uaab_bcstatus)
    EditText electrical_htswgr17;


    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_htswgr newInstance(){
        return new Fragment_electrical_htswgr();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_htswgr, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        for(int i=0;i<18;i++){
            String aa="electrical_htswgr"+i;
            map.put(aa,mSharedPreferences.getString(electrical_htswgr[i],""));
        }

        electrical_htswgr0.setText(map.get("electrical_htswgr0"));
        electrical_htswgr1.setText(map.get("electrical_htswgr1"));
        electrical_htswgr2.setText(map.get("electrical_htswgr2"));
        electrical_htswgr3.setText(map.get("electrical_htswgr3"));
        electrical_htswgr4.setText(map.get("electrical_htswgr4"));
        electrical_htswgr5.setText(map.get("electrical_htswgr5"));
        electrical_htswgr6.setText(map.get("electrical_htswgr6"));
        electrical_htswgr7.setText(map.get("electrical_htswgr7"));
        electrical_htswgr8.setText(map.get("electrical_htswgr8"));
        electrical_htswgr9.setText(map.get("electrical_htswgr9"));
        electrical_htswgr10.setText(map.get("electrical_htswgr10"));
        electrical_htswgr11.setText(map.get("electrical_htswgr11"));
        electrical_htswgr12.setText(map.get("electrical_htswgr12"));
        electrical_htswgr13.setText(map.get("electrical_htswgr13"));
        electrical_htswgr14.setText(map.get("electrical_htswgr14"));
        electrical_htswgr15.setText(map.get("electrical_htswgr15"));
        electrical_htswgr16.setText(map.get("electrical_htswgr16"));
        electrical_htswgr17.setText(map.get("electrical_htswgr17"));

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(electrical_htswgr[0],electrical_htswgr0.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[1],electrical_htswgr1.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[2],electrical_htswgr2.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[3],electrical_htswgr3.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[4],electrical_htswgr4.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[5],electrical_htswgr5.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[6],electrical_htswgr6.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[7],electrical_htswgr7.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[8],electrical_htswgr8.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[9],electrical_htswgr9.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[10],electrical_htswgr10.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[11],electrical_htswgr11.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[12],electrical_htswgr12.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[13],electrical_htswgr13.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[14],electrical_htswgr14.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[15],electrical_htswgr15.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[16],electrical_htswgr16.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_htswgr[17],electrical_htswgr17.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
