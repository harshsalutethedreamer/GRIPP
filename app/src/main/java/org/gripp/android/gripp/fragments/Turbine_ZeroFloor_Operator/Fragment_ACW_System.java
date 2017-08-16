package org.gripp.android.gripp.fragments.Turbine_ZeroFloor_Operator;

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

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 27/05/17.
 */

public class Fragment_ACW_System extends BaseFragment{

    private Unbinder mUnbinder;

    @BindView(R.id.turbine_zero_floor_dmcw_pumpcondition_A)
    EditText turbine_zero_floor_dmcw_pumpcondition_A;

    @BindView(R.id.turbine_zero_floor_dmcw_pumpcondition_B)
    EditText turbine_zero_floor_dmcw_pumpcondition_B;

    @BindView(R.id.turbine_zero_floor_dmcw_pumpcondition_C)
    EditText turbine_zero_floor_dmcw_pumpcondition_C;

    @BindView(R.id.turbine_zero_floor_dmcw_suctionvalve_A)
    EditText turbine_zero_floor_dmcw_suctionvalve_A;

    @BindView(R.id.turbine_zero_floor_dmcw_suctionvalve_B)
    EditText turbine_zero_floor_dmcw_suctionvalve_B;

    @BindView(R.id.turbine_zero_floor_dmcw_suctionvalve_C)
    EditText turbine_zero_floor_dmcw_suctionvalve_C;

    @BindView(R.id.turbine_zero_floor_dmcw_suctionpr_A)
    EditText turbine_zero_floor_dmcw_suctionpr_A;

    @BindView(R.id.turbine_zero_floor_dmcw_suctionpr_B)
    EditText turbine_zero_floor_dmcw_suctionpr_B;

    @BindView(R.id.turbine_zero_floor_dmcw_suctionpr_C)
    EditText turbine_zero_floor_dmcw_suctionpr_C;

    @BindView(R.id.turbine_zero_floor_dmcw_dischargepr_A)
    EditText turbine_zero_floor_dmcw_dischargepr_A;

    @BindView(R.id.turbine_zero_floor_dmcw_dischargepr_B)
    EditText turbine_zero_floor_dmcw_dischargepr_B;

    @BindView(R.id.turbine_zero_floor_dmcw_dischargepr_C)
    EditText turbine_zero_floor_dmcw_dischargepr_C;

    @BindView(R.id.turbine_zero_floor_acw_pumpcondition_A)
    EditText turbine_zero_floor_acw_pumpcondition_A;

    @BindView(R.id.turbine_zero_floor_acw_pumpcondition_B)
    EditText turbine_zero_floor_acw_pumpcondition_B;

    @BindView(R.id.turbine_zero_floor_acw_pumpcondition_C)
    EditText turbine_zero_floor_acw_pumpcondition_C;

    @BindView(R.id.turbine_zero_floor_acw_suctionvalve_A)
    EditText turbine_zero_floor_acw_suctionvalve_A;

    @BindView(R.id.turbine_zero_floor_acw_suctionvalve_B)
    EditText turbine_zero_floor_acw_suctionvalve_B;

    @BindView(R.id.turbine_zero_floor_acw_suctionvalve_C)
    EditText turbine_zero_floor_acw_suctionvalve_C;

    @BindView(R.id.turbine_zero_floor_acw_suctionpr_A)
    EditText turbine_zero_floor_acw_suctionpr_A;

    @BindView(R.id.turbine_zero_floor_acw_suctionpr_B)
    EditText turbine_zero_floor_acw_suctionpr_B;

    @BindView(R.id.turbine_zero_floor_acw_suctionpr_C)
    EditText turbine_zero_floor_acw_suctionpr_C;

    @BindView(R.id.turbine_zero_floor_acw_dischargepr_A)
    EditText turbine_zero_floor_acw_dischargepr_A;

    @BindView(R.id.turbine_zero_floor_acw_dischargepr_B)
    EditText turbine_zero_floor_acw_dischargepr_B;

    @BindView(R.id.turbine_zero_floor_acw_dischargepr_C)
    EditText turbine_zero_floor_acw_dischargepr_C;

    Map<String,String> map=new HashMap<String,String>();

