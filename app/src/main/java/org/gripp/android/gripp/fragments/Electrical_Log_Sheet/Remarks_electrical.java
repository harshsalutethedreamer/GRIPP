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
import org.gripp.android.gripp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 13/04/17.
 */

public class Remarks_electrical extends BaseFragment {
    @BindView(R.id.remarks)
    EditText remarks;

    String string_remarks;

    private Unbinder mUnbinder;

    public static Remarks_electrical newInstance(){
        return new Remarks_electrical();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_electrical_remarks,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_remarks=mSharedPreferences.getString(Constants.remarkselectrical,"");
        remarks.setText(string_remarks);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.remarkselectrical,remarks.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
