package com.example.randompicker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.randompicker.ui.delete.DeleteFragment;

import java.util.List;

public class DeleteItemAdapter extends RecyclerView.Adapter<DeleteItemAdapter.ViewHolder> {

    private List<Item> mItems;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTextView;
        //public Button deleteButton;
        public ImageView deleteIcon;

        public ViewHolder(final View itemView) {
            super(itemView);

            itemTextView = (TextView) itemView.findViewById(R.id.item_name);
            deleteIcon = (ImageView) itemView.findViewById(R.id.delete_icon);

            deleteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(getAdapterPosition());
                }
            });
        }
    }

    public DeleteItemAdapter(List<Item> items) {
        mItems = items;
    }

    @Override
    public DeleteItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_pattern_delete, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DeleteItemAdapter.ViewHolder viewHolder, int position) {
        Item item = mItems.get(position);

        TextView textView = viewHolder.itemTextView;
        textView.setText(item.getItem());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private void deleteItem(int index) {
        mItems.remove(index);
        notifyItemRemoved(index);
    }
}
