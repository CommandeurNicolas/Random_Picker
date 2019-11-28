package com.example.randompicker.ui.delete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randompicker.DeleteItemAdapter;
import com.example.randompicker.Item;
import com.example.randompicker.R;

import java.util.ArrayList;

public class DeleteFragment extends Fragment {

    private ArrayList<Item> itemList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_delete, container, false);

        final RecyclerView rvItem = (RecyclerView) root.findViewById(R.id.rvItem);
        itemList = Item.itemList;
        final DeleteItemAdapter adapter = new DeleteItemAdapter(itemList);
        rvItem.setAdapter(adapter);
        rvItem.setLayoutManager(new GridLayoutManager(root.getContext(), 2));

        return root;
    }

}