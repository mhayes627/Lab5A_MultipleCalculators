package com.example.lab5a_multiplecalculators;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab5a_multiplecalculators.databinding.TipFragmentBinding;

import java.text.NumberFormat;

public class TipFragment extends Fragment {

    public static final String ARG_ID = "id";

    String bill_input, percent_input, people_input, totalFormat;
    int percent, people;
    double bill, total;

    private TipFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TipFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bill_input = binding.billInput.getText().toString();
                percent_input =  binding.percentInput.getText().toString();
                people_input = binding.peopleInput.getText().toString();

                if (isValidCheck()){
                    calculateTotal();
                }
                else{
                    Toast toast = Toast.makeText(binding.getRoot().getContext(), "ERROR", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    public boolean isValidCheck(){
        if (bill_input.isEmpty() || percent_input.isEmpty()
            || people_input.isEmpty()){
            return false;
        }
        else if (bill_input.equals(".")){
            return false;
        }
        else{
            return true;
        }
    }

    public void calculateTotal(){
        bill = Double.parseDouble(bill_input);
        percent = Integer.parseInt(percent_input);
        people = Integer.parseInt(people_input);

        if (bill != 0 && percent != 0 && people != 0) {
            total = ((bill * percent / 100) + bill) / people;
            totalFormat = NumberFormat.getCurrencyInstance().format(total);

            binding.totalText.setText(getResources().getString(R.string.total_text, totalFormat));
        }
    }
}
