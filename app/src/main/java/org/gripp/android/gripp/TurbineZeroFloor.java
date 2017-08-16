package org.gripp.android.gripp;

import android.support.v4.app.Fragment;

import org.gripp.android.gripp.activities.BaseFragmentActivity;
import org.gripp.android.gripp.fragments.Turbine_ZeroFloor_Operator.OperatorTurbineZeroFloorFragment;

/**
 * Created by harshgupta on 14/04/17.
 */

public class TurbineZeroFloor extends BaseFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return OperatorTurbineZeroFloorFragment.newInstance();
    }
}
