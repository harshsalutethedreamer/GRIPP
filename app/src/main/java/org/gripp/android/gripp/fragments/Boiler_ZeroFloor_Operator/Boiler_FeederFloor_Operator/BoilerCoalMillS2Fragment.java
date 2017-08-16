package org.gripp.android.gripp.fragments.Boiler_ZeroFloor_Operator.Boiler_FeederFloor_Operator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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

public class BoilerCoalMillS2Fragment extends BaseFragment {

    @BindView(R.id.tlt_D)
    EditText tlt_D;

    @BindView(R.id.tlt_E)
    EditText tlt_E;

    @BindView(R.id.tlt_F)
    EditText tlt_F;

    @BindView(R.id.lopis_D)
    EditText lopis_D;

    @BindView(R.id.lopis_E)
    EditText lopis_E;

    @BindView(R.id.lopis_F)
    EditText lopis_F;

    @BindView(R.id.lopr_D)
    EditText lopr_D;

    @BindView(R.id.lopr_E)
    EditText lopr_E;

    @BindView(R.id.lopr_F)
    EditText lopr_F;

    @BindView(R.id.fis_D)
    EditText fis_D;

    @BindView(R.id.fis_E)
    EditText fis_E;

    @BindView(R.id.fis_F)
    EditText fis_F;

    @BindView(R.id.cis_D)
    EditText cis_D;

    @BindView(R.id.cis_E)
    EditText cis_E;

    @BindView(R.id.cis_F)
    EditText cis_F;

    @BindView(R.id.coot_D)
    EditText coot_D;

    @BindView(R.id.coot_E)
    EditText coot_E;

    @BindView(R.id.coot_F)
    EditText coot_F;

    @BindView(R.id.pafilter_D)
    EditText pafilter_D;

    @BindView(R.id.pafilter_E)
    EditText pafilter_E;

    @BindView(R.id.pafilter_F)
    EditText pafilter_F;
    
    @BindView(R.id.pacooler_D)
            EditText pacooler_D;
    
    @BindView(R.id.pacooler_E)
            EditText pacooler_E;
    
    @BindView(R.id.pacooler_F)
            EditText pacooler_F;
    
    @BindView(R.id.mrejection_D)
            EditText mrejection_D;
    
    @BindView(R.id.mrejection_E)
    EditText mrejection_E;

    @BindView(R.id.mrejection_F)
    EditText mrejection_F;
    
    
    @BindView(R.id.rgate_D)
            EditText rgate_D;
    
    @BindView(R.id.rgate_E)
            EditText rgate_E;
    
    @BindView(R.id.rgate_F)
            EditText rgate_F;
    

    String string_tlt_D,string_tlt_E,string_tlt_F;
    String string_lopis_D,string_lopis_E,string_lopis_F;
    String string_lopr_D,string_lopr_E,string_lopr_F;
    String string_fis_D,string_fis_E,string_fis_F;
    String string_cis_D,string_cis_E,string_cis_F;
    String string_coot_D,string_coot_E,string_coot_F;
    String string_pafilter_D,string_pafilter_E,string_pafilter_F;
    String string_pacooler_D,string_pacooler_E,string_pacooler_F;
    String string_mrejection_D,string_mrejection_E,string_mrejection_F;
    String string_rgate_D,string_rgate_E,string_rgate_F;

    private Unbinder mUnbinder;

