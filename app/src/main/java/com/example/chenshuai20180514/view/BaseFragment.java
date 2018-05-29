package com.example.chenshuai20180514.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenshuai20180514.R;
import com.example.chenshuai20180514.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Creation date
 * @name
 * @Class action
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView{
    Unbinder unbinder;
    public T presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setXml(), null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        presenter = getpresenter();
        Log.e("this",this+"");
        if (presenter!=null){
            presenter.BasePresenter(this);
        }
        initData();
        return view;
    }

    protected abstract void initData();

    abstract T getpresenter();
    abstract int setXml();
    abstract  void initView();
}
