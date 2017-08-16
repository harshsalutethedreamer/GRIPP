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

public class Fragment_electrical_uttransformer extends BaseFragment{

    @BindView(R.id.wti_ut)
    EditText electrical_ut0;

    @BindView(R.id.wti_uata)
    EditText electrical_ut1;

    @BindView(R.id.wti_uatb)
    EditText electrical_ut2;

    @BindView(R.id.wti_st)
    EditText electrical_ut3;

    @BindView(R.id.oti_ut)
    EditText electrical_ut4;

    @BindView(R.id.oti_uata)
    EditText electrical_ut5;

    @BindView(R.id.oti_uatb)
    EditText electrical_ut6;

    @BindView(R.id.oti_st)
    EditText electrical_ut7;

    @BindView(R.id.col_ut)
    EditText electrical_ut8;

    @BindView(R.id.col_uata)
    EditText electrical_ut9;

    @BindView(R.id.col_uatb)
    EditText electrical_ut10;

    @BindView(R.id.col_st)
    EditText electrical_ut11;

    @BindView(R.id.fps_ut)
    EditText electrical_ut12;

    @BindView(R.id.fps_uata)
    EditText electrical_ut13;

    @BindView(R.id.fps_uatb)
    EditText electrical_ut14;

    @BindView(R.id.fps_st)
    EditText electrical_ut15;

    @BindView(R.id.olia_ut)
    EditText electrical_ut16;

    @BindView(R.id.olia_uata)
    EditText electrical_ut17;

    @BindView(R.id.olia_uatb)
    EditText electrical_ut18;

    @BindView(R.id.olia_st)
    EditText electrical_ut19;

    @BindView(R.id.tp_ut)
    EditText electrical_ut20;

    @BindView(R.id.tp_uata)
    EditText electrical_ut21;

    @BindView(R.id.tp_uatb)
    EditText electrical_ut22;

    @BindView(R.id.tp_st)
    EditText electrical_ut23;

    @BindView(R.id.sgc_ut)
    EditText electrical_ut24;

    @BindView(R.id.sgc_uata)
    EditText electrical_ut25;

    @BindView(R.id.sgc_uatb)
    EditText electrical_ut26;

    @BindView(R.id.sgc_st)
    EditText electrical_ut27;

    @BindView(R.id.dvo_ut)
    EditText electrical_ut28;

    @BindView(R.id.dvo_uata)
    EditText electrical_ut29;

    @BindView(R.id.dvo_uatb)
    EditText electrical_ut30;

    @BindView(R.id.dvo_st)
    EditText electrical_ut31;

    @BindView(R.id.swp_ut)
    EditText electrical_ut32;

    @BindView(R.id.swp_uata)
    EditText electrical_ut33;

    @BindView(R.id.swp_uatb)
    EditText electrical_ut34;

    @BindView(R.id.swp_st)
    EditText electrical_ut35;

    @BindView(R.id.slp_ut)
    EditText electrical_ut36;

    @BindView(R.id.slp_uata)
    EditText electrical_ut37;

    @BindView(R.id.slp_uatb)
    EditText electrical_ut38;

    @BindView(R.id.slp_st)
    EditText electrical_ut39;


    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_uttransformer newInstance(){
        return new Fragment_electrical_uttransformer();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_utphase, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        for(int i=0;i<40;i++){
            String aa="electrical_ut"+i;
            map.put(aa,mSharedPreferences.getString(Constants.electricaluttransformer[i],""));
        }

        electrical_ut0.setText(map.get("electrical_ut0"));
        electrical_ut1.setText(map.get("electrical_ut1"));
        electrical_ut2.setText(map.get("electrical_ut2"));
        electrical_ut3.setText(map.get("electrical_ut3"));
        electrical_ut4.setText(map.get("electrical_ut4"));
        electrical_ut5.setText(map.get("electrical_ut5"));
        electrical_ut6.setText(map.get("electrical_ut6"));
        electrical_ut7.setText(map.get("electrical_ut7"));
        electrical_ut8.setText(map.get("electrical_ut8"));
        electrical_ut9.setText(map.get("electrical_ut9"));
        electrical_ut10.setText(map.get("electrical_ut10"));
        electrical_ut11.setText(map.get("electrical_ut11"));
        electrical_ut12.setText(map.get("electrical_ut12"));
        electrical_ut13.setText(map.get("electrical_ut13"));
        electrical_ut14.setText(map.get("electrical_ut14"));
        electrical_ut15.setText(map.get("electrical_ut15"));
        electrical_ut16.setText(map.get("electrical_ut16"));
        electrical_ut17.setText(map.get("electrical_ut17"));
        electrical_ut18.setText(map.get("electrical_ut18"));
        electrical_ut19.setText(map.get("electrical_ut19"));
        electrical_ut20.setText(map.get("electrical_ut20"));
        electrical_ut21.setText(map.get("electrical_ut21"));
        electrical_ut22.setText(map.get("electrical_ut22"));
        electrical_ut23.setText(map.get("electrical_ut23"));
        electrical_ut24.setText(map.get("electrical_ut24"));
        electrical_ut25.setText(map.get("electrical_ut25"));
        electrical_ut26.setText(map.get("electrical_ut26"));
        electrical_ut27.setText(map.get("electrical_ut27"));
        electrical_ut28.setText(map.get("electrical_ut28"));
        electrical_ut29.setText(map.get("electrical_ut29"));
        electrical_ut30.setText(map.get("electrical_ut30"));
        electrical_ut31.setText(map.get("electrical_ut31"));
        electrical_ut32.setText(map.get("electrical_ut32"));
        electrical_ut33.setText(map.get("electrical_ut33"));
        electrical_ut34.setText(map.get("electrical_ut34"));
        electrical_ut35.setText(map.get("electrical_ut35"));
        electrical_ut36.setText(map.get("electrical_ut36"));
        electrical_ut37.setText(map.get("electrical_ut37"));
        electrical_ut38.setText(map.get("electrical_ut38"));
        electrical_ut39.setText(map.get("electrical_ut39"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){

        mSharedPreferences.edit().putString(Constants.electricaluttransformer[0],electrical_ut0.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[1],electrical_ut1.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[2],electrical_ut2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[3],electrical_ut3.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[4],electrical_ut4.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[5],electrical_ut5.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[6],electrical_ut6.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[7],electrical_ut7.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[8],electrical_ut8.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[9],electrical_ut9.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[10],electrical_ut10.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[11],electrical_ut11.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[12],electrical_ut12.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[13],electrical_ut13.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[14],electrical_ut14.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[15],electrical_ut15.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[16],electrical_ut16.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[17],electrical_ut17.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[18],electrical_ut18.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[19],electrical_ut19.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[20],electrical_ut20.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[21],electrical_ut21.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[22],electrical_ut22.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[23],electrical_ut23.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[24],electrical_ut24.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[25],electrical_ut25.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[26],electrical_ut26.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[27],electrical_ut27.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[28],electrical_ut28.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[29],electrical_ut29.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[30],electrical_ut30.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[31],electrical_ut31.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[32],electrical_ut32.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[33],electrical_ut33.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[34],electrical_ut34.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[35],electrical_ut35.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[36],electrical_ut36.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[37],electrical_ut37.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[38],electrical_ut38.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.electricaluttransformer[39],electrical_ut39.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
