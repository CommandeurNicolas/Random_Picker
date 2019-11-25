package com.example.randompicker.ui.delete;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randompicker.DeleteItemAdapter;
import com.example.randompicker.Item;
import com.example.randompicker.R;

import java.util.ArrayList;

public class DeleteFragment extends Fragment {

    private DeleteViewModel deleteViewModel;

    public TextView textNotif;

    private ArrayList<Item> items;

    private int errorColor = 0xFFA83232;
    private int okColor = 0xFF42AD52;
    private int white = 0xFFFFFFFF;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        deleteViewModel =
                ViewModelProviders.of(this).get(DeleteViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_delete, container, false);

        final RecyclerView rvItem = (RecyclerView) root.findViewById(R.id.rvItem);
        items = Item.itemList;
        final DeleteItemAdapter adapter = new DeleteItemAdapter(items);
        rvItem.setAdapter(adapter);
        rvItem.setLayoutManager(new LinearLayoutManager(root.getContext()));

        textNotif = (TextView) root.findViewById(R.id.notif_delete);

        textNotif.setBackgroundColor(okColor);
        textNotif.setTextColor(white);
        textNotif.setText("Choix ajouté avec succès\nFAIRE EN SORTE QUE QUAND JE CLICK SUR UNE POUBELLE ÇA CHANGE CET ETAT");

        return root;
    }

}