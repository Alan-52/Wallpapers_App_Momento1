package com.example.wallpaper_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper_app.Listeners.OnRecycleClickListener;
import com.example.wallpaper_app.Models.Photo;
import com.example.wallpaper_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CuratedAdapter extends RecyclerView.Adapter<CuratedViewHolder>{

    Context context;
    List<Photo> list;
    OnRecycleClickListener listener;

    public CuratedAdapter(Context context, List<Photo> list, OnRecycleClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CuratedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CuratedViewHolder(LayoutInflater.from(context).inflate(R.layout.home_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CuratedViewHolder holder, int position) {
        Picasso.get().load(list.get(position).getSrc().getMedium()).placeholder(R.drawable.place_holder).into(holder.imageView_list);
        holder.home_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class  CuratedViewHolder extends RecyclerView.ViewHolder {
    CardView home_list_container;
    ImageView imageView_list;
    public CuratedViewHolder(@NonNull View itemView) {
        super(itemView);
        home_list_container = itemView.findViewById(R.id.home_list_container);
        imageView_list = itemView.findViewById(R.id.imageView_list);

    }
}
