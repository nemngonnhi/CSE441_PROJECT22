package com.example.launchscreen.HomeScreen.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launchscreen.R;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.ExploreChildModel;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.ExploreParentAdapter;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.ExploreParentModel;

import java.util.ArrayList;

public class ExploreFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ExploreParentModel> exploreParentModelArrayList;
    ArrayList<ExploreChildModel> exploreChildModelArrayList;
    ArrayList<ExploreChildModel> TopGenre;
    ArrayList<ExploreChildModel> Browser;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.explore_parent_rv);
        exploreParentModelArrayList = new ArrayList<>();
        exploreChildModelArrayList = new ArrayList<>();
        TopGenre = new ArrayList<>();
        Browser = new ArrayList<>();

        ExploreParentAdapter exploreParentAdapter;

        //put item in recyclerview

        TopGenre.add(new ExploreChildModel(R.drawable.teuu, "kpop", "@color/white"));
        TopGenre.add(new ExploreChildModel(R.drawable.teuu, "Indie", "@color/titlecolor"));
        TopGenre.add(new ExploreChildModel(R.drawable.teuu, "RnB", "@color/black"));
        TopGenre.add(new ExploreChildModel(R.drawable.teuu, "Metal", "@color/white"));

        exploreParentModelArrayList.add(new ExploreParentModel("Your top genre", TopGenre));

        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Pop Fushion", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Country Music", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "HeavyNumetal", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));
        Browser.add(new ExploreChildModel(R.drawable.teuu, "Made for you", "@color/white"));

        exploreParentModelArrayList.add(new ExploreParentModel("Browse all", Browser));

        exploreParentAdapter = new ExploreParentAdapter(exploreParentModelArrayList, requireContext());
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),1));
        recyclerView.setAdapter(exploreParentAdapter);

        exploreParentAdapter.notifyDataSetChanged();
    }
}