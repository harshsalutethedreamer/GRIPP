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

public class Fragment_ID_A_Fragment extends BaseFragment {

    @BindView(R.id.idfan_A_oillevel)
    EditText idfan_A_oillevel;

    @BindView(R.id.idfan_A_oiltemp)
    EditText idfan_A_oiltemp;

    @BindView(R.id.idfan_A_lopis)
    EditText idfan_A_lopis;

    @BindView(R.id.idfan_A_lop_discharge_pressure)
    EditText idfan_A_lop_discharge_pressure;

    @BindView(R.id.idfan_A_dp_filter)
    EditText idfan_A_dp_filter;

    @BindView(R.id.idfan_A_lo_supply_hdr_pr)
    EditText idfan_A_lo_supply_hdr_pr;

    @BindView(R.id.idfan_A_contoilsupplyhdrpr)
            EditText idfan_A_contoilsupplyhdrpr;

    @BindView(R.id.idfan_A_temp_at_clr_inlet)
    EditText idfan_A_temp_at_clr_inlet;

    @BindView(R.id.idfan_A_temp_at_clr_outlet)
    EditText idfan_A_temp_at_clr_outlet;

    @BindView(R.id.idfan_A_motor_brg_temp_DE)
    EditText idfan_A_motor_brg_temp_DE;

    @BindView(R.id.idfan_A_motor_brg_temp_NDE)
    EditText idfan_A_motor_brg_temp_NDE;

    @BindView(R.id.idfan_A_motor_clr_CW_Flow_1)
    EditText idfan_A_motor_clr_CW_Flow_1;

    @BindView(R.id.idfan_A_motor_clr_CW_Flow_2)
    EditText idfan_A_motor_clr_CW_Flow_2;

    @BindView(R.id.idfan_A_cold_hot_cold_air_temp)
    EditText idfan_A_cold_hot_cold_air_temp;

    @BindView(R.id.idfan_A_fan_brg_temp_DE)
    EditText idfan_A_fan_brg_temp_DE;

    @BindView(R.id.idfan_A_fan_brg_temp_NDE)
    EditText idfan_A_fan_brg_temp_NDE;

    @BindView(R.id.idfan_A_igv_position)
    EditText idfan_A_igv_position;

    String string_idfan_A_oillevel,string_idfan_A_oiltemp,string_idfan_A_lopis,string_idfan_A_lop_discharge_pressure;
    String string_idfan_A_dp_filter,string_idfan_A_lo_supply_hdr_pr,string_idfan_A_contoilsupplyhdrpr,string_idfan_A_temp_at_clr_inlet;
    String string_idfan_A_temp_at_clr_outlet,string_idfan_A_motor_brg_temp_DE,string_idfan_A_motor_brg_temp_NDE;
    String string_idfan_A_motor_clr_CW_Flow_1,string_idfan_A_motor_clr_CW_Flow_2,string_idfan_A_cold_hot_cold_air_temp;
    String string_idfan_A_fan_brg_temp_DE,string_idfan_A_fan_brg_temp_NDE,string_idfan_A_igv_position;
    Long lastLogin;

    private Unbinder mUnbinder;

