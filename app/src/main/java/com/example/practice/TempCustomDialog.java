package com.example.practice;


import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AppCompatDialog;
import me.tankery.lib.circularseekbar.CircularSeekBar;

public class TempCustomDialog extends DialogFragment {
    Dialog dialog;

    CircularSeekBar circ_temp, circ_hum, circ_light, circ_soil;
    EditText edit_temp, edit_hum, edit_light, edit_soil;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View custom_dialog = inflater.inflate(R.layout.temp_layout_dialog, null);

        circ_temp = custom_dialog.findViewById(R.id.temp_controller);
        edit_temp = custom_dialog.findViewById(R.id.edit_temperature);

        // Set up a listener for the CircularSeekBar
        circ_temp.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, float progress, boolean fromUser) {
                // Update the EditText with the selected value
                edit_temp.setText(String.valueOf(50)); // i-add ko lang po yung progress
                // Log the progress value for debugging
                Log.d("SeekBarDebug", "Progress: " + progress);
            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar circularSeekBar) {
                // Not needed for this example
            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar circularSeekBar) {
                // Not needed for this example
            }
        });


        builder.setView(custom_dialog);
        return builder.create();
}
}
