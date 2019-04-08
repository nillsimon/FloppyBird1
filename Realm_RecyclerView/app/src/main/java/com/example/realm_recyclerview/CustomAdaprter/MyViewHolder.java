package com.example.realm_recyclerview.CustomAdaprter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.realm_recyclerview.R;

import butterknife.BindView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.edit_text)EditText txtName;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);


    }
}
