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

public class Fragment_PA_B_Fragment extends BaseFragment {

    @BindView(R.id.pafan_B_oillevel)
    EditText pafan_B_oillevel;

    @BindView(R.id.pafan_B_oiltemp)
    EditText pafan_B_oiltemp;

    @BindView(R.id.pafan_B_lopis)
    EditText pafan_B_lopis;

    @BindView(R.id.pafan_B_lop_discharge_pressure)
    EditText pafan_B_lop_discharge_pressure;

    @BindView(R.id.pafan_B_dp_filter)
    EditText pafan_B_dp_filter;

    @BindView(R.id.pafan_B_lo_supply_hdr_pr)
    EditText pafan_B_lo_supply_hdr_pr;

    @BindView(R.id.pafan_B_contoilsupplyhdrpr)
            EditText pafan_B_contoilsupplyhdrpr;

    @BindView(R.id.pafan_B_cooleris)
            EditText pafan_B_cooleris;

    @BindView(R.id.pafan_B_filteris)
            EditText pafan_B_filteris;

    @BindView(R.id.pafan_B_oilreturnflow)
            EditText pafan_B_oilreturnflow;

    @BindView(R.id.pafan_B_dp_temp_at_clr_inlet)
            EditText pafan_B_dp_temp_at_clr_inlet;

    @BindView(R.id.pafan_B_temp_at_clr_outlet)
            EditText pafan_B_temp_at_clr_outlet;

    @BindView(R.id.pafan_B_motor_brg_temp_DE)
            EditText pafan_B_motor_brg_temp_DE;

    @BindView(R.id.pafan_B_motor_brg_temp_NDE)
            EditText pafan_B_motor_brg_temp_NDE;

    @BindView(R.id.pafan_B_fan_brg_temp_DE)
            EditText pafan_B_fan_brg_temp_DE;

    @BindView(R.id.pafan_B_fan_brg_temp_NDE)
            EditText pafan_B_fan_brg_temp_NDE;

    @BindView(R.id.pafan_B_fan_thrust_brg_1)
            EditText pafan_B_fan_thrust_brg_1;

    @BindView(R.id.pafan_B_fan_thrust_brg_2)
    EditText pafan_B_fan_thrust_brg_2;

    @BindView(R.id.pafan_B_blade_pitch)
            EditText pafan_B_blade_pitch;

    String string_pafan_B_oillevel,string_pafan_B_oiltemp,string_pafan_B_lopis,string_pafan_B_lop_discharge_pressure;
    String string_pafan_B_dp_filter,string_pafan_B_lo_supply_hdr_pr,string_pafan_B_contoilsupplyhdrpr,string_pafan_B_cooleris;
    String string_pafan_B_filteris,string_pafan_B_oilreturnflow,string_pafan_B_dp_temp_at_clr_inlet;
    String string_pafan_B_temp_at_clr_outlet,string_pafan_B_motor_brg_temp_DE,string_pafan_B_motor_brg_temp_NDE;
    String string_pafan_B_fan_brg_temp_DE,string_pafan_B_fan_brg_temp_NDE,string_pafan_B_fan_thrust_brg_1;
    String string_pafan_B_fan_thrust_brg_2,string_pafan_B_blade_pitch;
    Long lastLogin;

    private Unbinder mUnbinder;

