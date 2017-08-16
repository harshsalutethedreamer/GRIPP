package org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.gripp.android.gripp.R;
import org.gripp.android.gripp.R2;
import org.gripp.android.gripp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 02/03/17.
 */

public class FragmentFeeder1Fragment extends BaseFragment {

    @BindView(R.id.gbol_A)
    EditText gbol_A;

    @BindView(R.id.gbol_B)
    EditText gbol_B;

    @BindView(R.id.gbol_C)
    EditText gbol_C;

    @BindView(R.id.coc_A)
    EditText coc_A;

    @BindView(R.id.coc_B)
    EditText coc_B;

    @BindView(R.id.coc_C)
    EditText coc_C;

    @BindView(R.id.cgol_A)
    EditText cgol_A;

    @BindView(R.id.cgol_B)
    EditText cgol_B;

    @BindView(R.id.cgol_C)
    EditText cgol_C;

    @BindView(R.id.fig_A)
    EditText fig_A;

    @BindView(R.id.fig_B)
    EditText fig_B;

    @BindView(R.id.fig_C)
    EditText fig_C;

    @BindView(R.id.fog_A)
    EditText fog_A;

    @BindView(R.id.fog_B)
    EditText fog_B;

    @BindView(R.id.fog_C)
    EditText fog_C;

    @BindView(R.id.bog_A)
    EditText bog_A;

    @BindView(R.id.bog_B)
    EditText bog_B;

    @BindView(R.id.bog_C)
    EditText bog_C;

    @BindView(R.id.fsav_A)
    EditText fsav_A;

    @BindView(R.id.fsav_B)
    EditText fsav_B;

    @BindView(R.id.fsav_C)
    EditText fsav_C;

    String string_gbol_A,string_gbol_B,string_gbol_C;
    String string_coc_A,string_coc_B,string_coc_C;
    String string_cgol_A,string_cgol_B,string_cgol_C;
    String string_fig_A,string_fig_B,string_fig_C;
    String string_fog_A,string_fog_B,string_fog_C;
    String string_bog_A,string_bog_B,string_bog_C;
    String string_fsav_A,string_fsav_B,string_fsav_C;

    private Unbinder mUnbinder;

    public static FragmentFeeder1Fragment newInstance(){
        return new FragmentFeeder1Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilereightm_feeder1,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_gbol_A=mSharedPreferences.getString(Constants.gbol_A,"");
        string_gbol_B=mSharedPreferences.getString(Constants.gbol_B,"");
        string_gbol_C=mSharedPreferences.getString(Constants.gbol_C,"");

        string_coc_A=mSharedPreferences.getString(Constants.coc_A,"");
        string_coc_B=mSharedPreferences.getString(Constants.coc_B,"");
        string_coc_C=mSharedPreferences.getString(Constants.coc_C,"");

        string_cgol_A=mSharedPreferences.getString(Constants.cgol_A,"");
        Log.d("commonxx",mSharedPreferences.getString(Constants.cgol_A,"zz"));
        string_cgol_B=mSharedPreferences.getString(Constants.cgol_B,"");
        string_cgol_C=mSharedPreferences.getString(Constants.cgol_C,"");

        string_fig_A=mSharedPreferences.getString(Constants.fig_A,"");
        string_fig_B=mSharedPreferences.getString(Constants.fig_B,"");
        string_fig_C=mSharedPreferences.getString(Constants.fig_C,"");

        string_fog_A=mSharedPreferences.getString(Constants.fog_A,"");
        string_fog_B=mSharedPreferences.getString(Constants.fog_B,"");
        string_fog_C=mSharedPreferences.getString(Constants.fog_C,"");

        string_bog_A=mSharedPreferences.getString(Constants.bog_A,"");
        string_bog_B=mSharedPreferences.getString(Constants.bog_B,"");
        string_bog_C=mSharedPreferences.getString(Constants.bog_C,"");

        string_fsav_A=mSharedPreferences.getString(Constants.fsav_A,"");
        string_fsav_B=mSharedPreferences.getString(Constants.fsav_B,"");
        string_fsav_C=mSharedPreferences.getString(Constants.fsav_C,"");

        gbol_A.setText(string_gbol_A);
        gbol_B.setText(string_gbol_B);
        gbol_C.setText(string_gbol_C);

        coc_A.setText(string_coc_A);
        coc_B.setText(string_coc_B);
        coc_C.setText(string_coc_C);

        cgol_A.setText(string_cgol_A);
        cgol_B.setText(string_cgol_B);
        cgol_C.setText(string_cgol_C);

        fig_A.setText(string_fig_A);
        fig_B.setText(string_fig_B);
        fig_C.setText(string_fig_C);

        fog_A.setText(string_fog_A);
        fog_B.setText(string_fog_B);
        fog_C.setText(string_fog_C);

        bog_A.setText(string_bog_A);
        bog_B.setText(string_bog_B);
        bog_C.setText(string_bog_C);

        fsav_A.setText(string_fsav_A);
        fsav_B.setText(string_fsav_B);
        fsav_C.setText(string_fsav_C);


        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.gbol_A,gbol_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.gbol_B,gbol_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.gbol_C,gbol_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.coc_A,coc_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coc_B,coc_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coc_C,coc_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.cgol_A,cgol_A.getText().toString()).commit();
        Log.d("commonyy",mSharedPreferences.getString(Constants.cgol_A,"zz"));
        mSharedPreferences.edit().putString(Constants.cgol_B,cgol_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cgol_C,cgol_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fig_A,fig_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fig_B,fig_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fig_C,fig_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fog_A,fog_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fog_B,fog_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fog_C,fog_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.bog_A,bog_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.bog_B,bog_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.bog_C,bog_C.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fsav_A,fsav_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fsav_B,fsav_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fsav_C,fsav_C.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
