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

import static org.gripp.android.gripp.utils.Constants.electrical_ltswgr;

/**
 * Created by harshgupta on 10/06/17.
 */

public class Fragment_electrical_ltswgr extends BaseFragment{

    @BindView(R.id.lts_ussa_volt)
    EditText electrical_ltswgr0;

    @BindView(R.id.lts_ussa_current)
    EditText electrical_ltswgr1;

    @BindView(R.id.lts_ussa_bcstatus)
    EditText electrical_ltswgr2;

    @BindView(R.id.lts_ussb_volt)
    EditText electrical_ltswgr3;

    @BindView(R.id.lts_ussb_current)
    EditText electrical_ltswgr4;

    @BindView(R.id.lts_ussb_bcstatus)
    EditText electrical_ltswgr5;

    @BindView(R.id.lts_sssa_volt)
    EditText electrical_ltswgr6;

    @BindView(R.id.lts_sssa_current)
    EditText electrical_ltswgr7;

    @BindView(R.id.lts_sssa_bcstatus)
    EditText electrical_ltswgr8;

    @BindView(R.id.lts_sssb_volt)
    EditText electrical_ltswgr9;

    @BindView(R.id.lts_sssb_current)
    EditText electrical_ltswgr10;

    @BindView(R.id.lts_sssb_bcstatus)
    EditText electrical_ltswgr11;

    @BindView(R.id.lts_sacdba_volt)
    EditText electrical_ltswgr12;

    @BindView(R.id.lts_sacdba_current)
    EditText electrical_ltswgr13;

    @BindView(R.id.lts_sacdba_bcstatus)
    EditText electrical_ltswgr14;

    @BindView(R.id.lts_sacdbb_volt)
    EditText electrical_ltswgr15;

    @BindView(R.id.lts_sacdbb_current)
    EditText electrical_ltswgr16;

    @BindView(R.id.lts_sacdbb_bcstatus)
    EditText electrical_ltswgr17;

    @BindView(R.id.lts_tmcca_volt)
    EditText electrical_ltswgr18;

    @BindView(R.id.lts_tmcca_current)
    EditText electrical_ltswgr19;

    @BindView(R.id.lts_tmcca_bcstatus)
    EditText electrical_ltswgr20;

    @BindView(R.id.lts_tmccb_volt)
    EditText electrical_ltswgr21;

    @BindView(R.id.lts_tmccb_current)
    EditText electrical_ltswgr22;

    @BindView(R.id.lts_tmccb_bcstatus)
    EditText electrical_ltswgr23;

    @BindView(R.id.lts_bmcca_volt)
    EditText electrical_ltswgr24;

    @BindView(R.id.lts_bmcca_current)
    EditText electrical_ltswgr25;

    @BindView(R.id.lts_bmcca_bcstatus)
    EditText electrical_ltswgr26;

    @BindView(R.id.lts_bmccb_volt)
    EditText electrical_ltswgr27;

    @BindView(R.id.lts_bmccb_current)
    EditText electrical_ltswgr28;

    @BindView(R.id.lts_bmccb_bcstatus)
    EditText electrical_ltswgr29;

    @BindView(R.id.lts_tvacdb_volt)
    EditText electrical_ltswgr30;

    @BindView(R.id.lts_tvacdb_current)
    EditText electrical_ltswgr31;

    @BindView(R.id.lts_tvacdb_bcstatus)
    EditText electrical_ltswgr32;

    @BindView(R.id.lts_bacdba_volt)
    EditText electrical_ltswgr33;

    @BindView(R.id.lts_bacdba_current)
    EditText electrical_ltswgr34;

    @BindView(R.id.lts_bacdba_bcstatus)
    EditText electrical_ltswgr35;

    @BindView(R.id.lts_bacdbb_volt)
    EditText electrical_ltswgr36;

    @BindView(R.id.lts_bacdbb_current)
    EditText electrical_ltswgr37;

    @BindView(R.id.lts_bacdbb_bcstatus)
    EditText electrical_ltswgr38;

    @BindView(R.id.lts_aamcca_volt)
    EditText electrical_ltswgr39;

    @BindView(R.id.lts_aamcca_current)
    EditText electrical_ltswgr40;

    @BindView(R.id.lts_aamcca_bcstatus)
    EditText electrical_ltswgr41;

