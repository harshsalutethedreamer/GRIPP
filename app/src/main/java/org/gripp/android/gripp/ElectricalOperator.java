package org.gripp.android.gripp;

import android.support.v4.app.Fragment;

import org.gripp.android.gripp.activities.BaseFragmentActivity;
import org.gripp.android.gripp.fragments.Electrical_Log_Sheet.OperatorElectrical;

/**
 * Created by harshgupta on 14/04/17.
 */

public class ElectricalOperator extends BaseFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return OperatorElectrical.newInstance();
    }
}
