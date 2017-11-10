package com.dev_juyoung.retrofit_sample.data.source;

import com.dev_juyoung.retrofit_sample.data.store.Repository;

import java.util.ArrayList;

/**
 * Created by juyounglee on 2017. 11. 10..
 */

public interface GithubDataSource {
    interface SearchDataCallback {
        void onSuccess(ArrayList<Repository> items);
        void onFailure(String message);
    }

    void searchData(SearchDataCallback callback);
}
