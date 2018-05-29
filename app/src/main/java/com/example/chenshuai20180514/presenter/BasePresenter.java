package com.example.chenshuai20180514.presenter;

import com.example.chenshuai20180514.view.BaseView;

/**
 * @Creation date
 * @name
 * @Class action
 */

public  class BasePresenter<T extends BaseView> {
    T t;

    public void  BasePresenter(T t) {
        this.t=t;
    }
    public void onDestroys(){
        t=null;
    }
    public T setView(){
        return t;
    }
}
