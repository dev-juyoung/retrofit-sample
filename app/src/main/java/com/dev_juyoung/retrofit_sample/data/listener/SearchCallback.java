package com.dev_juyoung.retrofit_sample.data.listener;

import com.dev_juyoung.retrofit_sample.data.store.SearchInfo;

/**
 * Created by juyounglee on 2017. 11. 9..
 */

public interface SearchCallback {
    void onSuccess(SearchInfo items);
    void onFailure(String message);
}