    public static Fragment_ACW_System newInstance(){
        return new Fragment_ACW_System();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.turbine_zerometer_operator_acw,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);

        map.put("turbine_zero_floor_dmcw_pumpcondition_A",mSharedPreferences.getString(Constants.turbineacw[0],""));
        map.put("turbine_zero_floor_dmcw_pumpcondition_B",mSharedPreferences.getString(Constants.turbineacw[1],""));
        map.put("turbine_zero_floor_dmcw_pumpcondition_C",mSharedPreferences.getString(Constants.turbineacw[2],""));
        map.put("turbine_zero_floor_dmcw_suctionvalve_A",mSharedPreferences.getString(Constants.turbineacw[3],""));
        map.put("turbine_zero_floor_dmcw_suctionvalve_B",mSharedPreferences.getString(Constants.turbineacw[4],""));
        map.put("turbine_zero_floor_dmcw_suctionvalve_C",mSharedPreferences.getString(Constants.turbineacw[5],""));
        map.put("turbine_zero_floor_dmcw_suctionpr_A",mSharedPreferences.getString(Constants.turbineacw[6],""));
        map.put("turbine_zero_floor_dmcw_suctionpr_B",mSharedPreferences.getString(Constants.turbineacw[7],""));
        map.put("turbine_zero_floor_dmcw_suctionpr_C",mSharedPreferences.getString(Constants.turbineacw[8],""));
        map.put("turbine_zero_floor_dmcw_dischargepr_A",mSharedPreferences.getString(Constants.turbineacw[9],""));
        map.put("turbine_zero_floor_dmcw_dischargepr_B",mSharedPreferences.getString(Constants.turbineacw[10],""));
        map.put("turbine_zero_floor_dmcw_dischargepr_C",mSharedPreferences.getString(Constants.turbineacw[11],""));
        map.put("turbine_zero_floor_acw_pumpcondition_A",mSharedPreferences.getString(Constants.turbineacw[12],""));
        map.put("turbine_zero_floor_acw_pumpcondition_B",mSharedPreferences.getString(Constants.turbineacw[13],""));
        map.put("turbine_zero_floor_acw_pumpcondition_C",mSharedPreferences.getString(Constants.turbineacw[14],""));
        map.put("turbine_zero_floor_acw_suctionvalve_A",mSharedPreferences.getString(Constants.turbineacw[15],""));
        map.put("turbine_zero_floor_acw_suctionvalve_B",mSharedPreferences.getString(Constants.turbineacw[16],""));
        map.put("turbine_zero_floor_acw_suctionvalve_C",mSharedPreferences.getString(Constants.turbineacw[17],""));
        map.put("turbine_zero_floor_acw_suctionpr_A",mSharedPreferences.getString(Constants.turbineacw[18],""));
        map.put("turbine_zero_floor_acw_suctionpr_B",mSharedPreferences.getString(Constants.turbineacw[19],""));
        map.put("turbine_zero_floor_acw_suctionpr_C",mSharedPreferences.getString(Constants.turbineacw[20],""));
        map.put("turbine_zero_floor_acw_dischargepr_A",mSharedPreferences.getString(Constants.turbineacw[21],""));
        map.put("turbine_zero_floor_acw_dischargepr_B",mSharedPreferences.getString(Constants.turbineacw[22],""));
        map.put("turbine_zero_floor_acw_dischargepr_C",mSharedPreferences.getString(Constants.turbineacw[23],""));

