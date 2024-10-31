package com.example.launchscreen.HomeScreen.ModelsandAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launchscreen.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class ExploreChildAdapter extends RecyclerView.Adapter<ExploreChildAdapter.ECViewHolder>{

    List<ExploreChildModel> exploreChildModelList;
    Context context;
    //int backGroundColor;

    public ExploreChildAdapter(List<ExploreChildModel> exploreChildModelList, Context context) {
        this.exploreChildModelList = exploreChildModelList;
        this.context = context;
        //this.backGroundColor = backGroundColor;
    }

    @NonNull
    @Override
    public ECViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.explore_child_rv_layout,null,false);
        return new ECViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ECViewHolder holder, int position) {

        holder.ivExploreChildItem.setImageResource(exploreChildModelList.get(position).image);
        holder.tvExploreChildItem.setText(exploreChildModelList.get(position).title);
        //doi mau
        //ExploreChildModel data = exploreChildModelList.get(position);
        //holder.cvExploreChildItem.setCardBackgroundColor(backGroundColor);

    }

    @Override
    public int getItemCount() {
        return exploreChildModelList.size();
    }
    public class ECViewHolder extends RecyclerView.ViewHolder{


        TextView tvExploreChildItem;
        ShapeableImageView ivExploreChildItem;
        CardView cvExploreChildItem;

        public ECViewHolder(@NonNull View itemView) {
            super(itemView);


            tvExploreChildItem = itemView.findViewById(R.id.tv_explore_child_title);
            ivExploreChildItem = itemView.findViewById(R.id.iv_explore_child_item);
            cvExploreChildItem = itemView.findViewById(R.id.cv_explore_child_item);
        }
    }
}
