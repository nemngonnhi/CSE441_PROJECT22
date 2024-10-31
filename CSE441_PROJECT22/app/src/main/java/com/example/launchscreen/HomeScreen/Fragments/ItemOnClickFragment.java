package com.example.launchscreen.HomeScreen.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.launchscreen.R;
import com.google.android.material.imageview.ShapeableImageView;

public class ItemOnClickFragment extends Fragment {


//    private static final String ARG_NAME = "name";
//    private static final String ARG_IMAGE_RES = "image_res_id";
//    //private static final String ARG_DESCRIPTION = "description";
//
//    private String name;
//    private int imageRes;
//    //private String description;
//
//    public static ItemOnClickFragment newInstance(String name, int imageRes) {
//        ItemOnClickFragment itemOnClickFragment = new ItemOnClickFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_NAME, name);
//        args.putInt(ARG_IMAGE_RES, imageRes);
//        //args.putString(ARG_DESCRIPTION, description);
//        itemOnClickFragment.setArguments(args);
//        return itemOnClickFragment;
//    }
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
////            name = getArguments().getString(ARG_NAME);
////            imageRes = getArguments().getInt(ARG_IMAGE_RES);
////            //description = getArguments().getString(ARG_DESCRIPTION);
////        }
////
////    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view =  inflater.inflate(R.layout.fragment_item_on_click, container, false);
//
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        TextView nameTextView = view.findViewById(R.id.item_onclick_name);
//        ShapeableImageView imageView = view.findViewById(R.id.item_onclick_img);
//        TextView descriptionTextView = view.findViewById(R.id.item_onclick_description);
//
//
//        if (getArguments() != null) {
//            name = getArguments().getString(ARG_NAME);
//            imageRes = getArguments().getInt(ARG_IMAGE_RES);
//            //description = getArguments().getString(ARG_DESCRIPTION);
//
//            nameTextView.setText(name);
//            imageView.setImageResource(imageRes);
//            //descriptionTextView.setText(description);
//        }
//
//    }
}