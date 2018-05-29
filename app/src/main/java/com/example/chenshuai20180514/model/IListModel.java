package com.example.chenshuai20180514.model;

import com.example.chenshuai20180514.bean.MyBean;
import com.example.chenshuai20180514.net.OnNetListner;

/**
 * Created by 不将就 on 2018/5/14.
 */

public interface IListModel {
    void getList(String source, String appVersion, String page, OnNetListner<MyBean> onNetListner);
}
