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

import static org.gripp.android.gripp.utils.Constants.electrical_dcdb;

/**
 * Created by harshgupta on 10/06/17.
 */

public class Fragment_electrical_dcdb extends BaseFragment{

    @BindView(R.id.sectiona_pe)
    EditText electrical_dcdb0;

    @BindView(R.id.sectiona_ne)
    EditText electrical_dcdb1;

    @BindView(R.id.sectiona_pn)
    EditText electrical_dcdb2;

    @BindView(R.id.sectionb_pe)
    EditText electrical_dcdb3;

    @BindView(R.id.sectionb_ne)
    EditText electrical_dcdb4;

    @BindView(R.id.sectionb_pn)
    EditText electrical_dcdb5;

    @BindView(R.id.buscouplerstatus_dcdb)
    EditText electrical_dcdb6;

    private Unbinder mUnbinder;
    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_electrical_dcdb newInstance(){
        return new Fragment_electrical_dcdb();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electrical_dcdb, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        for(int i=0;i<7;i++){
            String aa="electrical_dcdb"+i;
            map.put(aa,mSharedPreferences.getString(electrical_dcdb[i],""));
        }

        electrical_dcdb0.setText(map.get("electrical_dcdb0"));
        electrical_dcdb1.setText(map.get("electrical_dcdb1"));
        electrical_dcdb2.setText(map.get("electrical_dcdb2"));
        electrical_dcdb3.setText(map.get("electrical_dcdb3"));
        electrical_dcdb4.setText(map.get("electrical_dcdb4"));
        electrical_dcdb5.setText(map.get("electrical_dcdb5"));
        electrical_dcdb6.setText(map.get("electrical_dcdb6"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(electrical_dcdb[0],electrical_dcdb0.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dcdb[1],electrical_dcdb1.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dcdb[2],electrical_dcdb2.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dcdb[3],electrical_dcdb3.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dcdb[4],electrical_dcdb4.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dcdb[5],electrical_dcdb5.getText().toString()).commit();
        mSharedPreferences.edit().putString(electrical_dcdb[6],electrical_dcdb6.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
