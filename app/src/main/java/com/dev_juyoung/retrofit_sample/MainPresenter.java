package com.dev_juyoung.retrofit_sample;

/**
 * Created by juyounglee on 2017. 11. 10..
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        view = null;
    }
}
