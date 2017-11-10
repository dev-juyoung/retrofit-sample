package com.dev_juyoung.retrofit_sample;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dev_juyoung.retrofit_sample.adapter.RepositoryAdapter;
import com.dev_juyoung.retrofit_sample.base.BaseActivity;
import com.dev_juyoung.retrofit_sample.data.GithubData;
import com.dev_juyoung.retrofit_sample.data.listener.SearchCallback;
import com.dev_juyoung.retrofit_sample.data.store.SearchInfo;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.repoList)
    RecyclerView repoList;

    private RepositoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mAdapter = new RepositoryAdapter(this);
        repoList.setHasFixedSize(true);
        repoList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        repoList.setAdapter(mAdapter);

        requestData(false);
    }

    private void requestData(final boolean isUpdate) {
        GithubData.getInstance().getRepositories(new SearchCallback() {
            @Override
            public void onSuccess(SearchInfo items) {
                if (!isUpdate) {
                    mAdapter.addItems(items.getRepositories());
                } else {
                    mAdapter.updateItems(items.getRepositories());
                }
            }

            @Override
            public void onFailure(String message) {
                Log.e(TAG, "failed: " + message);
            }
        });
    }
}
