package com.example.home.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class HomeChildAdapter extends RecyclerView.Adapter<HomeChildAdapter.ViewHolder> {

    List<HomeChildModel> homeChildModelList;
    Context context;

    public HomeChildAdapter(List<HomeChildModel> homeChildModelList, Context context) {
        this.homeChildModelList = homeChildModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_child_rv_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeChildAdapter.ViewHolder holder, int position) {

        holder.ivHomeChildItem.setImageResource(homeChildModelList.get(position).image);
        holder.tv_child_title.setText(homeChildModelList.get(position).title);

        //setOnClick
    }

    @Override
    public int getItemCount() {
        return homeChildModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView ivHomeChildItem;
        TextView tv_child_title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeChildItem = itemView.findViewById(R.id.iv_home_child_item);
            tv_child_title = itemView.findViewById(R.id.tv_home_child_title);

        }
    }
}
