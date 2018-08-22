package com.imooc.smartbutler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.imooc.smartbutler.fragment.ButlerFragment;
import com.imooc.smartbutler.fragment.GirlFragment;
import com.imooc.smartbutler.fragment.UserFragment;
import com.imooc.smartbutler.fragment.WechatFragment;
import com.imooc.smartbutler.ui.SettingActivity;
import com.imooc.smartbutler.utils.L;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
     *UI
     */
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton fab_setting;

    public Context mContext;
    private List<String> mTitle;
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mContext = getApplicationContext();
        L.i(mContext + "test");
        mTitle = new ArrayList<>();
        mTitle.add("服务管家");
        mTitle.add("微信精选");
        mTitle.add("美女如云");
        mTitle.add("个人中心");

        mFragment = new ArrayList<Fragment>();
        mFragment.add(new ButlerFragment());
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlFragment());
        mFragment.add(new UserFragment());
    }

    private void initView() {
        fab_setting = findViewById(R.id.fab_setting);
        fab_setting.setOnClickListener(this);
        mTabLayout = findViewById(R.id.mTabLayout);
        mViewPager = findViewById(R.id.mViewPager);

        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());

        fab_setting.setVisibility(View.GONE);
        //滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    fab_setting.setVisibility(View.GONE);
                } else {
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_setting:
                startActivity(new Intent(this, SettingActivity.class));
        }
    }
}
