package org.gripp.android.gripp;

import android.support.v4.app.Fragment;

import org.gripp.android.gripp.activities.BaseFragmentActivity;
import org.gripp.android.gripp.fragments.Boiler_ZeroFloor_Operator.Boiler_FeederFloor_Operator.OperatorBoilerZeroFloorFragment;

/**
 * Created by harshgupta on 14/04/17.
 */

public class BoilerZeroFloor extends BaseFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return OperatorBoilerZeroFloorFragment.newInstance();
    }
}
