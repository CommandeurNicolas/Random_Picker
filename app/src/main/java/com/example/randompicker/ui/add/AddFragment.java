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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randompicker.AddItemAdapter;
import com.example.randompicker.Item;
import com.example.randompicker.MainActivity;
import com.example.randompicker.R;

import java.io.OutputStream;
import java.util.ArrayList;

public class AddFragment extends Fragment {

    private TextView textNotif;
    private EditText textInsert;
    private Button addButton;

    private ArrayList<Item> itemList;

    private OutputStream os;

    private boolean stop = false;

    private int errorColor = 0xFFA83232;
    private int okColor = 0xFF42AD52;
    private int white = 0xFFFFFFFF;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add, container, false);


        addButton = (Button) root.findViewById(R.id.add_button);
        textInsert = (EditText) root.findViewById(R.id.text_insert);
        textNotif = (TextView) root.findViewById(R.id.notif_add);

        final RecyclerView rvItem = (RecyclerView) root.findViewById(R.id.rvItem);

        itemList = Item.itemList;

        final AddItemAdapter adapter = new AddItemAdapter(itemList);

        rvItem.setAdapter(adapter);

        //rvItem.setLayoutManager(new LinearLayoutManager(root.getContext()));

        rvItem.setLayoutManager(new GridLayoutManager(root.getContext(), 2));



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = textInsert.getText().toString();

                for (int i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).getItem().equals(txt) || txt.isEmpty()) {
                        stop = true;
                    }
                }

                if (stop) {
                    textNotif.setBackgroundColor(errorColor);
                    textNotif.setTextColor(white);
                    if (txt.isEmpty()) {
                        textNotif.setText("\nErreur : Veuillez renseinger le champs ci-dessus\n");
                    }
                    else {
                        textNotif.setText("\nErreur : Choix déjà ajouté dans la liste\n");
                    }
                }
                else {
                    itemList.add(0, new Item(txt));
                    adapter.notifyItemInserted(0);
                    rvItem.scrollToPosition(0);

                    textNotif.setBackgroundColor(okColor);
                    textNotif.setTextColor(white);
                    textNotif.setText("\nChoix ajouté avec succès\n");

                    MainActivity.bdd.addData(txt);
                }
                stop = false;
            }
        });

        return root;
    }
}