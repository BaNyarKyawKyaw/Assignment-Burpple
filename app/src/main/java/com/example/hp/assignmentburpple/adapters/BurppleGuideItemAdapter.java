package com.example.hp.assignmentburpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.assignmentburpple.R;
import com.example.hp.assignmentburpple.viewholders.BurppleGuideItemViewHolder;

/**
 * Created by HP on 1/12/2018.
 */

public class BurppleGuideItemAdapter extends RecyclerView.Adapter<BurppleGuideItemViewHolder> {

    private LayoutInflater mLayoutInflater;

    public BurppleGuideItemAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BurppleGuideItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_burpple_guide, parent, false);
        return new BurppleGuideItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BurppleGuideItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
