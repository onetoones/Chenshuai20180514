package com.example.chenshuai20180514.view;

import com.example.chenshuai20180514.bean.MyBean;

import java.util.List;

/**
 * Created by 不将就 on 2018/5/14.
 */

public interface Iview extends BaseView{
    void show(List<MyBean.DataBean> beans);
}
