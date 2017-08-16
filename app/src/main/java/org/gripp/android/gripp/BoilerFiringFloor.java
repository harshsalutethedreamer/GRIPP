package org.gripp.android.gripp;

import android.support.v4.app.Fragment;

import org.gripp.android.gripp.activities.BaseFragmentActivity;
import org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator.OperatorBoilerFiringFloorFragment;

/**
 * Created by harshgupta on 14/04/17.
 */

public class BoilerFiringFloor extends BaseFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return OperatorBoilerFiringFloorFragment.newInstance();
    }
}
