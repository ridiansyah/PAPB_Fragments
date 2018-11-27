package com.ridiansyah.papb_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static com.ridiansyah.papb_fragments.SecondFragment.RANDOM_KEY_NUMBER;

public class FirstFragment extends Fragment implements View.OnClickListener {


    public FirstFragment() {
        // Required empty public constructor
    }


    private Button buttonResult;
    private TextView firstNumber;
    private TextView secondNumber;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        buttonResult = view.findViewById(R.id.button_result);
        firstNumber = view.findViewById(R.id.result_left);
        secondNumber = view.findViewById(R.id.result_right);

        buttonResult.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_result: {
                randomNumber();
                break;
            }
        }
    }

    private void randomNumber(){
        Random random = new Random();
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();

        int randomNumber = random.nextInt(100) + 1;
        int randomNumbers = random.nextInt(10) + 1;
        firstNumber.setText(String.valueOf(randomNumber));
        secondNumber.setText(String.valueOf(randomNumbers));

        bundle.putInt(RANDOM_KEY_NUMBER,compareNumber(randomNumber,randomNumbers));
        fragment.setArguments(bundle);
    }

    private int compareNumber(int num1, int num2){
        int comparedNumber = 0 ;
        if (num1 > num2){
            comparedNumber = num1;
        }else if (num1 <  num2){
            comparedNumber = num2;
        }else {
            comparedNumber = num1;
        }
        return comparedNumber;
    }
}
