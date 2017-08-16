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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 02/03/17.
 */

public class FragmentFeeder3Fragment extends BaseFragment {

    @BindView(R.id.gbol_G)
    EditText gbol_G;

    @BindView(R.id.gbol_H)
    EditText gbol_H;

    @BindView(R.id.gbol_J)
    EditText gbol_J;

    @BindView(R.id.gbol_K)
    EditText gbol_K;

    @BindView(R.id.coc_G)
    EditText coc_G;

    @BindView(R.id.coc_H)
    EditText coc_H;

    @BindView(R.id.coc_J)
    EditText coc_J;

    @BindView(R.id.coc_K)
    EditText coc_K;

    @BindView(R.id.cgol_G)
    EditText cgol_G;

    @BindView(R.id.cgol_H)
    EditText cgol_H;

    @BindView(R.id.cgol_J)
    EditText cgol_J;

    @BindView(R.id.cgol_K)
    EditText cgol_K;

    @BindView(R.id.fig_G)
    EditText fig_G;

    @BindView(R.id.fig_H)
    EditText fig_H;

    @BindView(R.id.fig_J)
    EditText fig_J;

    @BindView(R.id.fig_K)
    EditText fig_K;

    @BindView(R.id.fog_G)
    EditText fog_G;

    @BindView(R.id.fog_H)
    EditText fog_H;

    @BindView(R.id.fog_J)
    EditText fog_J;

    @BindView(R.id.fog_K)
    EditText fog_K;

    @BindView(R.id.bog_G)
    EditText bog_G;

    @BindView(R.id.bog_H)
    EditText bog_H;

    @BindView(R.id.bog_J)
    EditText bog_J;

    @BindView(R.id.bog_K)
    EditText bog_K;

    @BindView(R.id.fsav_G)
    EditText fsav_G;

    @BindView(R.id.fsav_H)
    EditText fsav_H;

    @BindView(R.id.fsav_J)
    EditText fsav_J;

    @BindView(R.id.fsav_K)
    EditText fsav_K;

    String string_gbol_G,string_gbol_H,string_gbol_J,string_gbol_K;
    String string_coc_G,string_coc_H,string_coc_J,string_coc_K;
    String string_cgol_G,string_cgol_H,string_cgol_J,string_cgol_K;
    String string_fig_G,string_fig_H,string_fig_J,string_fig_K;
    String string_fog_G,string_fog_H,string_fog_J,string_fog_K;
    String string_bog_G,string_bog_H,string_bog_J,string_bog_K;
    String string_fsav_G,string_fsav_H,string_fsav_J,string_fsav_K;

    private Unbinder mUnbinder;

    public static FragmentFeeder3Fragment newInstance(){
        return new FragmentFeeder3Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilereightm_feeder3,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_gbol_G=mSharedPreferences.getString(Constants.gbol_G,"");
        string_gbol_H=mSharedPreferences.getString(Constants.gbol_H,"");
        string_gbol_J=mSharedPreferences.getString(Constants.gbol_J,"");
        string_gbol_K=mSharedPreferences.getString(Constants.gbol_K,"");

        string_coc_G=mSharedPreferences.getString(Constants.coc_G,"");
        string_coc_H=mSharedPreferences.getString(Constants.coc_H,"");
        string_coc_J=mSharedPreferences.getString(Constants.coc_J,"");
        string_coc_K=mSharedPreferences.getString(Constants.coc_K,"");

        string_cgol_G=mSharedPreferences.getString(Constants.cgol_G,"");
        string_cgol_H=mSharedPreferences.getString(Constants.cgol_H,"");
        string_cgol_J=mSharedPreferences.getString(Constants.cgol_J,"");
        string_cgol_K=mSharedPreferences.getString(Constants.cgol_K,"");

        string_fig_G=mSharedPreferences.getString(Constants.fig_G,"");
        string_fig_H=mSharedPreferences.getString(Constants.fig_H,"");
        string_fig_J=mSharedPreferences.getString(Constants.fig_J,"");
        string_fig_K=mSharedPreferences.getString(Constants.fig_K,"");

        string_fog_G=mSharedPreferences.getString(Constants.fog_G,"");
        string_fog_H=mSharedPreferences.getString(Constants.fog_H,"");
        string_fog_J=mSharedPreferences.getString(Constants.fog_J,"");
        string_fog_K=mSharedPreferences.getString(Constants.fog_K,"");

        string_bog_G=mSharedPreferences.getString(Constants.bog_G,"");
        string_bog_H=mSharedPreferences.getString(Constants.bog_H,"");
        string_bog_J=mSharedPreferences.getString(Constants.bog_J,"");
        string_bog_K=mSharedPreferences.getString(Constants.bog_K,"");

        string_fsav_G=mSharedPreferences.getString(Constants.fsav_G,"");
        string_fsav_H=mSharedPreferences.getString(Constants.fsav_H,"");
        string_fsav_J=mSharedPreferences.getString(Constants.fsav_J,"");
        string_fsav_K=mSharedPreferences.getString(Constants.fsav_K,"");


        gbol_G.setText(string_gbol_G);
        gbol_H.setText(string_gbol_H);
        gbol_J.setText(string_gbol_J);
        gbol_K.setText(string_gbol_K);

        coc_G.setText(string_coc_G);
        coc_H.setText(string_coc_H);
        coc_J.setText(string_coc_J);
        coc_K.setText(string_coc_K);

        cgol_G.setText(string_cgol_G);
        cgol_H.setText(string_cgol_H);
        cgol_J.setText(string_cgol_J);
        cgol_K.setText(string_cgol_K);

        fig_G.setText(string_fig_G);
        fig_H.setText(string_fig_H);
        fig_J.setText(string_fig_J);
        fig_K.setText(string_fig_K);

        fog_G.setText(string_fog_G);
        fog_H.setText(string_fog_H);
        fog_J.setText(string_fog_J);
        fog_K.setText(string_fog_K);

        bog_G.setText(string_bog_G);
        bog_H.setText(string_bog_H);
        bog_J.setText(string_bog_J);
        bog_K.setText(string_bog_K);

        fsav_G.setText(string_fsav_G);
        fsav_H.setText(string_fsav_H);
        fsav_J.setText(string_fsav_J);
        fsav_K.setText(string_fsav_K);


        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.gbol_G,gbol_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.gbol_H,gbol_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.gbol_J,gbol_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.gbol_K,gbol_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.coc_G,coc_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coc_H,coc_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coc_J,coc_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coc_K,coc_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.cgol_G,cgol_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cgol_H,cgol_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cgol_J,cgol_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cgol_K,cgol_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fig_G,fig_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fig_H,fig_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fig_J,fig_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fig_K,fig_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fog_G,fog_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fog_H,fog_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fog_J,fog_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fog_K,fog_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.bog_G,bog_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.bog_H,bog_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.bog_J,bog_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.bog_K,bog_K.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fsav_G,fsav_G.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fsav_H,fsav_H.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fsav_J,fsav_J.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fsav_K,fsav_K.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
