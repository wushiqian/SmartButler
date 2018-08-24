package com.imooc.smartbutler.ui;
/*
 * 包名：SmartButler
 * 文件名： AboutActivity
 * 创建者：wushiqian
 * 创建时间 2018/8/24 下午1:33
 * 描述： TODO//
 */

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.imooc.smartbutler.R;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends BaseActivity {

    private ListView mListView;
    private List<String> mList = new ArrayList<>();
    private ArrayAdapter<String> mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //去除阴影
        getSupportActionBar().setElevation(0);

        initView();
    }

    //初始化View
    private void initView() {
        mListView = findViewById(R.id.mListView);

        mList.add(getString(R.string.text_app_name) + getString(R.string.app_name));
        mList.add(getString(R.string.text_website_address));

        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mList);
        //设置适配器
        mListView.setAdapter(mAdapter);
    }
}

