package com.example.chenshuai20180514.net;

/**
 * Created by 不将就 on 2018/5/14.
 */

public interface OnNetListner<T> {
    void onSuccess(T t);
    void onFaile(Exception e);
}
