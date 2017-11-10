package com.dev_juyoung.retrofit_sample.adapter;

import com.dev_juyoung.retrofit_sample.data.store.Repository;

import java.util.ArrayList;

/**
 * Created by juyounglee on 2017. 11. 10..
 */

public class RepositoryContract {
    interface View {
        void updateView();
    }

    interface Model {
        void addItems(ArrayList<Repository> items);
        void updateItems(ArrayList<Repository> items);
    }
}
