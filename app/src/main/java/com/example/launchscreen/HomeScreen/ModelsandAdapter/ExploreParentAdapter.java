package com.example.launchscreen.HomeScreen.ModelsandAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launchscreen.R;

import java.util.List;

public class ExploreParentAdapter extends RecyclerView.Adapter<ExploreParentAdapter.EPViewHolder>{

    List<ExploreParentModel> exploreParentModelList;
    Context context;

    public ExploreParentAdapter(List<ExploreParentModel> exploreParentModelList, Context context) {
        this.exploreParentModelList = exploreParentModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public EPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.explore_parent_rv_layout,null,false);
        return new EPViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EPViewHolder holder, int position) {
        holder.tv_parent_title.setText(exploreParentModelList.get(position).title);

        ExploreChildAdapter exploreChildAdapter;
        exploreChildAdapter = new ExploreChildAdapter(exploreParentModelList.get(position).exploreChildModelList,context);
        //test rang buoc

        //holder.rv_child.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
        //holder.rv_child.setLayoutManager(gridLayoutManager);
        holder.rv_child.setLayoutManager(new GridLayoutManager(context,2));
        holder.rv_child.setAdapter(exploreChildAdapter);

        exploreChildAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return exploreParentModelList.size();
    }

    public class EPViewHolder extends RecyclerView.ViewHolder{

        RecyclerView rv_child;
        TextView tv_parent_title;

        public EPViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_child = itemView.findViewById(R.id.explore_child_rv);
            tv_parent_title = itemView.findViewById(R.id.explore_parent_tv_title);
        }
    }

}
