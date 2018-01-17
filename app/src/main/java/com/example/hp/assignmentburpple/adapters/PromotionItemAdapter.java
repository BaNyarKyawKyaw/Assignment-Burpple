package com.example.hp.assignmentburpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.assignmentburpple.R;
import com.example.hp.assignmentburpple.viewholders.PromotionItemViewHolder;

/**
 * Created by HP on 1/12/2018.
 */

public class PromotionItemAdapter extends RecyclerView.Adapter<PromotionItemViewHolder> {

    private LayoutInflater mLayoutInflater;

    public PromotionItemAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public PromotionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_promotions, parent, false);
        return new PromotionItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PromotionItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
