package com.h5190001.nizamet_ozkan_final.Adapters.ViewHolders;

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
    public ListItemViewHolder(@NonNull View itemView) {
        super(itemView);

        imgHeader =itemView.findViewById(R.id.imgHeader);
        txtName =itemView.findViewById(R.id.txtName);
        txtRelasedate =itemView.findViewById(R.id.txtRelasedate);
    }
}