    @BindView(R.id.lts_aamccb_volt)
    EditText electrical_ltswgr42;

    @BindView(R.id.lts_aamccb_current)
    EditText electrical_ltswgr43;

    @BindView(R.id.lts_aamccb_bcstatus)
    EditText electrical_ltswgr44;

    @BindView(R.id.lts_bvdacdb_volt)
    EditText electrical_ltswgr45;

    @BindView(R.id.lts_bvdacdb_current)
    EditText electrical_ltswgr46;

    @BindView(R.id.lts_bvdacdb_bcstatus)
    EditText electrical_ltswgr47;

    @BindView(R.id.lts_botmcca_volt)
    EditText electrical_ltswgr48;

    @BindView(R.id.lts_botmcca_current)
    EditText electrical_ltswgr49;

    @BindView(R.id.lts_botmcca_bcstatus)
    EditText electrical_ltswgr50;

    @BindView(R.id.lts_botmccb_volt)
    EditText electrical_ltswgr51;

    @BindView(R.id.lts_botmccb_current)
    EditText electrical_ltswgr52;

    @BindView(R.id.lts_botmccb_bcstatus)
    EditText electrical_ltswgr53;

    @BindView(R.id.lts_sbmcc_volt)
    EditText electrical_ltswgr54;

    @BindView(R.id.lts_sbmcc_current)
    EditText electrical_ltswgr55;

