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
 * Created by harshgupta on 13/04/17.
 */

public class Remarks extends BaseFragment{
    @BindView(R.id.remarks)
    EditText remarks;

    String string_remarks;

    private Unbinder mUnbinder;

    public static Remarks newInstance(){
        return new Remarks();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.remarks,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_remarks=mSharedPreferences.getString(Constants.remarks,"");
        remarks.setText(string_remarks);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.remarks,remarks.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
