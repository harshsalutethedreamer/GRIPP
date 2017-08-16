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

public class Fragment_electrical_dgset extends BaseFragment{

    @BindView(R.id.dgset_chrvamain)
    EditText electrical_dgset_0;

    @BindView(R.id.dgset_chrvasb)
    EditText electrical_dgset_1;

    @BindView(R.id.dgset_bcmain)
    EditText electrical_dgset_2;

    @BindView(R.id.dgset_bcsb)
    EditText electrical_dgset_3;

    @BindView(R.id.dgset_csmain)
    EditText electrical_dgset_4;

    @BindView(R.id.dgset_cssb)
    EditText electrical_dgset_5;

    @BindView(R.id.dgset_dtlmain)
    EditText electrical_dgset_6;

    @BindView(R.id.dgset_dtlsb)
    EditText electrical_dgset_7;

    @BindView(R.id.dgset_clmain)
    EditText electrical_dgset_8;

    @BindView(R.id.dgset_clsb)
    EditText electrical_dgset_9;

    @BindView(R.id.dgset_avllmain)
    EditText electrical_dgset_10;

    @BindView(R.id.dgset_avllsb)
    EditText electrical_dgset_11;

    @BindView(R.id.dgset_avrdcmain)
    EditText electrical_dgset_12;

    @BindView(R.id.dgset_avrdcsb)
    EditText electrical_dgset_13;

    @BindView(R.id.dgset_ctmain)
    EditText electrical_dgset_14;

    @BindView(R.id.dgset_ctsb)
    EditText electrical_dgset_15;

    @BindView(R.id.dgset_opmain)
    EditText electrical_dgset_16;

    @BindView(R.id.dgset_opsb)
    EditText electrical_dgset_17;

    @BindView(R.id.dgset_otcmain)
    EditText electrical_dgset_18;

    @BindView(R.id.dgset_otcsb)
    EditText electrical_dgset_19;

    @BindView(R.id.dgset_esmain)
    EditText electrical_dgset_20;

    @BindView(R.id.dgset_essb)
    EditText electrical_dgset_21;

    @BindView(R.id.dgset_gdcmain)
    EditText electrical_dgset_22;

    @BindView(R.id.dgset_gdcsb)
    EditText electrical_dgset_23;

    @BindView(R.id.dgset_tcmain)
    EditText electrical_dgset_24;

    @BindView(R.id.dgset_tcsb)
    EditText electrical_dgset_25;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_dgset newInstance(){
        return new Fragment_electrical_dgset();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_dgset, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        for(int i=0;i<26;i++){
            String aa="electrical_dgset"+i;
            map.put(aa,mSharedPreferences.getString(Constants.electricaldgset[i],""));
        }

        electrical_dgset_0.setText(map.get("electrical_dgset0"));
        electrical_dgset_1.setText(map.get("electrical_dgset1"));
        electrical_dgset_2.setText(map.get("electrical_dgset2"));
        electrical_dgset_3.setText(map.get("electrical_dgset3"));
        electrical_dgset_4.setText(map.get("electrical_dgset4"));
        electrical_dgset_5.setText(map.get("electrical_dgset5"));
        electrical_dgset_6.setText(map.get("electrical_dgset6"));
        electrical_dgset_7.setText(map.get("electrical_dgset7"));
        electrical_dgset_8.setText(map.get("electrical_dgset8"));
        electrical_dgset_9.setText(map.get("electrical_dgset9"));
        electrical_dgset_10.setText(map.get("electrical_dgset10"));
        electrical_dgset_11.setText(map.get("electrical_dgset11"));
        electrical_dgset_12.setText(map.get("electrical_dgset12"));
        electrical_dgset_13.setText(map.get("electrical_dgset13"));
        electrical_dgset_14.setText(map.get("electrical_dgset14"));
        electrical_dgset_15.setText(map.get("electrical_dgset15"));
        electrical_dgset_16.setText(map.get("electrical_dgset16"));
        electrical_dgset_17.setText(map.get("electrical_dgset17"));
        electrical_dgset_18.setText(map.get("electrical_dgset18"));
        electrical_dgset_19.setText(map.get("electrical_dgset19"));
        electrical_dgset_20.setText(map.get("electrical_dgset20"));
        electrical_dgset_21.setText(map.get("electrical_dgset21"));
        electrical_dgset_22.setText(map.get("electrical_dgset22"));
        electrical_dgset_23.setText(map.get("electrical_dgset23"));
        electrical_dgset_24.setText(map.get("electrical_dgset24"));
        electrical_dgset_25.setText(map.get("electrical_dgset25"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.electricaldgset[0],electrical_dgset_0.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[1],electrical_dgset_1.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[2],electrical_dgset_2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[3],electrical_dgset_3.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[4],electrical_dgset_4.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[5],electrical_dgset_5.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[6],electrical_dgset_6.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[7],electrical_dgset_7.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[8],electrical_dgset_8.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[9],electrical_dgset_9.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[10],electrical_dgset_10.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[11],electrical_dgset_11.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[12],electrical_dgset_12.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[13],electrical_dgset_13.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[14],electrical_dgset_14.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[15],electrical_dgset_15.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[16],electrical_dgset_16.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[17],electrical_dgset_17.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[18],electrical_dgset_18.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[19],electrical_dgset_19.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[20],electrical_dgset_20.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[21],electrical_dgset_21.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[22],electrical_dgset_22.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[23],electrical_dgset_23.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[24],electrical_dgset_24.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaldgset[25],electrical_dgset_25.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
