package com.example.randompicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeleteItemAdapter extends RecyclerView.Adapter<DeleteItemAdapter.ViewHolder> {

    private List<Item> mItems;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTextView;
        public ImageView deleteIcon;

        public ViewHolder(final View itemView) {
            super(itemView);

            itemTextView = (TextView) itemView.findViewById(R.id.item_name);
            deleteIcon = (ImageView) itemView.findViewById(R.id.delete_icon);

            deleteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    System.out.println("position : "+position);

                    String name = Item.itemList.get(position).getItem();
                    System.out.println("name : "+name);

                    deleteItem(position);

                    MainActivity.bdd.deleteItem(name);

                    Toast.makeText(itemView.getContext(), "Choix supprimé avec succès", Toast.LENGTH_SHORT).show();
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
