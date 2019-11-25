package com.example.randompicker;

import java.util.ArrayList;

public class Item {

    public static ArrayList<Item> itemList = new ArrayList<>();

    private String item;

    public Item(String mItem) {
        item = mItem;
    }

    public String getItem() { return item; }


    public static ArrayList<Item> createItemList(int nb) {

        itemList = new ArrayList<>();

        for (int i = 1; i<nb+1; i++) {
            itemList.add(new Item("item " + i));
        }

        return itemList;
    }
}
