package com.example.lab5a_multiplecalculators;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    public TabLayoutAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Bundle args = new Bundle();

        switch (position){
            case 0:
                Fragment tipFragment = new TipFragment();
                args.putInt(TipFragment.ARG_ID, position);
                tipFragment.setArguments(args);

                return tipFragment;
            case 1:
                Fragment tempFragment = new TempFragment();
                args.putInt(TempFragment.ARG_ID, position);
                tempFragment.setArguments(args);

                return tempFragment;
            case 2:
                Fragment distanceFragment = new DistanceFragment();
                args.putInt(DistanceFragment.ARG_ID, position);
                distanceFragment.setArguments(args);

                return distanceFragment;
            default:
                return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}