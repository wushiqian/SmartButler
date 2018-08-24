package com.imooc.smartbutler.ui;
/*
 * 包名：SmartButler
 * 文件名： SettingActvity
 * 创建者：wushiqian
 * 创建时间 2018/8/18 下午11:54
 * 描述： TODO//
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.imooc.smartbutler.R;
import com.imooc.smartbutler.utils.L;
import com.imooc.smartbutler.utils.ShareUtils;

import static com.imooc.smartbutler.utils.ShareUtils.getBoolean;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    //语音播报
    private Switch sw_speak;

    //扫一扫
    private LinearLayout ll_scan;
    //扫描的结果
    private TextView tv_scan_result;
    //生成二维码
    private LinearLayout ll_qr_code;

    //关于软件
    private LinearLayout ll_about;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
    }

    //初始化View
    private void initView() {

        sw_speak = findViewById(R.id.sw_speak);
        sw_speak.setOnClickListener(this);

        boolean isSpeak = getBoolean(this, "isSpeak", false);
        sw_speak.setChecked(isSpeak);

        ll_scan = findViewById(R.id.ll_scan);
        ll_scan.setOnClickListener(this);

        tv_scan_result = findViewById(R.id.tv_scan_result);

        ll_qr_code = findViewById(R.id.ll_qr_code);
        ll_qr_code.setOnClickListener(this);

        ll_about = findViewById(R.id.ll_about);
        ll_about.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sw_speak:
                //切换相反
                sw_speak.setSelected(!sw_speak.isSelected());
                //保存状态
                ShareUtils.putBoolean(this, "isSpeak", sw_speak.isChecked());
                break;
            case R.id.ll_scan:
                L.i("ll_scan");
                //打开扫描界面扫描条形码或二维码
//                Intent openCameraIntent = new Intent(this, CaptureActivity.class);
//                startActivityForResult(openCameraIntent, 0);
                break;
            case R.id.ll_qr_code:
                startActivity(new Intent(this, QrCodeActivity.class));
                break;
            case R.id.ll_about:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            tv_scan_result.setText(scanResult);
        }
    }

}

