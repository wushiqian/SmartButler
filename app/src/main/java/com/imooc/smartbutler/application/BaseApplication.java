package com.imooc.smartbutler.application;

import android.app.Application;
import android.os.StrictMode;

import com.imooc.smartbutler.utils.StaticClass;
import com.tencent.bugly.crashreport.CrashReport;

import cn.bmob.v3.Bmob;

public class BaseApplication extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, true);
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
    }

}
