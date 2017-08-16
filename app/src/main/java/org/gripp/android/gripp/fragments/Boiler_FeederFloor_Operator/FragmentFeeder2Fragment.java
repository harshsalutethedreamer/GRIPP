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

public class FragmentFeeder2Fragment extends BaseFragment {

    @BindView(R.id.gbol_D)
    EditText gbol_D;

    @BindView(R.id.gbol_E)
    EditText gbol_E;

    @BindView(R.id.gbol_F)
    EditText gbol_F;

    @BindView(R.id.coc_D)
    EditText coc_D;

    @BindView(R.id.coc_E)
    EditText coc_E;

    @BindView(R.id.coc_F)
    EditText coc_F;

    @BindView(R.id.cgol_D)
    EditText cgol_D;

    @BindView(R.id.cgol_E)
    EditText cgol_E;

    @BindView(R.id.cgol_F)
    EditText cgol_F;

    @BindView(R.id.fig_D)
    EditText fig_D;

    @BindView(R.id.fig_E)
    EditText fig_E;

    @BindView(R.id.fig_F)
    EditText fig_F;

    @BindView(R.id.fog_D)
    EditText fog_D;

    @BindView(R.id.fog_E)
    EditText fog_E;

    @BindView(R.id.fog_F)
    EditText fog_F;

    @BindView(R.id.bog_D)
    EditText bog_D;

    @BindView(R.id.bog_E)
    EditText bog_E;

    @BindView(R.id.bog_F)
    EditText bog_F;

    @BindView(R.id.fsav_D)
    EditText fsav_D;

    @BindView(R.id.fsav_E)
    EditText fsav_E;

    @BindView(R.id.fsav_F)
    EditText fsav_F;

    String string_gbol_D,string_gbol_E,string_gbol_F;
    String string_coc_D,string_coc_E,string_coc_F;
    String string_cgol_D,string_cgol_E,string_cgol_F;
    String string_fig_D,string_fig_E,string_fig_F;
    String string_fog_D,string_fog_E,string_fog_F;
    String string_bog_D,string_bog_E,string_bog_F;
    String string_fsav_D,string_fsav_E,string_fsav_F;

    private Unbinder mUnbinder;

    public static FragmentFeeder2Fragment newInstance(){
        return new FragmentFeeder2Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_boilereightm_feeder2,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_gbol_D=mSharedPreferences.getString(Constants.gbol_D,"");
        string_gbol_E=mSharedPreferences.getString(Constants.gbol_E,"");
        string_gbol_F=mSharedPreferences.getString(Constants.gbol_F,"");

        string_coc_D=mSharedPreferences.getString(Constants.coc_D,"");
        string_coc_E=mSharedPreferences.getString(Constants.coc_E,"");
        string_coc_F=mSharedPreferences.getString(Constants.coc_F,"");

        string_cgol_D=mSharedPreferences.getString(Constants.cgol_D,"");
        string_cgol_E=mSharedPreferences.getString(Constants.cgol_E,"");
        string_cgol_F=mSharedPreferences.getString(Constants.cgol_F,"");

        string_fig_D=mSharedPreferences.getString(Constants.fig_D,"");
        string_fig_E=mSharedPreferences.getString(Constants.fig_E,"");
        string_fig_F=mSharedPreferences.getString(Constants.fig_F,"");

        string_fog_D=mSharedPreferences.getString(Constants.fog_D,"");
        string_fog_E=mSharedPreferences.getString(Constants.fog_E,"");
        string_fog_F=mSharedPreferences.getString(Constants.fog_F,"");

        string_bog_D=mSharedPreferences.getString(Constants.bog_D,"");
        string_bog_E=mSharedPreferences.getString(Constants.bog_E,"");
        string_bog_F=mSharedPreferences.getString(Constants.bog_F,"");

        string_fsav_D=mSharedPreferences.getString(Constants.fsav_D,"");
        string_fsav_E=mSharedPreferences.getString(Constants.fsav_E,"");
        string_fsav_F=mSharedPreferences.getString(Constants.fsav_F,"");

        gbol_D.setText(string_gbol_D);
        gbol_E.setText(string_gbol_E);
        gbol_F.setText(string_gbol_F);

        coc_D.setText(string_coc_D);
        coc_E.setText(string_coc_E);
        coc_F.setText(string_coc_F);

        cgol_D.setText(string_cgol_D);
        cgol_E.setText(string_cgol_E);
        cgol_F.setText(string_cgol_F);

        fig_D.setText(string_fig_D);
        fig_E.setText(string_fig_E);
        fig_F.setText(string_fig_F);

        fog_D.setText(string_fog_D);
        fog_E.setText(string_fog_E);
        fog_F.setText(string_fog_F);

        bog_D.setText(string_bog_D);
        bog_E.setText(string_bog_E);
        bog_F.setText(string_bog_F);

        fsav_D.setText(string_fsav_D);
        fsav_E.setText(string_fsav_E);
        fsav_F.setText(string_fsav_F);


        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.gbol_D,gbol_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.gbol_E,gbol_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.gbol_F,gbol_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.coc_D,coc_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coc_E,coc_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.coc_F,coc_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.cgol_D,cgol_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cgol_E,cgol_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.cgol_F,cgol_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fig_D,fig_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fig_E,fig_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fig_F,fig_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fog_D,fog_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fog_E,fog_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fog_F,fog_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.bog_D,bog_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.bog_E,bog_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.bog_F,bog_F.getText().toString()).commit();

        mSharedPreferences.edit().putString(Constants.fsav_D,fsav_D.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fsav_E,fsav_E.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.fsav_F,fsav_F.getText().toString()).commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
