package com.example.abc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<constructorr> contact_array;
    public RecyclerContactAdapter(Context context, ArrayList<constructorr> contact_array){
        this.context = context;
        this.contact_array = contact_array;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.suhriftar_time, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(contact_array.get(position).datee);
        holder.ramadan.setText(contact_array.get(position).ramadann);
        holder.suhoor.setText(contact_array.get(position).suhoorr);
        holder.iftar.setText(contact_array.get(position).iftarr);

    }

    @Override
    public int getItemCount() {
        return contact_array.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date,ramadan,suhoor,iftar;

        public ViewHolder(View itemView){
            super(itemView);

            date = itemView.findViewById(R.id.date);
            ramadan = itemView.findViewById(R.id.ram);
            suhoor = itemView.findViewById(R.id.suhoor);
            iftar = itemView.findViewById(R.id.iftar);
        }

    }
}
