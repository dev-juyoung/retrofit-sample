package com.dev_juyoung.retrofit_sample.data.source;

import com.dev_juyoung.retrofit_sample.data.source.remote.GithubRemoteDataSource;
import com.dev_juyoung.retrofit_sample.data.store.Repository;

import java.util.ArrayList;

/**
 * Created by juyounglee on 2017. 11. 10..
 */

public class GithubRepository implements GithubDataSource {
    private static GithubRepository instance;

    private GithubRemoteDataSource remoteDataSource;

    public static GithubRepository getInstance() {
        if (instance == null) {
            instance = new GithubRepository();
        }

        return instance;
    }

    public GithubRepository() {
        remoteDataSource = GithubRemoteDataSource.getInstance();
    }

    @Override
    public void searchData(final SearchDataCallback callback) {
        remoteDataSource.searchData(new SearchDataCallback() {
            @Override
            public void onSuccess(ArrayList<Repository> items) {
                callback.onSuccess(items);
            }

            @Override
            public void onFailure(String message) {
                callback.onFailure(message);
            }
        });
    }
}
