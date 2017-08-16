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

public class BoilerCoalMillS1Fragment extends BaseFragment {

    @BindView(R.id.tlt_A)
    EditText tlt_A;

    @BindView(R.id.tlt_B)
    EditText tlt_B;

    @BindView(R.id.tlt_C)
    EditText tlt_C;

    @BindView(R.id.lopis_A)
    EditText lopis_A;

    @BindView(R.id.lopis_B)
    EditText lopis_B;

    @BindView(R.id.lopis_C)
    EditText lopis_C;

    @BindView(R.id.lopr_A)
    EditText lopr_A;

    @BindView(R.id.lopr_B)
    EditText lopr_B;

    @BindView(R.id.lopr_C)
    EditText lopr_C;

    @BindView(R.id.fis_A)
    EditText fis_A;

    @BindView(R.id.fis_B)
    EditText fis_B;

    @BindView(R.id.fis_C)
    EditText fis_C;

    @BindView(R.id.cis_A)
    EditText cis_A;

    @BindView(R.id.cis_B)
    EditText cis_B;

    @BindView(R.id.cis_C)
    EditText cis_C;

    @BindView(R.id.coot_A)
    EditText coot_A;

    @BindView(R.id.coot_B)
    EditText coot_B;

    @BindView(R.id.coot_C)
    EditText coot_C;

    @BindView(R.id.pafilter_A)
    EditText pafilter_A;

    @BindView(R.id.pafilter_B)
    EditText pafilter_B;

    @BindView(R.id.pafilter_C)
    EditText pafilter_C;

    @BindView(R.id.pacooler_A)
            EditText pacooler_A;

    @BindView(R.id.pacooler_B)
            EditText pacooler_B;

    @BindView(R.id.pacooler_C)
            EditText pacooler_C;

    @BindView(R.id.mrejection_A)
            EditText mrejection_A;

    @BindView(R.id.mrejection_B)
    EditText mrejection_B;

    @BindView(R.id.mrejection_C)
    EditText mrejection_C;


    @BindView(R.id.rgate_A)
            EditText rgate_A;

    @BindView(R.id.rgate_B)
            EditText rgate_B;

    @BindView(R.id.rgate_C)
            EditText rgate_C;


    String string_tlt_A,string_tlt_B,string_tlt_C;
    String string_lopis_A,string_lopis_B,string_lopis_C;
    String string_lopr_A,string_lopr_B,string_lopr_C;
    String string_fis_A,string_fis_B,string_fis_C;
    String string_cis_A,string_cis_B,string_cis_C;
    String string_coot_A,string_coot_B,string_coot_C;
    String string_pafilter_A,string_pafilter_B,string_pafilter_C;
    String string_pacooler_A,string_pacooler_B,string_pacooler_C;
    String string_mrejection_A,string_mrejection_B,string_mrejection_C;
    String string_rgate_A,string_rgate_B,string_rgate_C;

    private Unbinder mUnbinder;

