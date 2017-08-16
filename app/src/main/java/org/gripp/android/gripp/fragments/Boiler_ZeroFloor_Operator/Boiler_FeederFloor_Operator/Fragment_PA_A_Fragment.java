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

public class Fragment_PA_A_Fragment extends BaseFragment {

    @BindView(R.id.pafan_A_oillevel)
    EditText pafan_A_oillevel;

    @BindView(R.id.pafan_A_oiltemp)
    EditText pafan_A_oiltemp;

    @BindView(R.id.pafan_A_lopis)
    EditText pafan_A_lopis;

    @BindView(R.id.pafan_A_lop_discharge_pressure)
    EditText pafan_A_lop_discharge_pressure;

    @BindView(R.id.pafan_A_dp_filter)
    EditText pafan_A_dp_filter;

    @BindView(R.id.pafan_A_lo_supply_hdr_pr)
    EditText pafan_A_lo_supply_hdr_pr;

    @BindView(R.id.pafan_A_contoilsupplyhdrpr)
            EditText pafan_A_contoilsupplyhdrpr;

    @BindView(R.id.pafan_A_cooleris)
            EditText pafan_A_cooleris;

    @BindView(R.id.pafan_A_filteris)
            EditText pafan_A_filteris;

    @BindView(R.id.pafan_A_oilreturnflow)
            EditText pafan_A_oilreturnflow;

    @BindView(R.id.pafan_A_dp_temp_at_clr_inlet)
            EditText pafan_A_dp_temp_at_clr_inlet;

    @BindView(R.id.pafan_A_temp_at_clr_outlet)
            EditText pafan_A_temp_at_clr_outlet;

    @BindView(R.id.pafan_A_motor_brg_temp_DE)
            EditText pafan_A_motor_brg_temp_DE;

    @BindView(R.id.pafan_A_motor_brg_temp_NDE)
            EditText pafan_A_motor_brg_temp_NDE;

    @BindView(R.id.pafan_A_fan_brg_temp_DE)
            EditText pafan_A_fan_brg_temp_DE;

    @BindView(R.id.pafan_A_fan_brg_temp_NDE)
            EditText pafan_A_fan_brg_temp_NDE;

    @BindView(R.id.pafan_A_fan_thrust_brg_1)
            EditText pafan_A_fan_thrust_brg_1;

    @BindView(R.id.pafan_A_fan_thrust_brg_2)
    EditText pafan_A_fan_thrust_brg_2;

    @BindView(R.id.pafan_A_blade_pitch)
            EditText pafan_A_blade_pitch;

    String string_pafan_A_oillevel,string_pafan_A_oiltemp,string_pafan_A_lopis,string_pafan_A_lop_discharge_pressure;
    String string_pafan_A_dp_filter,string_pafan_A_lo_supply_hdr_pr,string_pafan_A_contoilsupplyhdrpr,string_pafan_A_cooleris;
    String string_pafan_A_filteris,string_pafan_A_oilreturnflow,string_pafan_A_dp_temp_at_clr_inlet;
    String string_pafan_A_temp_at_clr_outlet,string_pafan_A_motor_brg_temp_DE,string_pafan_A_motor_brg_temp_NDE;
    String string_pafan_A_fan_brg_temp_DE,string_pafan_A_fan_brg_temp_NDE,string_pafan_A_fan_thrust_brg_1;
    String string_pafan_A_fan_thrust_brg_2,string_pafan_A_blade_pitch;
    Long lastLogin;

    private Unbinder mUnbinder;