    public static BoilerCoalMillS2Fragment newInstance(){
        return new BoilerCoalMillS2Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilereightm_zero2,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        Log.d("common",mSharedPreferences.getString(Constants.tlt_D,"zz"));

        string_tlt_D=mSharedPreferences.getString(Constants.tlt_D,"");
        string_tlt_E=mSharedPreferences.getString(Constants.tlt_E,"");
        string_tlt_F=mSharedPreferences.getString(Constants.tlt_F,"");

        string_lopis_D=mSharedPreferences.getString(Constants.lopis_D,"");
        string_lopis_E=mSharedPreferences.getString(Constants.lopis_E,"");
        string_lopis_F=mSharedPreferences.getString(Constants.lopis_F,"");

        string_lopr_D=mSharedPreferences.getString(Constants.lopr_D,"");
        string_lopr_E=mSharedPreferences.getString(Constants.lopr_E,"");
        string_lopr_F=mSharedPreferences.getString(Constants.lopr_F,"");

        string_fis_D=mSharedPreferences.getString(Constants.fis_D,"");
        string_fis_E=mSharedPreferences.getString(Constants.fis_E,"");
        string_fis_F=mSharedPreferences.getString(Constants.fis_F,"");

        string_cis_D=mSharedPreferences.getString(Constants.cis_D,"");
        string_cis_E=mSharedPreferences.getString(Constants.cis_E,"");
        string_cis_F=mSharedPreferences.getString(Constants.cis_F,"");

        string_coot_D=mSharedPreferences.getString(Constants.coot_D,"");
        string_coot_E=mSharedPreferences.getString(Constants.coot_E,"");
        string_coot_F=mSharedPreferences.getString(Constants.coot_F,"");

        string_pafilter_D=mSharedPreferences.getString(Constants.pafilter_D,"");
        string_pafilter_E=mSharedPreferences.getString(Constants.pafilter_E,"");
        string_pafilter_F=mSharedPreferences.getString(Constants.pafilter_F,"");

        string_pacooler_D=mSharedPreferences.getString(Constants.pacooler_D,"");
        string_pacooler_E=mSharedPreferences.getString(Constants.pacooler_E,"");
        string_pacooler_F=mSharedPreferences.getString(Constants.pacooler_F,"");

        string_mrejection_D=mSharedPreferences.getString(Constants.mrejection_D,"");
        string_mrejection_E=mSharedPreferences.getString(Constants.mrejection_E,"");
        string_mrejection_F=mSharedPreferences.getString(Constants.mrejection_F,"");

        string_rgate_D=mSharedPreferences.getString(Constants.rgate_D,"");
        string_rgate_E=mSharedPreferences.getString(Constants.rgate_E,"");
        string_rgate_F=mSharedPreferences.getString(Constants.rgate_F,"");

        tlt_D.setText(string_tlt_D);
        tlt_E.setText(string_tlt_E);
        tlt_F.setText(string_tlt_F);

        lopis_D.setText(string_lopis_D);
        lopis_E.setText(string_lopis_E);
        lopis_F.setText(string_lopis_F);

        lopr_D.setText(string_lopr_D);
        lopr_E.setText(string_lopr_E);
        lopr_F.setText(string_lopr_F);

        fis_D.setText(string_fis_D);
        fis_E.setText(string_fis_E);
        fis_F.setText(string_fis_F);

        cis_D.setText(string_cis_D);
        cis_E.setText(string_cis_E);
        cis_F.setText(string_cis_F);

        coot_D.setText(string_coot_D);
        coot_E.setText(string_coot_E);
        coot_F.setText(string_coot_F);

        pafilter_D.setText(string_pafilter_D);
        pafilter_E.setText(string_pafilter_E);
        pafilter_F.setText(string_pafilter_F);

        pacooler_D.setText(string_pacooler_D);
        pacooler_E.setText(string_pacooler_E);
        pacooler_F.setText(string_pacooler_F);

        mrejection_D.setText(string_mrejection_D);
        mrejection_E.setText(string_mrejection_E);
        mrejection_F.setText(string_mrejection_F);

        rgate_D.setText(string_rgate_D);
        rgate_E.setText(string_rgate_E);
        rgate_F.setText(string_rgate_F);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.tlt_D,tlt_D.getText().toString()).commit();
        Log.d("commonx",mSharedPreferences.getString(Constants.tlt_D,"zzaa"));
        mSharedPreferences.edit().putString(Constants.tlt_E,tlt_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.tlt_F,tlt_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.lopis_D,lopis_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopis_E,lopis_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopis_F,lopis_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.lopr_D,lopr_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopr_E,lopr_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopr_F,lopr_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fis_D,fis_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fis_E,fis_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fis_F,fis_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.cis_D,cis_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cis_E,cis_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cis_F,cis_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.coot_D,coot_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coot_E,coot_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coot_F,coot_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.pafilter_D,pafilter_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafilter_E,pafilter_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafilter_F,pafilter_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.pacooler_D,pacooler_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pacooler_E,pacooler_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pacooler_F,pacooler_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.mrejection_D,mrejection_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.mrejection_E,mrejection_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.mrejection_F,mrejection_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.rgate_D,rgate_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.rgate_E,rgate_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.rgate_F,rgate_F.getText().toString()).commit();
        

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