    @BindView(R.id.lts_sbmcc_bcstatus)
    EditText electrical_ltswgr56;



    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_ltswgr newInstance(){
        return new Fragment_electrical_ltswgr();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_ltswgr, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        for(int i=0;i<57;i++){
            String aa="electrical_ltswgr"+i;
            map.put(aa,mSharedPreferences.getString(electrical_ltswgr[i],""));
        }

        electrical_ltswgr0.setText(map.get("electrical_ltswgr0"));
        electrical_ltswgr1.setText(map.get("electrical_ltswgr1"));
        electrical_ltswgr2.setText(map.get("electrical_ltswgr2"));
        electrical_ltswgr3.setText(map.get("electrical_ltswgr3"));
        electrical_ltswgr4.setText(map.get("electrical_ltswgr4"));
        electrical_ltswgr5.setText(map.get("electrical_ltswgr5"));
        electrical_ltswgr6.setText(map.get("electrical_ltswgr6"));
        electrical_ltswgr7.setText(map.get("electrical_ltswgr7"));
        electrical_ltswgr8.setText(map.get("electrical_ltswgr8"));
        electrical_ltswgr9.setText(map.get("electrical_ltswgr9"));
        electrical_ltswgr10.setText(map.get("electrical_ltswgr10"));
        electrical_ltswgr11.setText(map.get("electrical_ltswgr11"));
        electrical_ltswgr12.setText(map.get("electrical_ltswgr12"));
        electrical_ltswgr13.setText(map.get("electrical_ltswgr13"));
        electrical_ltswgr14.setText(map.get("electrical_ltswgr14"));
        electrical_ltswgr15.setText(map.get("electrical_ltswgr15"));
        electrical_ltswgr16.setText(map.get("electrical_ltswgr16"));
        electrical_ltswgr17.setText(map.get("electrical_ltswgr17"));
        electrical_ltswgr18.setText(map.get("electrical_ltswgr18"));
        electrical_ltswgr19.setText(map.get("electrical_ltswgr19"));
        electrical_ltswgr20.setText(map.get("electrical_ltswgr20"));
        electrical_ltswgr21.setText(map.get("electrical_ltswgr21"));
        electrical_ltswgr22.setText(map.get("electrical_ltswgr22"));
        electrical_ltswgr23.setText(map.get("electrical_ltswgr23"));
        electrical_ltswgr24.setText(map.get("electrical_ltswgr24"));
        electrical_ltswgr25.setText(map.get("electrical_ltswgr25"));
        electrical_ltswgr26.setText(map.get("electrical_ltswgr26"));
        electrical_ltswgr27.setText(map.get("electrical_ltswgr27"));
        electrical_ltswgr28.setText(map.get("electrical_ltswgr28"));
        electrical_ltswgr29.setText(map.get("electrical_ltswgr29"));
        electrical_ltswgr30.setText(map.get("electrical_ltswgr30"));
        electrical_ltswgr31.setText(map.get("electrical_ltswgr31"));
        electrical_ltswgr32.setText(map.get("electrical_ltswgr32"));
        electrical_ltswgr33.setText(map.get("electrical_ltswgr33"));
        electrical_ltswgr34.setText(map.get("electrical_ltswgr34"));
        electrical_ltswgr35.setText(map.get("electrical_ltswgr35"));
        electrical_ltswgr36.setText(map.get("electrical_ltswgr36"));
        electrical_ltswgr37.setText(map.get("electrical_ltswgr37"));
        electrical_ltswgr38.setText(map.get("electrical_ltswgr38"));
        electrical_ltswgr39.setText(map.get("electrical_ltswgr39"));
        electrical_ltswgr40.setText(map.get("electrical_ltswgr40"));
        electrical_ltswgr41.setText(map.get("electrical_ltswgr41"));
        electrical_ltswgr42.setText(map.get("electrical_ltswgr42"));
        electrical_ltswgr43.setText(map.get("electrical_ltswgr43"));
        electrical_ltswgr44.setText(map.get("electrical_ltswgr44"));
        electrical_ltswgr45.setText(map.get("electrical_ltswgr45"));
        electrical_ltswgr46.setText(map.get("electrical_ltswgr46"));
        electrical_ltswgr47.setText(map.get("electrical_ltswgr47"));
        electrical_ltswgr48.setText(map.get("electrical_ltswgr48"));
        electrical_ltswgr49.setText(map.get("electrical_ltswgr49"));
        electrical_ltswgr50.setText(map.get("electrical_ltswgr50"));
        electrical_ltswgr51.setText(map.get("electrical_ltswgr51"));
        electrical_ltswgr52.setText(map.get("electrical_ltswgr52"));
        electrical_ltswgr53.setText(map.get("electrical_ltswgr53"));
        electrical_ltswgr54.setText(map.get("electrical_ltswgr54"));
        electrical_ltswgr55.setText(map.get("electrical_ltswgr55"));
        electrical_ltswgr56.setText(map.get("electrical_ltswgr56"));

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(electrical_ltswgr[0],electrical_ltswgr0.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[1],electrical_ltswgr1.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[2],electrical_ltswgr2.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[3],electrical_ltswgr3.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[4],electrical_ltswgr4.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[5],electrical_ltswgr5.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[6],electrical_ltswgr6.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[7],electrical_ltswgr7.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[8],electrical_ltswgr8.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[9],electrical_ltswgr9.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[10],electrical_ltswgr10.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[11],electrical_ltswgr11.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[12],electrical_ltswgr12.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[13],electrical_ltswgr13.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[14],electrical_ltswgr14.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[15],electrical_ltswgr15.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[16],electrical_ltswgr16.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[17],electrical_ltswgr17.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[18],electrical_ltswgr18.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[19],electrical_ltswgr19.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[20],electrical_ltswgr20.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[21],electrical_ltswgr21.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[22],electrical_ltswgr22.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[23],electrical_ltswgr23.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[24],electrical_ltswgr24.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[25],electrical_ltswgr25.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[26],electrical_ltswgr26.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[27],electrical_ltswgr27.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[28],electrical_ltswgr28.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[29],electrical_ltswgr29.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[30],electrical_ltswgr30.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[31],electrical_ltswgr31.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[32],electrical_ltswgr32.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[33],electrical_ltswgr33.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[34],electrical_ltswgr34.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[35],electrical_ltswgr35.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[36],electrical_ltswgr36.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[37],electrical_ltswgr37.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[38],electrical_ltswgr38.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[39],electrical_ltswgr39.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[40],electrical_ltswgr40.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[41],electrical_ltswgr41.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[42],electrical_ltswgr42.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[43],electrical_ltswgr43.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[44],electrical_ltswgr44.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[45],electrical_ltswgr45.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[46],electrical_ltswgr46.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[47],electrical_ltswgr47.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[48],electrical_ltswgr48.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[49],electrical_ltswgr49.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[50],electrical_ltswgr50.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[51],electrical_ltswgr51.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[52],electrical_ltswgr52.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[53],electrical_ltswgr53.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[54],electrical_ltswgr54.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[55],electrical_ltswgr55.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ltswgr[56],electrical_ltswgr56.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