    public static Fragment_PA_B_Fragment newInstance(){
        return new Fragment_PA_B_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilerzerometer_pafanb,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_pafan_B_oillevel=mSharedPreferences.getString(Constants.pafan_B_oillevel,"");
        string_pafan_B_oiltemp=mSharedPreferences.getString(Constants.pafan_B_oiltemp,"");
        string_pafan_B_lopis=mSharedPreferences.getString(Constants.pafan_B_lopis,"");
        string_pafan_B_lop_discharge_pressure=mSharedPreferences.getString(Constants.pafan_B_lop_discharge_pressure,"");
        string_pafan_B_dp_filter=mSharedPreferences.getString(Constants.pafan_B_dp_filter,"");
        string_pafan_B_lo_supply_hdr_pr=mSharedPreferences.getString(Constants.pafan_B_lo_supply_hdr_pr,"");
        string_pafan_B_contoilsupplyhdrpr=mSharedPreferences.getString(Constants.pafan_B_contoilsupplyhdrpr,"");
        string_pafan_B_cooleris=mSharedPreferences.getString(Constants.pafan_B_cooleris,"");
        string_pafan_B_filteris=mSharedPreferences.getString(Constants.pafan_B_filteris,"");
        string_pafan_B_oilreturnflow=mSharedPreferences.getString(Constants.pafan_B_oilreturnflow,"");
        string_pafan_B_dp_temp_at_clr_inlet=mSharedPreferences.getString(Constants.pafan_B_dp_temp_at_clr_inlet,"");
        string_pafan_B_temp_at_clr_outlet=mSharedPreferences.getString(Constants.pafan_B_temp_at_clr_outlet,"");
        string_pafan_B_motor_brg_temp_DE=mSharedPreferences.getString(Constants.pafan_B_motor_brg_temp_DE,"");
        string_pafan_B_motor_brg_temp_NDE=mSharedPreferences.getString(Constants.pafan_B_motor_brg_temp_NDE,"");
        string_pafan_B_fan_brg_temp_DE=mSharedPreferences.getString(Constants.pafan_B_fan_brg_temp_DE,"");
        string_pafan_B_fan_thrust_brg_1=mSharedPreferences.getString(Constants.pafan_B_fan_thrust_brg_1,"");
        string_pafan_B_fan_thrust_brg_2=mSharedPreferences.getString(Constants.pafan_B_fan_thrust_brg_2,"");
        string_pafan_B_fan_brg_temp_NDE=mSharedPreferences.getString(Constants.pafan_B_fan_brg_temp_NDE,"");
        string_pafan_B_blade_pitch=mSharedPreferences.getString(Constants.pafan_B_blade_pitch,"");
        lastLogin=mSharedPreferences.getLong(Constants.lastLogin,0);

        pafan_B_oillevel.setText(string_pafan_B_oillevel);
        pafan_B_oiltemp.setText(string_pafan_B_oiltemp);
        pafan_B_lopis.setText(string_pafan_B_lopis);
        pafan_B_lop_discharge_pressure.setText(string_pafan_B_lop_discharge_pressure);
        pafan_B_dp_filter.setText(string_pafan_B_dp_filter);
        pafan_B_lo_supply_hdr_pr.setText(string_pafan_B_lo_supply_hdr_pr);
        pafan_B_contoilsupplyhdrpr.setText(string_pafan_B_contoilsupplyhdrpr);
        pafan_B_cooleris.setText(string_pafan_B_cooleris);
        pafan_B_filteris.setText(string_pafan_B_filteris);
        pafan_B_oilreturnflow.setText(string_pafan_B_oilreturnflow);
        pafan_B_dp_temp_at_clr_inlet.setText(string_pafan_B_dp_temp_at_clr_inlet);
        pafan_B_temp_at_clr_outlet.setText(string_pafan_B_temp_at_clr_outlet);
        pafan_B_motor_brg_temp_DE.setText(string_pafan_B_motor_brg_temp_DE);
        pafan_B_motor_brg_temp_NDE.setText(string_pafan_B_motor_brg_temp_NDE);
        pafan_B_fan_brg_temp_DE.setText(string_pafan_B_fan_brg_temp_DE);
        pafan_B_fan_thrust_brg_1.setText(string_pafan_B_fan_thrust_brg_1);
        pafan_B_fan_thrust_brg_2.setText(string_pafan_B_fan_thrust_brg_2);
        pafan_B_fan_brg_temp_NDE.setText(string_pafan_B_fan_brg_temp_NDE);
        pafan_B_blade_pitch.setText(string_pafan_B_blade_pitch);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.pafan_B_oillevel,pafan_B_oillevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_oiltemp,pafan_B_oiltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_lopis,pafan_B_lopis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_lop_discharge_pressure,pafan_B_lop_discharge_pressure.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_dp_filter,pafan_B_dp_filter.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_lo_supply_hdr_pr,pafan_B_lo_supply_hdr_pr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_contoilsupplyhdrpr,pafan_B_contoilsupplyhdrpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_cooleris,pafan_B_cooleris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_filteris,pafan_B_filteris.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_oilreturnflow,pafan_B_oilreturnflow.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_dp_temp_at_clr_inlet,pafan_B_dp_temp_at_clr_inlet.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_temp_at_clr_outlet,pafan_B_temp_at_clr_outlet.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_motor_brg_temp_DE,pafan_B_motor_brg_temp_DE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_motor_brg_temp_NDE,pafan_B_motor_brg_temp_NDE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_fan_brg_temp_DE,pafan_B_fan_brg_temp_DE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_fan_thrust_brg_1,pafan_B_fan_thrust_brg_1.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_fan_thrust_brg_2,pafan_B_fan_thrust_brg_2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_fan_brg_temp_NDE,pafan_B_fan_brg_temp_NDE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafan_B_blade_pitch,pafan_B_blade_pitch.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
