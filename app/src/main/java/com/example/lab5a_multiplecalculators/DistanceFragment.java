package com.example.lab5a_multiplecalculators;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab5a_multiplecalculators.databinding.DistanceFragmentBinding;

public class DistanceFragment extends Fragment {

    public static final String ARG_ID = "id";

    private DistanceFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DistanceFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // Get numeric ID from parameter list
        Bundle args = getArguments();
        String id = Integer.toString(args.getInt(ARG_ID));

    }
}
