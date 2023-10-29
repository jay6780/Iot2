package com.example.practice;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.Nullable;

public class DisplayFragment extends Fragment {

    private TextView display_temp, display_hum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View display_card = inflater.inflate(R.layout.fragment_display, container, false);

        display_temp = display_card.findViewById(R.id.dis_temp);
        display_hum = display_card.findViewById(R.id.dis_hum);

        //Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference temp_ref = database.getReference("Sensor/Temperature");
        DatabaseReference hum_ref = database.getReference("Sensor/Humidity");

        //Read temperature data from firebase
        temp_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Double doubleValue = snapshot.getValue(Double.class);
                    if (doubleValue != null) {
                        String stringValue = String.valueOf(doubleValue);
                        Log.d("Firebase","Temperature exits");
                        display_temp.setText(stringValue + "%");
                        // Now you can use stringValue as a String.
                    }
                }else {
                    Log.d("Firebase", "Temperature data doesn't exist.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Firebase", "Failed to read temperature value.", error.toException());
            }
        });

        //Read humidity data from firebase
        hum_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Double doubleValue = snapshot.getValue(Double.class);
                    if (doubleValue != null) {
                        String humstringVal = String.valueOf(doubleValue);
                        display_hum.setText(humstringVal + "%");
                        // Now you can use stringValue as a String.
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Firebase", "Failed to read humidity value.", error.toException());
            }
        });


        return display_card;
    }
}
