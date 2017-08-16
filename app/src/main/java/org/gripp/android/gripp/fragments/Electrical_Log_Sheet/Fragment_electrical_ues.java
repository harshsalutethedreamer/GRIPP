package org.gripp.android.gripp.fragments.Electrical_Log_Sheet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.gripp.android.gripp.R;
import org.gripp.android.gripp.R2;
import org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static org.gripp.android.gripp.utils.Constants.electrical_ues;

/**
 * Created by harshgupta on 10/06/17.
 */

public class Fragment_electrical_ues extends BaseFragment{

    @BindView(R.id.ues_secavolt)
    EditText electrical_ues0;

    @BindView(R.id.ues_secbvolt)
    EditText electrical_ues1;

    @BindView(R.id.ues_secacurrent)
    EditText electrical_ues2;

    @BindView(R.id.ues_secbcurrent)
    EditText electrical_ues3;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_ues newInstance(){
        return new Fragment_electrical_ues();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_ues, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        for(int i=0;i<4;i++){
            String aa="electrical_ues"+i;
            map.put(aa,mSharedPreferences.getString(electrical_ues[i],""));
        }

        electrical_ues0.setText(map.get("electrical_ues0"));
        electrical_ues1.setText(map.get("electrical_ues1"));
        electrical_ues2.setText(map.get("electrical_ues2"));
        electrical_ues3.setText(map.get("electrical_ues3"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(electrical_ues[0],electrical_ues0.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ues[1],electrical_ues1.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ues[2],electrical_ues2.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_ues[3],electrical_ues3.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
