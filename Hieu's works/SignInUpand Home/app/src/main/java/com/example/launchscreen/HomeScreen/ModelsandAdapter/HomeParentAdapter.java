package com.example.launchscreen.HomeScreen.ModelsandAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launchscreen.R;

import java.util.List;

public class HomeParentAdapter extends RecyclerView.Adapter<HomeParentAdapter.ViewHolder> {

    List<HomeParentModel> homeParentModelList;
    Context context;

    public HomeParentAdapter(List<HomeParentModel> homeParentModelList, Context context) {
        this.homeParentModelList = homeParentModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_parent_rv_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_parent_title.setText(homeParentModelList.get(position).Title);

        HomeChildAdapter homeChildAdapter;
        homeChildAdapter = new HomeChildAdapter(homeParentModelList.get(position).homeChildModelList,context);

        holder.rv_child.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
        holder.rv_child.setAdapter(homeChildAdapter);

        homeChildAdapter.notifyDataSetChanged();
        //setOnClick
    }

    @Override
    public int getItemCount() {
        return homeParentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RecyclerView rv_child;
        TextView tv_parent_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_child = itemView.findViewById(R.id.home_child_rv);
            tv_parent_title = itemView.findViewById(R.id.home_parent_tv_title);

        }
    }
}