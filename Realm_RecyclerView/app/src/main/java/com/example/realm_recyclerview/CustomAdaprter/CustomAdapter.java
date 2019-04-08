package com.example.realm_recyclerview.CustomAdaprter;

import android.content.Context;
import android.provider.Contacts;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.realm_recyclerview.R;

import java.util.ArrayList;

public class CustomAdapter  extends RecyclerView.Adapter<MyViewHolder> {
    private Context c;
    ArrayList<Contacts.People> people;

    public CustomAdapter(Context c, ArrayList<Contacts.People> people) {
        this.c = c;
        this.people = people;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(c).inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        Contacts.People p = people.get(i);
        holder.txtName.setText(p.getPeople_name());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
