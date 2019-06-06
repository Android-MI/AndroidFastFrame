package com.fast.frame;

import android.app.Application;

import com.fast.library.FastFrame;
import com.fast.library.http.HttpConfig;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FrameApp extends Application{

    private HttpConfig.Builder mHttpBuilder;

//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        FastFrame.init(this,setDebug());
        mHttpBuilder = setHttpBuilder();
        if (mHttpBuilder != null){
            mHttpBuilder.build().init();
        }
        FrameCrashHandler.getInstance().init();
    }

    protected HttpConfig.Builder setHttpBuilder(){
        HttpConfig.Builder builder = new HttpConfig.Builder();//配置HttpConfig
        builder.setDebug(setDebug());
        return builder;
    }

    protected boolean setDebug(){
        return true;
    }

    /**
     * 禁止弹窗（Detected problems with API compatibility弹窗）
     *
     * 说明：Android P 也就是android9.0 谷歌限制开发者调用非官方公开API方法或接口(使用@hide注解的系统源码)，
     * 当开发者用反射直接调用源码时就会出现上述提示框。
     */
    public void disableApiDialog() {

        try {
            Class clazz = Class.forName("android.app.ActivityThread");
            Method currentActivityThread = clazz.getDeclaredMethod("currentActivityThread");
            currentActivityThread.setAccessible(true);
            Object activityThread = currentActivityThread.invoke(null);
            Field mHiddenApiWarningShown = clazz.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}