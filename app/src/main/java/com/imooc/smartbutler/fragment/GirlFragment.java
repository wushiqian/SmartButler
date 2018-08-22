package com.imooc.smartbutler.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.imooc.smartbutler.R;
import com.imooc.smartbutler.adapter.GridAdapter;
import com.imooc.smartbutler.entity.GirlData;
import com.imooc.smartbutler.utils.L;
import com.imooc.smartbutler.view.CustomDialog;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

//import uk.co.senab.photoview.PhotoViewAttacher;

/*
 * 包名：SmartButler
 * 文件名： GirlFragment
 * 创建者：wushiqian
 * 创建时间 2018/8/18 下午11:18
 * 描述： TODO//
 */

public class GirlFragment extends Fragment {

    //列表
    private GridView mGridView;
    //数据
    private List<GirlData> mList = new ArrayList<>();
    //适配器
    private GridAdapter mAdapter;
    //提示框
    private CustomDialog dialog;
    //预览图片
    private ImageView iv_img;
    //图片地址的数据
    private List<String> mListUrl = new ArrayList<>();
    //PhotoView
    private PhotoViewAttacher mAttacher;

    /**
     * 1.监听点击事件
     * 2.提示框
     * 3.加载图片
     * 4.PhotoView
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girl, null);
        findView(view);
        return view;
    }

    //初始化View
    private void findView(View view) {
//        L.i("girl_test");
        mGridView = view.findViewById(R.id.mGridView);

        //初始化提示框
        dialog = new CustomDialog(getActivity(), LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, R.layout.dialog_girl,
                R.style.Theme_dialog, Gravity.CENTER, R.style.pop_anim_style);
        iv_img = dialog.findViewById(R.id.iv_img);

        String welfare = null;
        try {
            //Gank升級 需要转码
            welfare = URLEncoder.encode(getString(R.string.text_welfare), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //解析
        String uuu = "https://gank.io/api/random/data/%E7%A6%8F%E5%88%A9/20";
        L.i("test4" + uuu);
        RxVolley.get(uuu, new HttpCallback() {
            @Override
            public void onSuccess(String t) {
                L.i("Girl Json test:" + t);
                parsingJson(t);
            }
        });

        //监听点击事件
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //解析图片
//                PicassoUtils.loadImaheView(getActivity(), mListUrl.get(position), iv_img);
                Glide.with(getActivity()).load(mListUrl.get(position)).into(iv_img);
                //缩放
                mAttacher = new PhotoViewAttacher(iv_img);
                //刷新
                mAttacher.update();
                dialog.show();
            }
        });
    }

    //解析Json
    private void parsingJson(String t) {
        try {
            JSONObject jsonObject = new JSONObject(t);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = (JSONObject) jsonArray.get(i);
                String url = json.getString("url");
                mListUrl.add(url);

                GirlData data = new GirlData();
                data.setImgUrl(url);
                mList.add(data);
            }
            mAdapter = new GridAdapter(this.getActivity(), mList);
            //设置适配器
            mGridView.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
