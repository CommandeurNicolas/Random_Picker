package com.example.randompicker.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.randompicker.Item;
import com.example.randompicker.R;
import com.example.randompicker.ui.result.Result;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class HomeFragment extends Fragment {

    private TextView textHome;

    private NumberPicker picker;

    private ArrayList<Item> itemList;
    private String[] data;

    private int nextItem = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        textHome = root.findViewById(R.id.text_home);
        textHome.setText("Apputez sur le bouton en bas a droite pour lancer le choix aléatoire");

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();

                if (itemList.size() > 1)
                {
                    nextItem = r.nextInt(data.length);
                }
                picker.setValue(nextItem);

                Intent i = new Intent(root.getContext(), Result.class);
                i.putExtra("result", itemList.get(nextItem).getItem());
                startActivity(i);
            }
        });





        // On récupère la liste des items
        itemList = Item.itemList;

        // On la transforme en Array[] si elle n'est pas vide
        if (itemList.size() > 0) {
            data = new String[itemList.size()];
            for (int i = 0; i < itemList.size(); i++) {
                data[i] = itemList.get(i).getItem();
            }
        }
        else {
            data = new String[1];
            data[0] = "Veuillez entrer des valeurs dans l'onglet \"Ajouter\"";
        }

        // Set up de NumberPicker
        picker = (NumberPicker) root.findViewById(R.id.npItem);
        picker.setMinValue(0);
        picker.setMaxValue(data.length-1);
        picker.setDisplayedValues(data);

        return root;
    }


    // EN DEVELOPPEMENT
    // computing a scroll animation
    /*
    public void computeScroll() {
        Display screen = this.getView().getDisplay();
        Point size = new Point();

        screen.getSize(size);
        int width = size.x;
        int height = size.y;

        System.out.println("\nheight : "+height);
        System.out.println("\nwidth : "+width);


        OverScroller mScroller = new OverScroller(picker.getContext());
        mScroller.forceFinished(true);
        mScroller.fling(1, 1, 1, 100, 0,width, 250, 500);
    }
    */
}