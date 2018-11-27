package com.ridiansyah.papb_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {

    public static String RANDOM_KEY_NUMBER = "number";
    private TextView resultText;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Bundle bundle = this.getArguments();
        int numbers = 0;
        if (bundle != null){
            numbers = bundle.getInt(RANDOM_KEY_NUMBER,0);
            Log.d("number",numbers+" ");
        }
        resultText = view.findViewById(R.id.text_result);
        resultText.setText(String.valueOf(numbers));
        return view;
    }

}
