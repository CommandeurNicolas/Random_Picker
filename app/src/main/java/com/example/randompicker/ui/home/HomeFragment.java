package com.example.randompicker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.randompicker.Item;
import com.example.randompicker.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;
import java.lang.String;

public class HomeFragment extends Fragment {

    private TextView textHome;

    private HomeViewModel homeViewModel;
    private NumberPicker picker;
    private Integer random;

    private ArrayList<Item> items;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        textHome = (TextView) root.findViewById(R.id.text_home);

        //ArrayList<Item> items = Item.itemList;
        // String[] data = new String[]{"bob", "machin", "truc", "chose", "chouette"};

        // String[] data = ;

        // Item[] data = (Item[]) list;

        items = Item.itemList;

        String[] data = new String[items.size()];

        for (int i = 0; i < items.size(); i++) {
            data[i] = items.get(i).getItem();
        }







        picker = (NumberPicker) root.findViewById(R.id.npItem);

        picker.setMinValue(0);
        picker.setMaxValue(data.length-1);
        picker.setDisplayedValues(data);

        Random r = new Random();
        int i = r.nextInt(data.length-1);

        textHome.setText("random number : " + i);

        picker.setValue(i);









        return root;
    }
}