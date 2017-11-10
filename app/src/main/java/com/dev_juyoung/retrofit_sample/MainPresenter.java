package com.dev_juyoung.retrofit_sample;

import android.util.Log;

import com.dev_juyoung.retrofit_sample.adapter.RepositoryContract;
import com.dev_juyoung.retrofit_sample.data.source.GithubDataSource;
import com.dev_juyoung.retrofit_sample.data.source.GithubRepository;
import com.dev_juyoung.retrofit_sample.data.store.Repository;

import java.util.ArrayList;

/**
 * Created by juyounglee on 2017. 11. 10..
 */

public class MainPresenter implements MainContract.Presenter {
    private static final String TAG = "MainPresenter";

    private MainContract.View view;
    private RepositoryContract.View adapterView;
    private RepositoryContract.Model adapterModel;
    private GithubRepository model;

    @Override
    public void setView(MainContract.View view) {
        Log.i(TAG, "Presenter: 해당 Presenter에서 사용할 View 설정 이벤트 발생.");
        this.view = view;
    }

    @Override
    public void removeView() {
        Log.i(TAG, "Presenter: 해당 Presenter에서 사용된 View 해제 이벤트 발생.");
        view = null;
    }

    @Override
    public void setAdapterView(RepositoryContract.View adapterView) {
        Log.i(TAG, "Presenter: 해당 Presenter에서 사용할 AdapterView 설정 이벤트 발생.");
        this.adapterView = adapterView;
    }

    @Override
    public void setAdapterModel(RepositoryContract.Model adapterModel) {
        Log.i(TAG, "Presenter: 해당 Presenter에서 사용할 AdapterModel 설정 이벤트 발생.");
        this.adapterModel = adapterModel;
    }

    @Override
    public void setModel(GithubRepository model) {
        Log.i(TAG, "Presenter: 해당 Presenter에서 사용할 Model 설정 이벤트 발생.");
        this.model = model;
    }

    @Override
    public void requestData(final boolean isUpdate) {
        Log.i(TAG, "Presenter: 사용자로 부터 데이터 요청 이벤트 발생.");

        model.searchData(new GithubDataSource.SearchDataCallback() {
            @Override
            public void onSuccess(ArrayList<Repository> items) {
                // 업데이트 유무에 따른 AdapterModel에 이벤트 전달.
                if (!isUpdate) {
                    adapterModel.addItems(items);
                } else {
                    adapterModel.updateItems(items);
                }
            }

            @Override
            public void onFailure(String message) {
                // 통신 실패 시, View에 이벤트 전달.
                view.showErrorMessage(message);
            }
        });
    }
}
