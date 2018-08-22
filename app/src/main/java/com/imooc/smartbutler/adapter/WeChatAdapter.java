package com.imooc.smartbutler.adapter;
/*
 * 包名：SmartButler
 * 文件名： WeChatAdapter
 * 创建者：wushiqian
 * 创建时间 2018/8/21 下午12:48
 * 描述： TODO//
 */

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imooc.smartbutler.R;
import com.imooc.smartbutler.entity.WeChatData;
import com.imooc.smartbutler.utils.L;
//import com.imooc.smartbutler.utils.PicassoUtils;

import java.util.List;

public class WeChatAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater inflater;
    private List<WeChatData> mList;
    private WeChatData data;
    private int width,height;
    private WindowManager wm;

    public WeChatAdapter(Context mContext, List<WeChatData> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        L.i("Width:" + width + "Height:" + height);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.wechat_item, null);
            viewHolder.iv_img = convertView.findViewById(R.id.iv_img);
            viewHolder.tv_title = convertView.findViewById(R.id.tv_title);
            viewHolder.tv_source = convertView.findViewById(R.id.tv_source);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        data = mList.get(position);
        viewHolder.tv_title.setText(data.getTitle());
        viewHolder.tv_source.setText(data.getSource());
        L.i(viewHolder.iv_img.getContext() + "test3" + data.getImgUrl());
        if(!TextUtils.isEmpty(data.getImgUrl())){
            //加载图片
//            PicassoUtils.loadImageViewSize(mContext, data.getImgUrl(), width/3, 250, viewHolder.iv_img);
//            PicassoUtils.loadImageViewCrop(mContext,data.getImgUrl(),viewHolder.iv_img);
            Glide.with(viewHolder.iv_img.getContext()).load(data.getImgUrl()).into(viewHolder.iv_img);
        }
        return convertView;
    }

    class ViewHolder {
        private ImageView iv_img;
        private TextView tv_title;
        private TextView tv_source;
    }

}
