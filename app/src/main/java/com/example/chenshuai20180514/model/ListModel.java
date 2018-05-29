package com.example.chenshuai20180514.model;

import com.example.chenshuai20180514.bean.MyBean;
import com.example.chenshuai20180514.net.OnNetListner;
import com.example.chenshuai20180514.net.Retrofits;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by
 */

public class ListModel implements IListModel {
    @Override
    public void getList(String source, String appVersion, String page, final OnNetListner<MyBean> onNetListner) {
        Observable<MyBean> qq = Retrofits.getRetrofiterAPI().qq(source, appVersion, page);
        qq.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        onNetListner.onSuccess(myBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListner.onFaile((Exception) e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
