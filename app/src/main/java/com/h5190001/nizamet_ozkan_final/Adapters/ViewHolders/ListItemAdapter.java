package com.h5190001.nizamet_ozkan_final.Adapters.ViewHolders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190001.nizamet_ozkan_final.Models.ListItems;
import com.h5190001.nizamet_ozkan_final.R;
import com.h5190001.nizamet_ozkan_final.Utils.GlideUtil;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    List<ListItems> Items;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public ListItemAdapter(List<ListItems> Items, Context context, OnItemClickListener listener) {
        this.Items = Items;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview,parent,false);
        return new ListItemViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder viewHolder, int position) {

        viewHolder.txtName.setText(Items.get(position).getName());
        viewHolder.txtRelasedate.setText(Items.get(position).getRelaseDate());
        GlideUtil.downloadPicAndShow(context,Items.get(position).getLogo(),viewHolder.imgHeader);
        viewHolder.txtTags.setText(Items.get(position).getTags());

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }
}
