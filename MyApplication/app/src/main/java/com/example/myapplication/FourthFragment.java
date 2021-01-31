package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FourthFragment extends Fragment {
   // EditText TextNumber;
   // ImageButton PhoneButton;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
        TextNumber.findViewById(R.id.text_number);
        PhoneButton.findViewById(R.id.phone);

        PhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View PhoneButton) {
                String Num = TextNumber.getText().toString();
                String number = "Telephone: " + Num;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(number)));
            }
        });
         */

        view.findViewById(R.id.Return_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FourthFragment.this)
                        .navigate(R.id.action_FourthFragment_to_FirstFragment);
            }
        });
    }
}
