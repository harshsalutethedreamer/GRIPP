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

public class FragmentBigStatusFragment extends BaseFragment {

    @BindView(R.id.mill_BIG)
    EditText mill_BIG;

    @BindView(R.id.BCW_Status)
    EditText BCW_Status;

    String string_mill_BIG,string_BCW_Status;
    private Unbinder mUnbinder;

    public static FragmentBigStatusFragment newInstance(){
        return new FragmentBigStatusFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.big_status,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        string_mill_BIG=mSharedPreferences.getString(Constants.mill_BIG,"");
        string_BCW_Status=mSharedPreferences.getString(Constants.BCW_Status,"");

            mill_BIG.setText(string_mill_BIG);
            BCW_Status.setText(string_BCW_Status);

        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.mill_BIG,mill_BIG.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.BCW_Status,BCW_Status.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
