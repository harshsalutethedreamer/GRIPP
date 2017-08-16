package org.gripp.android.gripp.fragments.Boiler_ZeroFloor_Operator.Boiler_FeederFloor_Operator;

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

public class OperatorBoilerZeroFloorFragment extends BaseFragment {

    @BindView(R.id.fragment_boiler_firing_viewpager)
    ViewPager mViewPager;

    private Unbinder mUnbinder;
    private static final int NUM_PAGES_BOILERFEEDERFLOOR=11;

    private PagerAdapter mPagerAdapter;

    public static OperatorBoilerZeroFloorFragment newInstance(){
        return new OperatorBoilerZeroFloorFragment();
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
                return Fragment_BoilerZero_Shift_Initial_Detail.newInstance();
            }
            else if(position==1){
               return Fragment_FD_A_Fragment.newInstance();
            }else if(position==2){
                return Fragment_FD_B_Fragment.newInstance();
            }
            else if(position==3){
                return Fragment_PA_A_Fragment.newInstance();
            }else if(position==4){
                return Fragment_PA_B_Fragment.newInstance();
            } else if(position==5){
                return Fragment_ID_A_Fragment.newInstance();
            }else if(position==6){
                return Fragment_ID_B_Fragment.newInstance();
            }else if(position==7){
                return BoilerCoalMillS1Fragment.newInstance();
            }else if(position==8){
                return BoilerCoalMillS2Fragment.newInstance();
            }else if(position==9){
                return BoilerCoalMillS3Fragment.newInstance();
            }else if(position==10) {
                return Remarks_ZeroBoiler.newInstance();
            }else
            {
               return null;
            }
        }
    }
}
