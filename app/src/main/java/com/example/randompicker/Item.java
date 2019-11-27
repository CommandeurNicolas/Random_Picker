package com.example.randompicker;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item {

    public static ArrayList<Item> itemList = new ArrayList<>();


    @SerializedName("item")
    private String item;

    public Item(String mItem) {
        item = mItem;
    }

    public String getItem() { return item; }


    public static ArrayList<Item> createItemList(int nb) {

        if (itemList.size() == 0) {
            itemList = new ArrayList<>();

            for (int i = 1; i<nb+1; i++) {
                itemList.add(new Item("item " + i));
            }
        }
        return itemList;
    }


    // FONCTION CREE POUR ESSAYER DE MAROUFLER LE SYSTEME
    public static boolean isInside(Item item) {

        boolean b = false;

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItem() == item.getItem()) {
                b = true;
            }
        }

        // NE PASSE PAS A TRUE : a corriger
        return b;
    }

}
