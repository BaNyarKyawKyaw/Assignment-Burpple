package com.example.hp.assignmentburpple.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hp.assignmentburpple.R;
import com.example.hp.assignmentburpple.adapters.BurppleGuideItemAdapter;
import com.example.hp.assignmentburpple.adapters.FoodsNewsImageAdapter;
import com.example.hp.assignmentburpple.adapters.PromotionItemAdapter;
import com.example.hp.assignmentburpple.components.PageIndicatorView;
import com.example.hp.assignmentburpple.components.SmartRecyclerView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_foods_news_images)
    ViewPager vpFoodNewsImages;

    @BindView(R.id.smv_promotion_items)
    SmartRecyclerView smvPromotionItems;

    @BindView(R.id.smv_burpple_guide_items)
    SmartRecyclerView smvBurppleGuideItems;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.piv_foods_news_image)
    PageIndicatorView pivFoodsNewsImage;

//    @BindView(R.id.btn_nav_view)
//    BottomNavigationView bottomNavigationView;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        final FoodsNewsImageAdapter foodsNewsImageAdapter = new FoodsNewsImageAdapter(getApplicationContext());
        vpFoodNewsImages.setAdapter(foodsNewsImageAdapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == foodsNewsImageAdapter.getCount()) {
                    currentPage = 0;
                }
                vpFoodNewsImages.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        pivFoodsNewsImage.setNumPage(foodsNewsImageAdapter.getCount());
        vpFoodNewsImages.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pivFoodsNewsImage.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        PromotionItemAdapter promotionItemAdapter = new PromotionItemAdapter(getApplicationContext());
        smvPromotionItems.setAdapter(promotionItemAdapter);
        LinearLayoutManager linearLayoutManagerPromotion = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        smvPromotionItems.setLayoutManager(linearLayoutManagerPromotion);

        BurppleGuideItemAdapter burppleGuideItemAdapter = new BurppleGuideItemAdapter(getApplicationContext());
        smvBurppleGuideItems.setAdapter(burppleGuideItemAdapter);
        LinearLayoutManager linearLayoutManagerGuide = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        smvBurppleGuideItems.setLayoutManager(linearLayoutManagerGuide);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
