package com.fast.mvp.loader;

import com.fast.mvp.presenter.MvpPresenter;

/**
 * 说明：PresenterFactory
 * @author xiaomi
 */
@SuppressWarnings("unchecked")
public interface PresenterFactory<T extends MvpPresenter> {
    T create();
}
