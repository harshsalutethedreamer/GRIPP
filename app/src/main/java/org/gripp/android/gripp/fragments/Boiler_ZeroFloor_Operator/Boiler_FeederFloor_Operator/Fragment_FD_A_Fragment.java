package org.gripp.android.gripp.fragments.Boiler_ZeroFloor_Operator.Boiler_FeederFloor_Operator;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 02/03/17.
 */

public class Fragment_FD_A_Fragment extends BaseFragment {

    @BindView(R.id.fdfan_A_oillevel)
    EditText fdfan_A_oillevel;

    @BindView(R.id.fdfan_A_oiltemp)
    EditText fdfan_A_oiltemp;

    @BindView(R.id.fdfan_A_lopis)
    EditText fdfan_A_lopis;

    @BindView(R.id.fdfan_A_lop_discharge_pressure)
    EditText fdfan_A_lop_discharge_pressure;

    @BindView(R.id.fdfan_A_dp_filter)
    EditText fdfan_A_dp_filter;

    @BindView(R.id.fdfan_A_lo_supply_hdr_pr)
    EditText fdfan_A_lo_supply_hdr_pr;

    @BindView(R.id.fdfan_A_contoilsupplyhdrpr)
            EditText fdfan_A_contoilsupplyhdrpr;

    @BindView(R.id.fdfan_A_cooleris)
            EditText fdfan_A_cooleris;

    @BindView(R.id.fdfan_A_filteris)
            EditText fdfan_A_filteris;

    @BindView(R.id.fdfan_A_oilreturnflow)
            EditText fdfan_A_oilreturnflow;

    @BindView(R.id.fdfan_A_dp_temp_at_clr_inlet)
            EditText fdfan_A_dp_temp_at_clr_inlet;

    @BindView(R.id.fdfan_A_temp_at_clr_outlet)
            EditText fdfan_A_temp_at_clr_outlet;

    @BindView(R.id.fdfan_A_motor_brg_temp_DE)
            EditText fdfan_A_motor_brg_temp_DE;

    @BindView(R.id.fdfan_A_motor_brg_temp_NDE)
            EditText fdfan_A_motor_brg_temp_NDE;

    @BindView(R.id.fdfan_A_fan_brg_temp_DE1)
            EditText fdfan_A_fan_brg_temp_DE1;

    @BindView(R.id.fdfan_A_fan_brg_temp_DE2)
            EditText fdfan_A_fan_brg_temp_DE2;

    @BindView(R.id.fdfan_A_fan_brg_temp_NDE)
            EditText fdfan_A_fan_brg_temp_NDE;

    @BindView(R.id.fdfan_A_blade_pitch)
            EditText fdfan_A_blade_pitch;

    String string_fdfan_A_oillevel,string_fdfan_A_oiltemp,string_fdfan_A_lopis,string_fdfan_A_lop_discharge_pressure;
    String string_fdfan_A_dp_filter,string_fdfan_A_lo_supply_hdr_pr,string_fdfan_A_contoilsupplyhdrpr,string_fdfan_A_cooleris;
    String string_fdfan_A_filteris,string_fdfan_A_oilreturnflow,string_fdfan_A_dp_temp_at_clr_inlet;
    String string_fdfan_A_temp_at_clr_outlet,string_fdfan_A_motor_brg_temp_DE,string_fdfan_A_motor_brg_temp_NDE;
    String string_fdfan_A_fan_brg_temp_DE1,string_fdfan_A_fan_brg_temp_DE2,string_fdfan_A_fan_brg_temp_NDE;
    String string_fdfan_A_blade_pitch;
    Long lastLogin;

        private Unbinder mUnbinder;

