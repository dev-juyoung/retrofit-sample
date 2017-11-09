package com.dev_juyoung.retrofit_sample;

import android.os.Bundle;
import android.util.Log;

import com.dev_juyoung.retrofit_sample.base.BaseActivity;
import com.dev_juyoung.retrofit_sample.data.GithubData;
import com.dev_juyoung.retrofit_sample.data.listener.SearchCallback;
import com.dev_juyoung.retrofit_sample.data.store.SearchInfo;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubData.getInstance().getRepositories(new SearchCallback() {
            @Override
            public void onSuccess(SearchInfo items) {
                Log.i(TAG, "success: " + items);
            }

            @Override
            public void onFailure(String message) {
                Log.e(TAG, "failed: " + message);
            }
        });
    }
}
