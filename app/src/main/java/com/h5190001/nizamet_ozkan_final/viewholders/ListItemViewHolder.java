package com.h5190001.nizamet_ozkan_final.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190001.nizamet_ozkan_final.R;

public class ListItemViewHolder extends RecyclerView.ViewHolder {
    ImageView imgHeader;
    TextView txtName;
    TextView txtRelasedate;
    TextView txtTags;

    public ListItemViewHolder(@NonNull View itemView, ListItemAdapter.OnItemClickListener listener) {
        super(itemView);

        imgHeader =itemView.findViewById(R.id.imgHeader);
        txtName =itemView.findViewById(R.id.txtName);
        txtRelasedate =itemView.findViewById(R.id.txtRelasedate);
        txtTags = itemView.findViewById(R.id.txtTags);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                listener.onClick(getAdapterPosition());
            }
        });
    }
}