    public static Fragment_ID_A_Fragment newInstance(){
        return new Fragment_ID_A_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilerzerometer_idfana,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_idfan_A_oillevel=mSharedPreferences.getString(Constants.idfan_A_oillevel,"");
        string_idfan_A_oiltemp=mSharedPreferences.getString(Constants.idfan_A_oiltemp,"");
        string_idfan_A_lopis=mSharedPreferences.getString(Constants.idfan_A_lopis,"");
        string_idfan_A_lop_discharge_pressure=mSharedPreferences.getString(Constants.idfan_A_lop_discharge_pressure,"");
        string_idfan_A_dp_filter=mSharedPreferences.getString(Constants.idfan_A_dp_filter,"");
        string_idfan_A_lo_supply_hdr_pr=mSharedPreferences.getString(Constants.idfan_A_lo_supply_hdr_pr,"");
        string_idfan_A_contoilsupplyhdrpr=mSharedPreferences.getString(Constants.idfan_A_contoilsupplyhdrpr,"");
        string_idfan_A_temp_at_clr_inlet=mSharedPreferences.getString(Constants.idfan_A_temp_at_clr_inlet,"");
        string_idfan_A_temp_at_clr_outlet=mSharedPreferences.getString(Constants.idfan_A_temp_at_clr_outlet,"");
        string_idfan_A_motor_brg_temp_DE=mSharedPreferences.getString(Constants.idfan_A_motor_brg_temp_DE,"");
        string_idfan_A_motor_brg_temp_NDE=mSharedPreferences.getString(Constants.idfan_A_motor_brg_temp_NDE,"");
        string_idfan_A_motor_clr_CW_Flow_1=mSharedPreferences.getString(Constants.idfan_A_motor_clr_CW_Flow_1,"");
        string_idfan_A_motor_clr_CW_Flow_2=mSharedPreferences.getString(Constants.idfan_A_motor_clr_CW_Flow_2,"");
        string_idfan_A_cold_hot_cold_air_temp=mSharedPreferences.getString(Constants.idfan_A_cold_hot_cold_air_temp,"");
        string_idfan_A_fan_brg_temp_DE=mSharedPreferences.getString(Constants.idfan_A_fan_brg_temp_DE,"");
        string_idfan_A_fan_brg_temp_NDE=mSharedPreferences.getString(Constants.idfan_A_fan_brg_temp_NDE,"");
        string_idfan_A_igv_position=mSharedPreferences.getString(Constants.idfan_A_igv_position,"");
        lastLogin=mSharedPreferences.getLong(Constants.lastLogin,0);

        idfan_A_oillevel.setText(string_idfan_A_oillevel);
        idfan_A_oiltemp.setText(string_idfan_A_oiltemp);
        idfan_A_lopis.setText(string_idfan_A_lopis);
        idfan_A_lop_discharge_pressure.setText(string_idfan_A_lop_discharge_pressure);
        idfan_A_dp_filter.setText(string_idfan_A_dp_filter);
        idfan_A_lo_supply_hdr_pr.setText(string_idfan_A_lo_supply_hdr_pr);
        idfan_A_contoilsupplyhdrpr.setText(string_idfan_A_contoilsupplyhdrpr);
        idfan_A_temp_at_clr_inlet.setText(string_idfan_A_temp_at_clr_inlet);
        idfan_A_temp_at_clr_outlet.setText(string_idfan_A_temp_at_clr_outlet);
        idfan_A_motor_brg_temp_DE.setText(string_idfan_A_motor_brg_temp_DE);
        idfan_A_motor_brg_temp_NDE.setText(string_idfan_A_motor_brg_temp_NDE);
        idfan_A_motor_clr_CW_Flow_1.setText(string_idfan_A_motor_clr_CW_Flow_1);
        idfan_A_motor_clr_CW_Flow_2.setText(string_idfan_A_motor_clr_CW_Flow_2);
        idfan_A_cold_hot_cold_air_temp.setText(string_idfan_A_cold_hot_cold_air_temp);
        idfan_A_fan_brg_temp_DE.setText(string_idfan_A_fan_brg_temp_DE);
        idfan_A_fan_brg_temp_NDE.setText(string_idfan_A_fan_brg_temp_NDE);
        idfan_A_igv_position.setText(string_idfan_A_igv_position);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.idfan_A_oillevel,idfan_A_oillevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_oiltemp,idfan_A_oiltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_lopis,idfan_A_lopis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_lop_discharge_pressure,idfan_A_lop_discharge_pressure.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_dp_filter,idfan_A_dp_filter.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_lo_supply_hdr_pr,idfan_A_lo_supply_hdr_pr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_contoilsupplyhdrpr,idfan_A_contoilsupplyhdrpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_temp_at_clr_inlet,idfan_A_temp_at_clr_inlet.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_temp_at_clr_outlet,idfan_A_temp_at_clr_outlet.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_motor_brg_temp_DE,idfan_A_motor_brg_temp_DE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_motor_brg_temp_NDE,idfan_A_motor_brg_temp_NDE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_motor_clr_CW_Flow_1,idfan_A_motor_clr_CW_Flow_1.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_motor_clr_CW_Flow_2,idfan_A_motor_clr_CW_Flow_2.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_cold_hot_cold_air_temp,idfan_A_cold_hot_cold_air_temp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_fan_brg_temp_DE,idfan_A_fan_brg_temp_DE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_fan_brg_temp_NDE,idfan_A_fan_brg_temp_NDE.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.idfan_A_igv_position,idfan_A_igv_position.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
