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

import com.example.lab5a_multiplecalculators.databinding.TempFragmentBinding;

public class TempFragment extends Fragment {

    public static final String ARG_ID = "id";

    double f_temp, c_temp;

    private TempFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TempFragmentBinding.inflate(getLayoutInflater(), container, false);
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
        if(binding.fInput.getText().toString().equals(".") || binding.cInput.getText().toString().equals(".")){
            return false;
        }
        else if (binding.fInput.getText().toString().isEmpty() && binding.cInput.getText().toString().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    protected void convert(){

        if (TextUtils.isEmpty(binding.fInput.getText())){
            c_temp = Double.parseDouble(binding.cInput.getText().toString());
            f_temp = (c_temp * 9/5) + 32;
            binding.fInput.setText(String.valueOf(f_temp));
        }
        else {
            f_temp = Double.parseDouble(binding.fInput.getText().toString());
            c_temp = (f_temp - 32) * 5/9;
            binding.cInput.setText(String.valueOf(c_temp));
        }
    }
}
