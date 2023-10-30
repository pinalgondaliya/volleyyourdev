package com.pinal.volleyyourdevloperhere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    List<UserModel> userModels;
    Context context;


    public AdapterClass(List<UserModel> userModels, Context context) {
        this.userModels = userModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itam_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.albumId.setText(String.valueOf(userModels.get(position).albumId));
        holder.id.setText(String.valueOf(userModels.get(position).id));
        holder.title.setText(userModels.get(position).title);
        holder.url.setText(userModels.get(position).url);
        holder.thumbnail.setText(userModels.get(position).thumbnailUrl);

    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        TextView albumId,id,title,url,thumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumId = itemView.findViewById(R.id.albumId);
            id = itemView.findViewById(R.id.Id);
            title = itemView.findViewById(R.id.title);
            url = itemView.findViewById(R.id.url);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
