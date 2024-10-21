package com.example.home.models;

import java.util.List;

public class HomeParentModel {

    String Title;
    List<HomeChildModel> homeChildModelList;

    public HomeParentModel(String title, List<HomeChildModel> homeChildModelList) {
        Title = title;
        this.homeChildModelList = homeChildModelList;
    }
}
