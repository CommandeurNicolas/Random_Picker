package com.example.randompicker.ui.add;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randompicker.AddItemAdapter;
import com.example.randompicker.Item;
import com.example.randompicker.R;

import java.util.ArrayList;

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;
    private TextView textNotif;
    private EditText textInsert;
    private Button addButton;

    private ArrayList<Item> items;

    private int errorColor = 0xFFA83232;
    private int okColor = 0xFF42AD52;
    private int white = 0xFFFFFFFF;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addViewModel =
                ViewModelProviders.of(this).get(AddViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add, container, false);


        addButton = (Button) root.findViewById(R.id.add_button);
        textInsert = (EditText) root.findViewById(R.id.text_insert);
        textNotif = (TextView) root.findViewById(R.id.notif_add);

        final RecyclerView rvItem = (RecyclerView) root.findViewById(R.id.rvItem);

        items = Item.itemList;

        final AddItemAdapter adapter = new AddItemAdapter(items);

        rvItem.setAdapter(adapter);

        rvItem.setLayoutManager(new LinearLayoutManager(root.getContext()));



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = textInsert.getText().toString();
                items.add(0, new Item(txt));
                adapter.notifyItemInserted(0);
                rvItem.scrollToPosition(0);

                textNotif.setBackgroundColor(okColor);
                textNotif.setTextColor(white);
                textNotif.setText("\nChoix ajouté avec succès");
            }
        });

        return root;
    }
}