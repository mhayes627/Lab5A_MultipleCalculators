package com.example.lab5a_multiplecalculators;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab5a_multiplecalculators.databinding.DistanceFragmentBinding;

public class DistanceFragment extends Fragment {

    public static final String ARG_ID = "id";

    private DistanceFragmentBinding binding;

    double miles, kilos;
    final double CONVERSION_CONSTANT = 1.60934;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DistanceFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidConversion()){
                    convert();
                }
                else{
                    Toast toast = Toast.makeText(binding.getRoot().getContext(), "ERROR", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    protected boolean isValidConversion(){
        if(binding.milesInput.getText().toString().equals(".") || binding.kiloInput.getText().toString().equals(".")){
            return false;
        }
        else if (binding.milesInput.getText().toString().isEmpty() && binding.kiloInput.getText().toString().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    protected void convert(){

        if (TextUtils.isEmpty(binding.milesInput.getText())){
            kilos = Double.parseDouble(binding.kiloInput.getText().toString());
            miles = kilos / CONVERSION_CONSTANT;
            binding.milesInput.setText(String.valueOf(miles));
        }
        else {
            miles = Double.parseDouble(binding.milesInput.getText().toString());
            kilos = miles * CONVERSION_CONSTANT;
            binding.kiloInput.setText(String.valueOf(kilos));
        }
    }
}
