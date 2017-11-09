package com.dev_juyoung.retrofit_sample.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by juyounglee on 2017. 11. 9..
 */

public class SearchInfo {
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("incomplete_results")
    private boolean incompleteResults;
    @SerializedName("items")
    ArrayList<Repository> repositories;

    public int getTotalCount() {
        return totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public ArrayList<Repository> getRepositories() {
        return repositories;
    }
}