        turbine_zero_floor_dmcw_pumpcondition_A.setText(map.get("turbine_zero_floor_dmcw_pumpcondition_A"));
        turbine_zero_floor_dmcw_pumpcondition_B.setText(map.get("turbine_zero_floor_dmcw_pumpcondition_B"));
        turbine_zero_floor_dmcw_pumpcondition_C.setText(map.get("turbine_zero_floor_dmcw_pumpcondition_C"));
        turbine_zero_floor_dmcw_suctionvalve_A.setText(map.get("turbine_zero_floor_dmcw_suctionvalve_A"));
        turbine_zero_floor_dmcw_suctionvalve_B.setText(map.get("turbine_zero_floor_dmcw_suctionvalve_B"));
        turbine_zero_floor_dmcw_suctionvalve_C.setText(map.get("turbine_zero_floor_dmcw_suctionvalve_C"));
        turbine_zero_floor_dmcw_suctionpr_A.setText(map.get("turbine_zero_floor_dmcw_suctionpr_A"));
        turbine_zero_floor_dmcw_suctionpr_B.setText(map.get("turbine_zero_floor_dmcw_suctionpr_B"));
        turbine_zero_floor_dmcw_suctionpr_C.setText(map.get("turbine_zero_floor_dmcw_suctionpr_C"));
        turbine_zero_floor_dmcw_dischargepr_A.setText(map.get("turbine_zero_floor_dmcw_dischargepr_A"));
        turbine_zero_floor_dmcw_dischargepr_B.setText(map.get("turbine_zero_floor_dmcw_dischargepr_B"));
        turbine_zero_floor_dmcw_dischargepr_C.setText(map.get("turbine_zero_floor_dmcw_dischargepr_C"));
        turbine_zero_floor_acw_pumpcondition_A.setText(map.get("turbine_zero_floor_acw_pumpcondition_A"));
        turbine_zero_floor_acw_pumpcondition_B.setText(map.get("turbine_zero_floor_acw_pumpcondition_B"));
        turbine_zero_floor_acw_pumpcondition_C.setText(map.get("turbine_zero_floor_acw_pumpcondition_C"));
        turbine_zero_floor_acw_suctionvalve_A.setText(map.get("turbine_zero_floor_acw_suctionvalve_A"));
        turbine_zero_floor_acw_suctionvalve_B.setText(map.get("turbine_zero_floor_acw_suctionvalve_B"));
        turbine_zero_floor_acw_suctionvalve_C.setText(map.get("turbine_zero_floor_acw_suctionvalve_C"));
        turbine_zero_floor_acw_suctionpr_A.setText(map.get("turbine_zero_floor_acw_suctionpr_A"));
        turbine_zero_floor_acw_suctionpr_B.setText(map.get("turbine_zero_floor_acw_suctionpr_B"));
        turbine_zero_floor_acw_suctionpr_C.setText(map.get("turbine_zero_floor_acw_suctionpr_C"));
        turbine_zero_floor_acw_dischargepr_A.setText(map.get("turbine_zero_floor_acw_dischargepr_A"));
        turbine_zero_floor_acw_dischargepr_B.setText(map.get("turbine_zero_floor_acw_dischargepr_B"));
        turbine_zero_floor_acw_dischargepr_C.setText(map.get("turbine_zero_floor_acw_dischargepr_C"));
        return rootView;
    }

    @OnClick(R2.id.save)
    public void onClick(){
        mSharedPreferences.edit().putString(Constants.turbineacw[0],turbine_zero_floor_dmcw_pumpcondition_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[1],turbine_zero_floor_dmcw_pumpcondition_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[2],turbine_zero_floor_dmcw_pumpcondition_C.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[3],turbine_zero_floor_dmcw_suctionvalve_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[4],turbine_zero_floor_dmcw_suctionvalve_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[5],turbine_zero_floor_dmcw_suctionvalve_C.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[6],turbine_zero_floor_dmcw_suctionpr_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[7],turbine_zero_floor_dmcw_suctionpr_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[8],turbine_zero_floor_dmcw_suctionpr_C.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[9],turbine_zero_floor_dmcw_dischargepr_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[10],turbine_zero_floor_dmcw_dischargepr_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[11],turbine_zero_floor_dmcw_dischargepr_C.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[12],turbine_zero_floor_acw_pumpcondition_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[13],turbine_zero_floor_acw_pumpcondition_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[14],turbine_zero_floor_acw_pumpcondition_C.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[15],turbine_zero_floor_acw_suctionvalve_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[16],turbine_zero_floor_acw_suctionvalve_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[17],turbine_zero_floor_acw_suctionvalve_C.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[18],turbine_zero_floor_acw_suctionpr_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[19],turbine_zero_floor_acw_suctionpr_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[20],turbine_zero_floor_acw_suctionpr_C.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[21],turbine_zero_floor_acw_dischargepr_A.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[22],turbine_zero_floor_acw_dischargepr_B.getText().toString()).commit();
        mSharedPreferences.edit().putString(Constants.turbineacw[23],turbine_zero_floor_acw_dischargepr_C.getText().toString()).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
