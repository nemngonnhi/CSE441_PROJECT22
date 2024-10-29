package com.example.home.models;

import java.util.List;

public class ExploreParentModel {
    String title;
    List<ExploreChildModel> exploreChildModelList;

    public ExploreParentModel(String title, List<ExploreChildModel> exploreChildModelList) {
        this.title = title;
        this.exploreChildModelList = exploreChildModelList;
    }
}
