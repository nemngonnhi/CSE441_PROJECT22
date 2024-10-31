package com.example.launchscreen.HomeScreen.ModelsandAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.launchscreen.R;
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_child_rv_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_child_title.setText(homeChildModelList.get(position).title);

        Glide.with(context).load(homeChildModelList.get(position).image).into(holder.ivHomeChildItem);


        //setOnClick dưới này
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
    //chinh anh ve dang string
    private Bitmap decodeBase64ToImage(String base64String) {
        if (base64String == null || base64String.isEmpty()) return null;
        byte[] decodedBytes = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
}
