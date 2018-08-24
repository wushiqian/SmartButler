package com.imooc.smartbutler.ui;
/*
 * 包名：SmartButler
 * 文件名： QrCodeActivity
 * 创建者：wushiqian
 * 创建时间 2018/8/24 下午2:00
 * 描述： TODO//
 */

import android.os.Bundle;
import android.widget.ImageView;

import com.imooc.smartbutler.R;

public class QrCodeActivity extends BaseActivity {

    //我的二维码
    private ImageView iv_qr_code;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        initView();
    }

    private void initView() {

        iv_qr_code = findViewById(R.id.iv_qr_code);
        //屏幕的宽
        int width = getResources().getDisplayMetrics().widthPixels;

//        Bitmap qrCodeBitmap = EncodingUtils.createQRCode("我是智能管家", width / 2, width / 2,
//                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
//        iv_qr_code.setImageBitmap(qrCodeBitmap);
    }
}
