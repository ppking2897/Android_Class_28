package com.example.user.android_class_28;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<View> views;
    private ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPage);
        initViewPage();
    }
    private void initViewPage(){
        LayoutInflater view = LayoutInflater.from(this);


        View page0 = view.inflate(R.layout.page0,null);
        View page1 = view.inflate(R.layout.page1,null);
        View page2 = view.inflate(R.layout.page2,null);
        View page3 = view.inflate(R.layout.page3,null);
        View page4 = view.inflate(R.layout.page4,null);


        views = new ArrayList<>();

        views.add(page0);
        views.add(page1);
        views.add(page2);
        views.add(page3);
        views.add(page4);

        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setCurrentItem(1);

        MyPageChangeLisener mpcli = new MyPageChangeLisener();

        viewPager.setOnPageChangeListener(mpcli);

        flipper = (ViewFlipper) page2.findViewById(R.id.viewFlipper);
        View f0 = flipper.getChildAt(0);
        View f1 = flipper.getChildAt(1);
        View f2 = flipper.getChildAt(2);
        f0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });

    }
    private class MyPageChangeLisener extends ViewPager.SimpleOnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            if(position == 0){
                viewPager.setCurrentItem(1);
            }else if(position == 4){
                viewPager.setCurrentItem(3);
            }
        }

        @Override
        public void onPageSelected(int position) {
            //super.onPageSelected(position);

        }
    }

    private class MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            viewPager.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = views.get(position);
            viewPager.removeView(view);
            //super.destroyItem(container, position, object);
        }
    }
}
