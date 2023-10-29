package com.example.practice;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class ControlFragment extends Fragment{
    CardView card_temp, card_humd, card_light, card_soil;
    Dialog dialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view_card = inflater.inflate(R.layout.fragment_control,container,false);
        //Cards
        card_temp = view_card.findViewById(R.id.card_air_temp);
        card_humd = view_card.findViewById(R.id.card_humdity);
        card_light = view_card.findViewById(R.id.cardlight);
        card_soil = view_card.findViewById(R.id.card_soil_moisture);

        dialog = new Dialog(requireContext());

        card_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogTemp();
            }
        });

        card_humd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogHumdity();
            }
        });

        card_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogLight();
            }
        });

        card_soil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogSoil();
            }
        });

        return view_card;
    }

    private void openDialogTemp() {
        dialog.setContentView(R.layout.temp_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    private void openDialogLight() {
        dialog.setContentView(R.layout.light_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void openDialogHumdity() {
        dialog.setContentView(R.layout.humidity_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void openDialogSoil() {
        dialog.setContentView(R.layout.soil_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
