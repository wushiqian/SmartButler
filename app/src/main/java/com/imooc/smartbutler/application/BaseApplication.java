package com.imooc.smartbutler.application;

import android.app.Application;

import com.imooc.smartbutler.utils.StaticClass;
import com.tencent.bugly.crashreport.CrashReport;

public class BaseApplication extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, true);
    }

}
