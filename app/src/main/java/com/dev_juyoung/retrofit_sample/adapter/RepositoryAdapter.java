package com.dev_juyoung.retrofit_sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dev_juyoung.retrofit_sample.R;
import com.dev_juyoung.retrofit_sample.base.BaseHolder;
import com.dev_juyoung.retrofit_sample.data.store.Repository;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by juyounglee on 2017. 11. 9..
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> implements RepositoryContract.View, RepositoryContract.Model {
    private static final String TAG = "RepositoryAdapter";

    private Context mContext;
    private ArrayList<Repository> items;

    public RepositoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void addItems(ArrayList<Repository> items) {
        Log.i(TAG, "AdapterModel: Presenter로 부터 데이터 추가 이벤트 전달.");

        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.addAll(items);
    }

    @Override
    public void updateItems(ArrayList<Repository> items) {
        Log.i(TAG, "AdapterModel: Presenter로 부터 데이터 갱신 이벤트 전달.");

        this.items = items;
    }

    @Override
    public void updateView() {
        Log.i(TAG, "AdapterView: Presenter로 부터 화면 갱신 이벤트 전달.");

        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseHolder {
        @BindView(R.id.ownerImageView)
        ImageView ownerImageView;
        @BindView(R.id.nameTextView)
        TextView nameTextView;
        @BindView(R.id.descTextView)
        TextView descTextView;
        @BindView(R.id.ownerNameTextView)
        TextView ownerNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repository item = items.get(position);

        Glide.with(mContext)
                .load(item.getOwnerInfo().getAvatarURL())
                .centerCrop()
                .into(holder.ownerImageView);

        holder.nameTextView.setText(item.getName());
        holder.descTextView.setText(item.getDescription());
        holder.ownerNameTextView.setText(item.getOwnerInfo().getOwnerName());
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
