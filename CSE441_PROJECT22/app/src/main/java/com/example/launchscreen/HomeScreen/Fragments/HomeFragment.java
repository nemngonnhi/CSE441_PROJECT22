package com.example.launchscreen.HomeScreen.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launchscreen.HomeScreen.Activities.ItemOnClickActivity;
import com.example.launchscreen.HomeScreen.Activities.SettingActivity;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.HomeChildAdapter;
import com.example.launchscreen.R;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.HomeChildModel;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.HomeParentAdapter;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.HomeParentModel;
import com.example.launchscreen.items.ArtistModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements HomeParentAdapter.OnHomeChildClickListener {


    private TextView userName;

    private DatabaseReference hDatabase;
    private FirebaseAuth hAuth;

    ImageButton settingbtn;

    RecyclerView recyclerView;
    ArrayList<HomeParentModel> homeParentModelsArrayList;
    ArrayList<HomeChildModel> popularGenre;
    ArrayList<HomeChildModel> popularAlbum;
    ArrayList<HomeChildModel> popularArtist;

    //interface cho skien click
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userName = view.findViewById(R.id.user_name);
        //firebase
        hDatabase = FirebaseDatabase.getInstance().getReference();
        hAuth = FirebaseAuth.getInstance();

        recyclerView = view.findViewById(R.id.rv_parent);


        popularGenre = new ArrayList<>();
        popularAlbum = new ArrayList<>();
        popularArtist = new ArrayList<>();
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

        popularArtist.add(new HomeChildModel(R.drawable.rhymastic_img, "Rhymastic"));
        popularArtist.add(new HomeChildModel(R.drawable.chillies_img, "Chillies"));
        popularArtist.add(new HomeChildModel(R.drawable.sontung_img, "Son Tung M-TP"));
        popularArtist.add(new HomeChildModel(R.drawable.buctuong_img, "Buc Tuong"));
        popularArtist.add(new HomeChildModel(R.drawable.taylorswift_img, "Taylor Swift"));
        popularArtist.add(new HomeChildModel(R.drawable.vu_img, "Vu"));

        homeParentModelsArrayList.add(new HomeParentModel("Popular Artist", popularArtist));


        popularGenre.add(new HomeChildModel(R.drawable.pop_img, "Pop"));
        popularGenre.add(new HomeChildModel(R.drawable.rap_img, "Rap"));
        popularGenre.add(new HomeChildModel(R.drawable.podcast_img, "Podcast"));
        popularGenre.add(new HomeChildModel(R.drawable.usuk_img, "US-UK"));
        popularGenre.add(new HomeChildModel(R.drawable.metal_img, "Rock"));
        popularGenre.add(new HomeChildModel(R.drawable.indie_img, "Indie"));


        homeParentModelsArrayList.add(new HomeParentModel("Popular Genre", popularGenre));

        popularAlbum.add(new HomeChildModel(R.drawable.album1989_img, "1989"));
        popularAlbum.add(new HomeChildModel(R.drawable.reputation_img, "Reputation"));
        popularAlbum.add(new HomeChildModel(R.drawable.quakhungcuaso, "QuaKhungCuaSo"));

        homeParentModelsArrayList.add(new HomeParentModel("Popular Album", popularAlbum));


        homeParentAdapter = new HomeParentAdapter(homeParentModelsArrayList, requireActivity(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
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

    @Override
    public void onHomeChildClicked(HomeChildModel model) {
        Intent intent = new Intent(requireContext(), ItemOnClickActivity.class);
        intent.putExtra("title", model.getTitle());
        intent.putExtra("image", model.getImage());
        startActivity(intent);
    }
}
// homeParentAdapter.setOnItemClickListener(new HomeParentAdapter.OnItemClickListener() {
//    @Override
//    public void onItemClick(HomeChildModel childModel) {
//        ItemOnClickFragment fragment = ItemOnClickFragment.newInstance(childModel.getTitle(), childModel.getImage());
//        requireActivity().getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.main_view_pager, fragment)
//                .addToBackStack(null)
//                .commit();
//    }
//});