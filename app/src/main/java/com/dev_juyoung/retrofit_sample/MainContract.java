package com.dev_juyoung.retrofit_sample;

/**
 * Created by juyounglee on 2017. 11. 10..
 */

public interface MainContract {
    interface View {

    }

    interface Presenter {
        void setView(View view);
        void removeView();
    }
}
