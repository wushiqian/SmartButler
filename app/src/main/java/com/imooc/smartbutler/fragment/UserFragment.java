package com.imooc.smartbutler.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.smartbutler.R;

/*
 * 包名：SmartButler
 * 文件名： UserFragment
 * 创建者：wushiqian
 * 创建时间 2018/8/18 下午11:18
 * 描述： TODO//
 */

public class UserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,null);
        return view;
    }

}
