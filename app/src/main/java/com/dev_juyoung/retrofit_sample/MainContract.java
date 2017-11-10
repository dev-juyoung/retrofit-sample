package com.dev_juyoung.retrofit_sample;

import com.dev_juyoung.retrofit_sample.adapter.RepositoryContract;
import com.dev_juyoung.retrofit_sample.data.source.GithubRepository;

/**
 * Created by juyounglee on 2017. 11. 10..
 */

public interface MainContract {
    interface View {
        void showErrorMessage(String message);
    }

    interface Presenter {
        void setView(View view);
        void removeView();
        void setModel(GithubRepository model);
        void setAdapterView(RepositoryContract.View adapterView);
        void setAdapterModel(RepositoryContract.Model adapterModel);
        void requestData(boolean isUpdate);
    }
}