    public static BoilerCoalMillS1Fragment newInstance(){
        return new BoilerCoalMillS1Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilereightm_zero1,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        Log.d("common",mSharedPreferences.getString(Constants.tlt_A,"zz"));

        string_tlt_A=mSharedPreferences.getString(Constants.tlt_A,"");
        string_tlt_B=mSharedPreferences.getString(Constants.tlt_B,"");
        string_tlt_C=mSharedPreferences.getString(Constants.tlt_C,"");

        string_lopis_A=mSharedPreferences.getString(Constants.lopis_A,"");
        string_lopis_B=mSharedPreferences.getString(Constants.lopis_B,"");
        string_lopis_C=mSharedPreferences.getString(Constants.lopis_C,"");

        string_lopr_A=mSharedPreferences.getString(Constants.lopr_A,"");
        string_lopr_B=mSharedPreferences.getString(Constants.lopr_B,"");
        string_lopr_C=mSharedPreferences.getString(Constants.lopr_C,"");

        string_fis_A=mSharedPreferences.getString(Constants.fis_A,"");
        string_fis_B=mSharedPreferences.getString(Constants.fis_B,"");
        string_fis_C=mSharedPreferences.getString(Constants.fis_C,"");

        string_cis_A=mSharedPreferences.getString(Constants.cis_A,"");
        string_cis_B=mSharedPreferences.getString(Constants.cis_B,"");
        string_cis_C=mSharedPreferences.getString(Constants.cis_C,"");

        string_coot_A=mSharedPreferences.getString(Constants.coot_A,"");
        string_coot_B=mSharedPreferences.getString(Constants.coot_B,"");
        string_coot_C=mSharedPreferences.getString(Constants.coot_C,"");

        string_pafilter_A=mSharedPreferences.getString(Constants.pafilter_A,"");
        string_pafilter_B=mSharedPreferences.getString(Constants.pafilter_B,"");
        string_pafilter_C=mSharedPreferences.getString(Constants.pafilter_C,"");

        string_pacooler_A=mSharedPreferences.getString(Constants.pacooler_A,"");
        string_pacooler_B=mSharedPreferences.getString(Constants.pacooler_B,"");
        string_pacooler_C=mSharedPreferences.getString(Constants.pacooler_C,"");

        string_mrejection_A=mSharedPreferences.getString(Constants.mrejection_A,"");
        string_mrejection_B=mSharedPreferences.getString(Constants.mrejection_B,"");
        string_mrejection_C=mSharedPreferences.getString(Constants.mrejection_C,"");

        string_rgate_A=mSharedPreferences.getString(Constants.rgate_A,"");
        string_rgate_B=mSharedPreferences.getString(Constants.rgate_B,"");
        string_rgate_C=mSharedPreferences.getString(Constants.rgate_C,"");

        tlt_A.setText(string_tlt_A);
        tlt_B.setText(string_tlt_B);
        tlt_C.setText(string_tlt_C);

        lopis_A.setText(string_lopis_A);
        lopis_B.setText(string_lopis_B);
        lopis_C.setText(string_lopis_C);

        lopr_A.setText(string_lopr_A);
        lopr_B.setText(string_lopr_B);
        lopr_C.setText(string_lopr_C);

        fis_A.setText(string_fis_A);
        fis_B.setText(string_fis_B);
        fis_C.setText(string_fis_C);

        cis_A.setText(string_cis_A);
        cis_B.setText(string_cis_B);
        cis_C.setText(string_cis_C);

        coot_A.setText(string_coot_A);
        coot_B.setText(string_coot_B);
        coot_C.setText(string_coot_C);

        pafilter_A.setText(string_pafilter_A);
        pafilter_B.setText(string_pafilter_B);
        pafilter_C.setText(string_pafilter_C);

        pacooler_A.setText(string_pacooler_A);
        pacooler_B.setText(string_pacooler_B);
        pacooler_C.setText(string_pacooler_C);

        mrejection_A.setText(string_mrejection_A);
        mrejection_B.setText(string_mrejection_B);
        mrejection_C.setText(string_mrejection_C);

        rgate_A.setText(string_rgate_A);
        rgate_B.setText(string_rgate_B);
        rgate_C.setText(string_rgate_C);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.tlt_A,tlt_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.tlt_B,tlt_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.tlt_C,tlt_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.lopis_A,lopis_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopis_B,lopis_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopis_C,lopis_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.lopr_A,lopr_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopr_B,lopr_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.lopr_C,lopr_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fis_A,fis_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fis_B,fis_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fis_C,fis_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.cis_A,cis_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cis_B,cis_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cis_C,cis_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.coot_A,coot_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coot_B,coot_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coot_C,coot_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.pafilter_A,pafilter_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafilter_B,pafilter_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pafilter_C,pafilter_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.pacooler_A,pacooler_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pacooler_B,pacooler_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.pacooler_C,pacooler_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.mrejection_A,mrejection_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.mrejection_B,mrejection_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.mrejection_C,mrejection_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.rgate_A,rgate_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.rgate_B,rgate_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.rgate_C,rgate_C.getText().toString()).commit();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
