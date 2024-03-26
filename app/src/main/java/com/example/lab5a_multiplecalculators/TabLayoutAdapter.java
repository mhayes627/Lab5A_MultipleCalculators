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

        Fragment tipFragment = new TipFragment();

        Bundle args = new Bundle();
        args.putInt(TipFragment.ARG_ID, position + 1);
        tipFragment.setArguments(args);

        return tipFragment;

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}