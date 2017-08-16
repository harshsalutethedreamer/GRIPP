package org.gripp.android.gripp;

import android.support.v4.app.Fragment;

import org.gripp.android.gripp.activities.BaseFragmentActivity;
import org.gripp.android.gripp.fragments.Turbine_EightMeterFloor_Operator.OperatorTurbineEightMeterFloorFragment;

/**
 * Created by harshgupta on 14/04/17.
 */

public class TurbineEightPointFiveFloor extends BaseFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return OperatorTurbineEightMeterFloorFragment.newInstance();
    }
}
