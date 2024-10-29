package com.example.launchscreen.HomeScreen.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launchscreen.HomeScreen.Activities.SettingActivity;
import com.example.launchscreen.HomeScreen.HomeActivities;
import com.example.launchscreen.R;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.HomeChildModel;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.HomeParentAdapter;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.HomeParentModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    private TextView userName;

    private DatabaseReference hDatabase;
    private FirebaseAuth hAuth;

    ImageButton settingbtn;

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

        userName = view.findViewById(R.id.user_name);
        hDatabase = FirebaseDatabase.getInstance().getReference();
        hAuth = FirebaseAuth.getInstance();


        recyclerView = view.findViewById(R.id.rv_parent);
        homeChildModelArrayList = new ArrayList<>();
        popularGenre = new ArrayList<>();
        popularArtist = new ArrayList<>();
        popularAlbum = new ArrayList<>();
        popularPlaylist = new ArrayList<>();
        homeParentModelsArrayList = new ArrayList<>();

        HomeParentAdapter homeParentAdapter;

        settingbtn = view.findViewById(R.id.btn_home_setting);

        //Lay ten cua user dang dang nhap tu database
        FirebaseUser currentUser = hAuth.getCurrentUser();
        if (currentUser != null){
            String userID = currentUser.getUid();
            hDatabase.child("user").child(userID).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String name = snapshot.getValue(String.class);

                    if (name !=null){
                        userName.setText(name);
                    }
                    else{
                        userName.setText("cant get name.");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(requireContext(), "Loading name error", Toast.LENGTH_SHORT).show();
                }
            });
        }

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

        popularArtist.add(new HomeChildModel(R.drawable.teuu, "test"));

        //lay thu artist tu firebase


        homeParentModelsArrayList.add(new HomeParentModel("test", popularArtist));



        homeParentAdapter = new HomeParentAdapter(homeParentModelsArrayList, requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(homeParentAdapter);
        homeParentAdapter.notifyDataSetChanged();

        //nut setting
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireActivity(), SettingActivity.class));
            }
        });

    }
}