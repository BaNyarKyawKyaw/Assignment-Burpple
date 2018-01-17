package com.example.hp.assignmentburpple.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.assignmentburpple.R;

/**
 * Created by HP on 1/11/2018.
 */

public class FoodsNewsImageAdapter extends PagerAdapter {

    private LayoutInflater mLayoutInflater;

    public FoodsNewsImageAdapter(Context context){
        super();
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_foods_news, container, false);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
