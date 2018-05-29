package com.example.chenshuai20180514.presenter;

import com.example.chenshuai20180514.bean.MyBean;
import com.example.chenshuai20180514.model.IListModel;
import com.example.chenshuai20180514.model.ListModel;
import com.example.chenshuai20180514.net.OnNetListner;
import com.example.chenshuai20180514.view.Iview;

/**
 * Created by
 */

public class ListPresenter extends BasePresenter<Iview>{
    private IListModel model;
    private Iview activity;

    public ListPresenter() {
        model = new ListModel();
    }

    public void getat(String source, String appVersion, String page){
        activity = setView();
        model.getList(source, appVersion, page, new OnNetListner<MyBean>() {
            @Override
            public void onSuccess(MyBean myBean) {
                activity.show(myBean.getData());
            }

            @Override
            public void onFaile(Exception e) {
            }
        });
    }
}
