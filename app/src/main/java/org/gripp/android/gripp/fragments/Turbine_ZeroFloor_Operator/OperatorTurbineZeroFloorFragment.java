package org.gripp.android.gripp.fragments.Turbine_ZeroFloor_Operator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gripp.android.gripp.R;
import org.gripp.android.gripp.fragments.Boiler_FeederFloor_Operator.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by harshgupta on 02/03/17.
 */

public class OperatorTurbineZeroFloorFragment extends BaseFragment {

    @BindView(R.id.fragment_boiler_firing_viewpager)
    ViewPager mViewPager;

    private Unbinder mUnbinder;
    private static final int NUM_PAGES_BOILERFEEDERFLOOR=10;

    private PagerAdapter mPagerAdapter;

    public static OperatorTurbineZeroFloorFragment newInstance(){
        return new OperatorTurbineZeroFloorFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_operator_boiler_firing,container,false);
        mUnbinder= ButterKnife.bind(this,rootView);
        mPagerAdapter=new ScreenSliderPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        return rootView;
    }


    public class ScreenSliderPagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSliderPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_PAGES_BOILERFEEDERFLOOR;
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return Fragment_TurbineZero_Shift_Initial_Detail.newInstance();
            }
            else if(position==1){
               return Fragment_Condensate_Extraction_Pump.newInstance();
            }else if(position==2){
                return Fragment_Seal_Oil_System.newInstance();
            }
            else if(position==3){
                return Fragment_Vacuum_Pump.newInstance();
            }else if(position==4){
                return Fragment_Control_Fluid_System.newInstance();
            } else if(position==5){
                return Fragment_ACW_System.newInstance();
            }else if(position==6){
                return Fragment_TDBFP_OIL_ONE.newInstance();
            }else if(position==7){
                return Fragment_TDBFP_OIL_TWO.newInstance();
            }else if(position==8){
                return Fragment_Other_Equipment.newInstance();
            }else if(position==9){
                return Remarks_ZeroTurbine.newInstance();
            }else
            {
               return null;
            }
        }
    }
}
