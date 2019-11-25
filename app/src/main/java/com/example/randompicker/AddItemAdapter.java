package com.example.randompicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddItemAdapter extends RecyclerView.Adapter<AddItemAdapter.ViewHolder> {

    private List<Item> mItems;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTextView;

        public ViewHolder(final View itemView) {
            super(itemView);

            itemTextView = (TextView) itemView.findViewById(R.id.item_name);
        }
    }

    public AddItemAdapter(List<Item> items) {
        mItems = items;
    }

    @Override
    public AddItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_pattern_add, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AddItemAdapter.ViewHolder viewHolder, int position) {
        Item item = mItems.get(position);

        TextView textView = viewHolder.itemTextView;
        textView.setText(item.getItem());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}