    public static Fragment_PA_A_Fragment newInstance(){
        return new Fragment_PA_A_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilerzerometer_pafana,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_pafan_A_oillevel=mSharedPreferences.getString(Constants.pafan_A_oillevel,"");
        string_pafan_A_oiltemp=mSharedPreferences.getString(Constants.pafan_A_oiltemp,"");
        string_pafan_A_lopis=mSharedPreferences.getString(Constants.pafan_A_lopis,"");
        string_pafan_A_lop_discharge_pressure=mSharedPreferences.getString(Constants.pafan_A_lop_discharge_pressure,"");
        string_pafan_A_dp_filter=mSharedPreferences.getString(Constants.pafan_A_dp_filter,"");
        string_pafan_A_lo_supply_hdr_pr=mSharedPreferences.getString(Constants.pafan_A_lo_supply_hdr_pr,"");
        string_pafan_A_contoilsupplyhdrpr=mSharedPreferences.getString(Constants.pafan_A_contoilsupplyhdrpr,"");
        string_pafan_A_cooleris=mSharedPreferences.getString(Constants.pafan_A_cooleris,"");
        string_pafan_A_filteris=mSharedPreferences.getString(Constants.pafan_A_filteris,"");
        string_pafan_A_oilreturnflow=mSharedPreferences.getString(Constants.pafan_A_oilreturnflow,"");
        string_pafan_A_dp_temp_at_clr_inlet=mSharedPreferences.getString(Constants.pafan_A_dp_temp_at_clr_inlet,"");
        string_pafan_A_temp_at_clr_outlet=mSharedPreferences.getString(Constants.pafan_A_temp_at_clr_outlet,"");
        string_pafan_A_motor_brg_temp_DE=mSharedPreferences.getString(Constants.pafan_A_motor_brg_temp_DE,"");
        string_pafan_A_motor_brg_temp_NDE=mSharedPreferences.getString(Constants.pafan_A_motor_brg_temp_NDE,"");
        string_pafan_A_fan_brg_temp_DE=mSharedPreferences.getString(Constants.pafan_A_fan_brg_temp_DE,"");
        string_pafan_A_fan_thrust_brg_1=mSharedPreferences.getString(Constants.pafan_A_fan_thrust_brg_1,"");
        string_pafan_A_fan_thrust_brg_2=mSharedPreferences.getString(Constants.pafan_A_fan_thrust_brg_2,"");
        string_pafan_A_fan_brg_temp_NDE=mSharedPreferences.getString(Constants.pafan_A_fan_brg_temp_NDE,"");
        string_pafan_A_blade_pitch=mSharedPreferences.getString(Constants.pafan_A_blade_pitch,"");
        lastLogin=mSharedPreferences.getLong(Constants.lastLogin,0);

        pafan_A_oillevel.setText(string_pafan_A_oillevel);
        pafan_A_oiltemp.setText(string_pafan_A_oiltemp);
        pafan_A_lopis.setText(string_pafan_A_lopis);
        pafan_A_lop_discharge_pressure.setText(string_pafan_A_lop_discharge_pressure);
        pafan_A_dp_filter.setText(string_pafan_A_dp_filter);
        pafan_A_lo_supply_hdr_pr.setText(string_pafan_A_lo_supply_hdr_pr);
        pafan_A_contoilsupplyhdrpr.setText(string_pafan_A_contoilsupplyhdrpr);
        pafan_A_cooleris.setText(string_pafan_A_cooleris);
        pafan_A_filteris.setText(string_pafan_A_filteris);
        pafan_A_oilreturnflow.setText(string_pafan_A_oilreturnflow);
        pafan_A_dp_temp_at_clr_inlet.setText(string_pafan_A_dp_temp_at_clr_inlet);
        pafan_A_temp_at_clr_outlet.setText(string_pafan_A_temp_at_clr_outlet);
        pafan_A_motor_brg_temp_DE.setText(string_pafan_A_motor_brg_temp_DE);
        pafan_A_motor_brg_temp_NDE.setText(string_pafan_A_motor_brg_temp_NDE);
        pafan_A_fan_brg_temp_DE.setText(string_pafan_A_fan_brg_temp_DE);
        pafan_A_fan_thrust_brg_1.setText(string_pafan_A_fan_thrust_brg_1);
        pafan_A_fan_thrust_brg_2.setText(string_pafan_A_fan_thrust_brg_2);
        pafan_A_fan_brg_temp_NDE.setText(string_pafan_A_fan_brg_temp_NDE);
        pafan_A_blade_pitch.setText(string_pafan_A_blade_pitch);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.pafan_A_oillevel,pafan_A_oillevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_oiltemp,pafan_A_oiltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_lopis,pafan_A_lopis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_lop_discharge_pressure,pafan_A_lop_discharge_pressure.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_dp_filter,pafan_A_dp_filter.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_lo_supply_hdr_pr,pafan_A_lo_supply_hdr_pr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_contoilsupplyhdrpr,pafan_A_contoilsupplyhdrpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_cooleris,pafan_A_cooleris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_filteris,pafan_A_filteris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_oilreturnflow,pafan_A_oilreturnflow.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_dp_temp_at_clr_inlet,pafan_A_dp_temp_at_clr_inlet.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_temp_at_clr_outlet,pafan_A_temp_at_clr_outlet.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_motor_brg_temp_DE,pafan_A_motor_brg_temp_DE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_motor_brg_temp_NDE,pafan_A_motor_brg_temp_NDE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_fan_brg_temp_DE,pafan_A_fan_brg_temp_DE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_fan_thrust_brg_1,pafan_A_fan_thrust_brg_1.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_fan_thrust_brg_2,pafan_A_fan_thrust_brg_2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_fan_brg_temp_NDE,pafan_A_fan_brg_temp_NDE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_A_blade_pitch,pafan_A_blade_pitch.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
