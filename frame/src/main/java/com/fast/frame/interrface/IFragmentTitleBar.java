package com.fast.frame.interrface;

import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * 说明：IFragmentTitleBar
 */
public interface IFragmentTitleBar {
    boolean isShowTitleBar();
    boolean isShowTitleBarBack();
    void setTitleBarText(String titleText);
    String bindTitleBarText();
    int bindTitleBarTextRes();
    int bindTitleBar();
    void onCustomToolBar(Toolbar toolbar);
    void onCustomTitleBar(View titlebar);

    // 自定义处理返回事件
    boolean isCustomCancelAction();
    // 自定义处理返回事件
    void onCancelButtonListener();

}