    public static Fragment_FD_A_Fragment newInstance(){
        return new Fragment_FD_A_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilerzerometer_fdfana,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_fdfan_A_oillevel=mSharedPreferences.getString(Constants.fdfan_A_oillevel,"");
        string_fdfan_A_oiltemp=mSharedPreferences.getString(Constants.fdfan_A_oiltemp,"");
        string_fdfan_A_lopis=mSharedPreferences.getString(Constants.fdfan_A_lopis,"");
        string_fdfan_A_lop_discharge_pressure=mSharedPreferences.getString(Constants.fdfan_A_lop_discharge_pressure,"");
        string_fdfan_A_dp_filter=mSharedPreferences.getString(Constants.fdfan_A_dp_filter,"");
        string_fdfan_A_lo_supply_hdr_pr=mSharedPreferences.getString(Constants.fdfan_A_lo_supply_hdr_pr,"");
        string_fdfan_A_contoilsupplyhdrpr=mSharedPreferences.getString(Constants.fdfan_A_contoilsupplyhdrpr,"");
        string_fdfan_A_cooleris=mSharedPreferences.getString(Constants.fdfan_A_cooleris,"");
        string_fdfan_A_filteris=mSharedPreferences.getString(Constants.fdfan_A_filteris,"");
        string_fdfan_A_oilreturnflow=mSharedPreferences.getString(Constants.fdfan_A_oilreturnflow,"");
        string_fdfan_A_dp_temp_at_clr_inlet=mSharedPreferences.getString(Constants.fdfan_A_dp_temp_at_clr_inlet,"");
        string_fdfan_A_temp_at_clr_outlet=mSharedPreferences.getString(Constants.fdfan_A_temp_at_clr_outlet,"");
        string_fdfan_A_motor_brg_temp_DE=mSharedPreferences.getString(Constants.fdfan_A_motor_brg_temp_DE,"");
        string_fdfan_A_motor_brg_temp_NDE=mSharedPreferences.getString(Constants.fdfan_A_motor_brg_temp_NDE,"");
        string_fdfan_A_fan_brg_temp_DE1=mSharedPreferences.getString(Constants.fdfan_A_fan_brg_temp_DE1,"");
        string_fdfan_A_fan_brg_temp_DE2=mSharedPreferences.getString(Constants.fdfan_A_fan_brg_temp_DE2,"");
        string_fdfan_A_fan_brg_temp_NDE=mSharedPreferences.getString(Constants.fdfan_A_fan_brg_temp_NDE,"");
        string_fdfan_A_blade_pitch=mSharedPreferences.getString(Constants.fdfan_A_blade_pitch,"");
        lastLogin=mSharedPreferences.getLong(Constants.lastLogin,0);

        fdfan_A_oillevel.setText(string_fdfan_A_oillevel);
        fdfan_A_oiltemp.setText(string_fdfan_A_oiltemp);
        fdfan_A_lopis.setText(string_fdfan_A_lopis);
        fdfan_A_lop_discharge_pressure.setText(string_fdfan_A_lop_discharge_pressure);
        fdfan_A_dp_filter.setText(string_fdfan_A_dp_filter);
        fdfan_A_lo_supply_hdr_pr.setText(string_fdfan_A_lo_supply_hdr_pr);
        fdfan_A_contoilsupplyhdrpr.setText(string_fdfan_A_contoilsupplyhdrpr);
        fdfan_A_cooleris.setText(string_fdfan_A_cooleris);
        fdfan_A_filteris.setText(string_fdfan_A_filteris);
        fdfan_A_oilreturnflow.setText(string_fdfan_A_oilreturnflow);
        fdfan_A_dp_temp_at_clr_inlet.setText(string_fdfan_A_dp_temp_at_clr_inlet);
        fdfan_A_temp_at_clr_outlet.setText(string_fdfan_A_temp_at_clr_outlet);
        fdfan_A_motor_brg_temp_DE.setText(string_fdfan_A_motor_brg_temp_DE);
        fdfan_A_motor_brg_temp_NDE.setText(string_fdfan_A_motor_brg_temp_NDE);
        fdfan_A_fan_brg_temp_DE1.setText(string_fdfan_A_fan_brg_temp_DE1);
        fdfan_A_fan_brg_temp_DE2.setText(string_fdfan_A_fan_brg_temp_DE2);
        fdfan_A_fan_brg_temp_NDE.setText(string_fdfan_A_fan_brg_temp_NDE);
        fdfan_A_blade_pitch.setText(string_fdfan_A_blade_pitch);
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.fdfan_A_oillevel,fdfan_A_oillevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_oiltemp,fdfan_A_oiltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_lopis,fdfan_A_lopis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_lop_discharge_pressure,fdfan_A_lop_discharge_pressure.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_dp_filter,fdfan_A_dp_filter.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_lo_supply_hdr_pr,fdfan_A_lo_supply_hdr_pr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_contoilsupplyhdrpr,fdfan_A_contoilsupplyhdrpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_cooleris,fdfan_A_cooleris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_filteris,fdfan_A_filteris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_oilreturnflow,fdfan_A_oilreturnflow.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_dp_temp_at_clr_inlet,fdfan_A_dp_temp_at_clr_inlet.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_temp_at_clr_outlet,fdfan_A_temp_at_clr_outlet.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_motor_brg_temp_DE,fdfan_A_motor_brg_temp_DE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_motor_brg_temp_NDE,fdfan_A_motor_brg_temp_NDE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_fan_brg_temp_DE1,fdfan_A_fan_brg_temp_DE1.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_fan_brg_temp_DE2,fdfan_A_fan_brg_temp_DE2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_fan_brg_temp_NDE,fdfan_A_fan_brg_temp_NDE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fdfan_A_blade_pitch,fdfan_A_blade_pitch.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
