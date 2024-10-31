package com.example.home.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home.MainActivity;
import com.example.home.R;
import com.example.home.models.HomeChildModel;
import com.example.home.models.HomeParentAdapter;
import com.example.home.models.HomeParentModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<HomeParentModel> homeParentModelsArrayList;
    ArrayList<HomeChildModel> homeChildModelArrayList;
    ArrayList<HomeChildModel> newRelatedSong;
    ArrayList<HomeChildModel> popularGenre;
    ArrayList<HomeChildModel> popularArtist;
    ArrayList<HomeChildModel> popularAlbum;
    ArrayList<HomeChildModel> popularPlaylist;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_parent);
        homeChildModelArrayList = new ArrayList<>();
        popularGenre = new ArrayList<>();
        popularArtist = new ArrayList<>();
        popularAlbum = new ArrayList<>();
        popularPlaylist = new ArrayList<>();
        homeParentModelsArrayList = new ArrayList<>();

        HomeParentAdapter homeParentAdapter;

        //đoạn này là thêm các item vào recycleview của home, nên là phải có database
        popularPlaylist.add(new HomeChildModel(R.drawable.teuu, "Sontung"));
        popularPlaylist.add(new HomeChildModel(R.drawable.teuu, "Sontung"));
        popularPlaylist.add(new HomeChildModel(R.drawable.teuu, "Sontung"));
        popularPlaylist.add(new HomeChildModel(R.drawable.teuu, "Sontung"));
        popularPlaylist.add(new HomeChildModel(R.drawable.teuu, "Sontung"));
        popularPlaylist.add(new HomeChildModel(R.drawable.teuu, "Sontung"));

        homeParentModelsArrayList.add(new HomeParentModel("Related Songs", popularPlaylist));

        popularGenre.add(new HomeChildModel(R.drawable.teuu, "Jack"));
        popularGenre.add(new HomeChildModel(R.drawable.teuu, "Jack"));
        popularGenre.add(new HomeChildModel(R.drawable.teuu, "Jack"));
        popularGenre.add(new HomeChildModel(R.drawable.teuu, "Jack"));
        popularGenre.add(new HomeChildModel(R.drawable.teuu, "Jack"));
        popularGenre.add(new HomeChildModel(R.drawable.teuu, "Jack"));
        popularGenre.add(new HomeChildModel(R.drawable.teuu, "Jack"));


        homeParentModelsArrayList.add(new HomeParentModel("Popular Genre", popularGenre));

        homeParentAdapter = new HomeParentAdapter(homeParentModelsArrayList, requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(homeParentAdapter);
        homeParentAdapter.notifyDataSetChanged();

    }
}