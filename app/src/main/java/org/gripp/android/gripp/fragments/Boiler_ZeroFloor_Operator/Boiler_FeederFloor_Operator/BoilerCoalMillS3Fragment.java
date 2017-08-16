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

public class BoilerCoalMillS3Fragment extends BaseFragment {

    @BindView(R.id.tlt_G)
    EditText tlt_G;

    @BindView(R.id.tlt_H)
    EditText tlt_H;

    @BindView(R.id.tlt_J)
    EditText tlt_J;

    @BindView(R.id.tlt_K)
    EditText tlt_K;

    @BindView(R.id.lopis_G)
    EditText lopis_G;

    @BindView(R.id.lopis_H)
    EditText lopis_H;

    @BindView(R.id.lopis_J)
    EditText lopis_J;

    @BindView(R.id.lopis_K)
    EditText lopis_K;

    @BindView(R.id.lopr_G)
    EditText lopr_G;

    @BindView(R.id.lopr_H)
    EditText lopr_H;

    @BindView(R.id.lopr_J)
    EditText lopr_J;

    @BindView(R.id.lopr_K)
    EditText lopr_K;

    @BindView(R.id.fis_G)
    EditText fis_G;

    @BindView(R.id.fis_H)
    EditText fis_H;

    @BindView(R.id.fis_J)
    EditText fis_J;

    @BindView(R.id.fis_K)
    EditText fis_K;

    @BindView(R.id.cis_G)
    EditText cis_G;

    @BindView(R.id.cis_H)
    EditText cis_H;

    @BindView(R.id.cis_J)
    EditText cis_J;

    @BindView(R.id.cis_K)
    EditText cis_K;

    @BindView(R.id.coot_G)
    EditText coot_G;

    @BindView(R.id.coot_H)
    EditText coot_H;

    @BindView(R.id.coot_J)
    EditText coot_J;

    @BindView(R.id.coot_K)
    EditText coot_K;

    @BindView(R.id.pafilter_G)
    EditText pafilter_G;

    @BindView(R.id.pafilter_H)
    EditText pafilter_H;

    @BindView(R.id.pafilter_J)
    EditText pafilter_J;

    @BindView(R.id.pafilter_K)
    EditText pafilter_K;
    
    @BindView(R.id.pacooler_G)
            EditText pacooler_G;
    
    @BindView(R.id.pacooler_H)
            EditText pacooler_H;
    
    @BindView(R.id.pacooler_J)
            EditText pacooler_J;

    @BindView(R.id.pacooler_K)
    EditText pacooler_K;
    
    @BindView(R.id.mrejection_G)
            EditText mrejection_G;
    
    @BindView(R.id.mrejection_H)
    EditText mrejection_H;

    @BindView(R.id.mrejection_J)
    EditText mrejection_J;

    @BindView(R.id.mrejection_K)
    EditText mrejection_K;
    
    
    @BindView(R.id.rgate_G)
            EditText rgate_G;
    
    @BindView(R.id.rgate_H)
            EditText rgate_H;
    
    @BindView(R.id.rgate_J)
            EditText rgate_J;

    @BindView(R.id.rgate_K)
    EditText rgate_K;
    

    String string_tlt_G,string_tlt_H,string_tlt_J,string_tlt_K;
    String string_lopis_G,string_lopis_H,string_lopis_J,string_lopis_K;
    String string_lopr_G,string_lopr_H,string_lopr_J,string_lopr_K;
    String string_fis_G,string_fis_H,string_fis_J,string_fis_K;
    String string_cis_G,string_cis_H,string_cis_J,string_cis_K;
    String string_coot_G,string_coot_H,string_coot_J,string_coot_K;
    String string_pafilter_G,string_pafilter_H,string_pafilter_J,string_pafilter_K;
    String string_pacooler_G,string_pacooler_H,string_pacooler_J,string_pacooler_K;
    String string_mrejection_G,string_mrejection_H,string_mrejection_J,string_mrejection_K;
    String string_rgate_G,string_rgate_H,string_rgate_J,string_rgate_K;

    private Unbinder mUnbinder;

