package org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.gripp.android.gripp.R;
import org.gripp.android.gripp.R2;
import org.gripp.android.gripp.utils.Constants;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 02/03/17.
 */

public class FragmentPAPH_B_Fragment extends BaseFragment {

    @BindView(R.id.paph_b_gearboxoillevvel)
    EditText paph_b_gearboxoillevel;

    @BindView(R.id.paph_b_airmotorairpr)
    EditText paph_b_airmotorairpr;

    @BindView(R.id.paph_b_guide_lopis)
    EditText paph_b_guide_lopis;

    @BindView(R.id.paph_b_guide_oilpr)
    EditText paph_b_guide_oilpr;

    @BindView(R.id.paph_b_guide_oiltemp)
    EditText paph_b_guide_oiltemp;

    @BindView(R.id.paph_b_guide_oillevel)
    EditText paph_b_guide_oillevel;

    @BindView(R.id.paph_b_guide_flow)
    EditText paph_b_guide_flow;

    @BindView(R.id.paph_b_support_lopis)
    EditText paph_b_support_lopis;

    @BindView(R.id.paph_b_support_oilpr)
    EditText paph_b_support_oilpr;

    @BindView(R.id.paph_b_support_oiltemp)
    EditText paph_b_support_oiltemp;

    @BindView(R.id.paph_b_support_oillevel)
    EditText paph_b_support_oillevel;

    @BindView(R.id.paph_b_support_flow)
            EditText paph_b_support_flow;

    String string_paph_b_gearboxoillevel,string_paph_b_airmotorairpr,string_paph_b_guide_lopis,string_paph_b_guide_oilpr;
    String string_paph_b_guide_oiltemp,string_paph_b_guide_oillevel,string_paph_b_guide_flow,string_paph_b_support_lopis,string_paph_b_support_oilpr;
    String string_paph_b_support_oiltemp,string_paph_b_support_oillevel,string_paph_b_support_flow;
    Long lastLogin,currentTime;

    private Unbinder mUnbinder;

    public static FragmentPAPH_B_Fragment newInstance(){
        return new FragmentPAPH_B_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.paph_b,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_paph_b_gearboxoillevel=mSharedPreferences.getString(Constants.paph_b_gearboxoillevel,"");
        string_paph_b_airmotorairpr=mSharedPreferences.getString(Constants.paph_b_airmotorairpr,"");
        string_paph_b_guide_lopis=mSharedPreferences.getString(Constants.paph_b_guide_lopis,"");
        string_paph_b_guide_oilpr=mSharedPreferences.getString(Constants.paph_b_guide_oilpr,"");
        string_paph_b_guide_oiltemp=mSharedPreferences.getString(Constants.paph_b_guide_oiltemp,"");
        string_paph_b_guide_oillevel=mSharedPreferences.getString(Constants.paph_b_guide_oillevel,"");
        string_paph_b_guide_flow=mSharedPreferences.getString(Constants.paph_b_guide_flow,"");
        string_paph_b_support_lopis=mSharedPreferences.getString(Constants.paph_b_support_lopis,"");
        string_paph_b_support_oilpr=mSharedPreferences.getString(Constants.paph_b_support_oilpr,"");
        string_paph_b_support_oiltemp=mSharedPreferences.getString(Constants.paph_b_support_oiltemp,"");
        string_paph_b_support_oillevel=mSharedPreferences.getString(Constants.paph_b_support_oillevel,"");
        string_paph_b_support_flow=mSharedPreferences.getString(Constants.paph_b_support_flow,"");
        lastLogin=mSharedPreferences.getLong(Constants.lastLogin,0);

        currentTime=new Date().getTime();

        if(string_paph_b_gearboxoillevel!=null || string_paph_b_gearboxoillevel!=""){
            paph_b_gearboxoillevel.setText(string_paph_b_gearboxoillevel);
        }

        if(string_paph_b_airmotorairpr!=null || string_paph_b_airmotorairpr!=""){
            paph_b_airmotorairpr.setText(string_paph_b_airmotorairpr);
        }

        if(string_paph_b_guide_lopis!=null||string_paph_b_guide_lopis!=""){
            paph_b_guide_lopis.setText(string_paph_b_guide_lopis);
        }

        if(string_paph_b_guide_oilpr!=null||string_paph_b_guide_oilpr!=""){
            paph_b_guide_oilpr.setText(string_paph_b_guide_oilpr);
        }

        if(string_paph_b_guide_oiltemp!=null||string_paph_b_guide_oiltemp!=""){
            paph_b_guide_oiltemp.setText(string_paph_b_guide_oiltemp);
        }

        if(string_paph_b_guide_oillevel!=null||string_paph_b_guide_oillevel!=""){
            paph_b_guide_oillevel.setText(string_paph_b_guide_oillevel);
        }
        paph_b_guide_flow.setText(string_paph_b_guide_flow);

        if(string_paph_b_support_lopis!=null||string_paph_b_support_lopis!=""){
            paph_b_support_lopis.setText(string_paph_b_support_lopis);
        }

        if(string_paph_b_support_oilpr!=null||string_paph_b_support_oilpr!=""){
            paph_b_support_oilpr.setText(string_paph_b_support_oilpr);
        }

        if(string_paph_b_support_oiltemp!=null||string_paph_b_support_oiltemp!=""){
            paph_b_support_oiltemp.setText(string_paph_b_support_oiltemp);
        }

        if(string_paph_b_support_oillevel!=null||string_paph_b_support_oillevel!=""){
            paph_b_support_oillevel.setText(string_paph_b_support_oillevel);
        }
        paph_b_support_flow.setText(string_paph_b_support_flow);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.paph_b_airmotorairpr,paph_b_airmotorairpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_gearboxoillevel,paph_b_gearboxoillevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_guide_lopis,paph_b_guide_lopis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_guide_oilpr,paph_b_guide_oilpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_guide_oiltemp,paph_b_guide_oiltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_guide_oillevel,paph_b_guide_oillevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_guide_flow,paph_b_guide_flow.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_support_lopis,paph_b_support_lopis.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_support_oilpr,paph_b_support_oilpr.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_support_oiltemp,paph_b_support_oiltemp.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_support_oillevel,paph_b_support_oillevel.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.paph_b_support_flow,paph_b_support_flow.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
