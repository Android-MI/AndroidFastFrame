package com.fast.frame.interrface;

import androidx.fragment.app.FragmentManager;

/**
 * 说明：加载框
 */
public interface ILoadingDialog {
    ILoadingDialog setCancel(boolean isCancel);
    ILoadingDialog setText(String text);
    ILoadingDialog showDialog(FragmentManager manager);
    boolean getBindActivity();
    void dismissDialog();
}