    public static BoilerCoalMillS3Fragment newInstance(){
        return new BoilerCoalMillS3Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilereightm_zero3,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        Log.d("common",mSharedPreferences.getString(Constants.tlt_G,"zz"));

        string_tlt_G=mSharedPreferences.getString(Constants.tlt_G,"");
        string_tlt_H=mSharedPreferences.getString(Constants.tlt_H,"");
        string_tlt_J=mSharedPreferences.getString(Constants.tlt_J,"");
        string_tlt_K=mSharedPreferences.getString(Constants.tlt_K,"");

        string_lopis_G=mSharedPreferences.getString(Constants.lopis_G,"");
        string_lopis_H=mSharedPreferences.getString(Constants.lopis_H,"");
        string_lopis_J=mSharedPreferences.getString(Constants.lopis_J,"");
        string_lopis_K=mSharedPreferences.getString(Constants.lopis_K,"");

        string_lopr_G=mSharedPreferences.getString(Constants.lopr_G,"");
        string_lopr_H=mSharedPreferences.getString(Constants.lopr_H,"");
        string_lopr_J=mSharedPreferences.getString(Constants.lopr_J,"");
        string_lopr_K=mSharedPreferences.getString(Constants.lopr_K,"");

        string_fis_G=mSharedPreferences.getString(Constants.fis_G,"");
        string_fis_H=mSharedPreferences.getString(Constants.fis_H,"");
        string_fis_J=mSharedPreferences.getString(Constants.fis_J,"");
        string_fis_K=mSharedPreferences.getString(Constants.fis_K,"");

        string_cis_G=mSharedPreferences.getString(Constants.cis_G,"");
        string_cis_H=mSharedPreferences.getString(Constants.cis_H,"");
        string_cis_J=mSharedPreferences.getString(Constants.cis_J,"");
        string_cis_K=mSharedPreferences.getString(Constants.cis_K,"");

        string_coot_G=mSharedPreferences.getString(Constants.coot_G,"");
        string_coot_H=mSharedPreferences.getString(Constants.coot_H,"");
        string_coot_J=mSharedPreferences.getString(Constants.coot_J,"");
        string_coot_K=mSharedPreferences.getString(Constants.coot_K,"");


        string_pafilter_G=mSharedPreferences.getString(Constants.pafilter_G,"");
        string_pafilter_H=mSharedPreferences.getString(Constants.pafilter_H,"");
        string_pafilter_J=mSharedPreferences.getString(Constants.pafilter_J,"");
        string_pafilter_K=mSharedPreferences.getString(Constants.pafilter_K,"");

        string_pacooler_G=mSharedPreferences.getString(Constants.pacooler_G,"");
        string_pacooler_H=mSharedPreferences.getString(Constants.pacooler_H,"");
        string_pacooler_J=mSharedPreferences.getString(Constants.pacooler_J,"");
        string_pacooler_K=mSharedPreferences.getString(Constants.pacooler_K,"");

        string_mrejection_G=mSharedPreferences.getString(Constants.mrejection_G,"");
        string_mrejection_H=mSharedPreferences.getString(Constants.mrejection_H,"");
        string_mrejection_J=mSharedPreferences.getString(Constants.mrejection_J,"");
        string_mrejection_K=mSharedPreferences.getString(Constants.mrejection_K,"");

        string_rgate_G=mSharedPreferences.getString(Constants.rgate_G,"");
        string_rgate_H=mSharedPreferences.getString(Constants.rgate_H,"");
        string_rgate_J=mSharedPreferences.getString(Constants.rgate_J,"");
        string_rgate_K=mSharedPreferences.getString(Constants.rgate_K,"");

        tlt_G.setText(string_tlt_G);
        tlt_H.setText(string_tlt_H);
        tlt_J.setText(string_tlt_J);
        tlt_K.setText(string_tlt_K);

        lopis_G.setText(string_lopis_G);
        lopis_H.setText(string_lopis_H);
        lopis_J.setText(string_lopis_J);
        lopis_K.setText(string_lopis_K);

        lopr_G.setText(string_lopr_G);
        lopr_H.setText(string_lopr_H);
        lopr_J.setText(string_lopr_J);
        lopr_K.setText(string_lopr_K);

        fis_G.setText(string_fis_G);
        fis_H.setText(string_fis_H);
        fis_J.setText(string_fis_J);
        fis_K.setText(string_fis_K);

        cis_G.setText(string_cis_G);
        cis_H.setText(string_cis_H);
        cis_J.setText(string_cis_J);
        cis_K.setText(string_cis_K);

        coot_G.setText(string_coot_G);
        coot_H.setText(string_coot_H);
        coot_J.setText(string_coot_J);
        coot_K.setText(string_coot_K);

        pafilter_G.setText(string_pafilter_G);
        pafilter_H.setText(string_pafilter_H);
        pafilter_J.setText(string_pafilter_J);
        pafilter_K.setText(string_pafilter_K);

        pacooler_G.setText(string_pacooler_G);
        pacooler_H.setText(string_pacooler_H);
        pacooler_J.setText(string_pacooler_J);
        pacooler_K.setText(string_pacooler_K);

        mrejection_G.setText(string_mrejection_G);
        mrejection_H.setText(string_mrejection_H);
        mrejection_J.setText(string_mrejection_J);
        mrejection_K.setText(string_mrejection_K);

        rgate_G.setText(string_rgate_G);
        rgate_H.setText(string_rgate_H);
        rgate_J.setText(string_rgate_J);
        rgate_K.setText(string_rgate_K);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.tlt_G,tlt_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.tlt_H,tlt_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.tlt_J,tlt_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.tlt_K,tlt_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.lopis_G,lopis_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopis_H,lopis_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopis_J,lopis_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopis_K,lopis_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.lopr_G,lopr_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopr_H,lopr_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopr_J,lopr_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopr_K,lopr_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fis_G,fis_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fis_H,fis_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fis_J,fis_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fis_K,fis_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.cis_G,cis_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cis_H,cis_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cis_J,cis_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cis_K,cis_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.coot_G,coot_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coot_H,coot_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coot_J,coot_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coot_K,coot_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.pafilter_G,pafilter_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafilter_H,pafilter_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafilter_J,pafilter_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafilter_K,pafilter_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.pacooler_G,pacooler_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pacooler_H,pacooler_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pacooler_J,pacooler_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pacooler_K,pacooler_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.mrejection_G,mrejection_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.mrejection_H,mrejection_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.mrejection_J,mrejection_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.mrejection_K,mrejection_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.rgate_G,rgate_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.rgate_H,rgate_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.rgate_J,rgate_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.rgate_K,rgate_K.getText().toString()).commit();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
