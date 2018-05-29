package com.example.chenshuai20180514.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenshuai20180514.R;
import com.example.chenshuai20180514.adapter.ListAdapter;
import com.example.chenshuai20180514.bean.MyBean;
import com.example.chenshuai20180514.presenter.ListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by
 */

public class FragmentTwo extends BaseFragment<ListPresenter> implements Iview {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void initData() {

        Log.e( "initView: ", presenter+"");
        presenter.getat("android", "100", "1");
    }

    @Override
    ListPresenter getpresenter() {
        return new ListPresenter();
    }

    @Override
    int setXml() {
        return R.layout.two_layout;
    }

    @Override
    void initView() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void show(List<MyBean.DataBean> beans) {
        ListAdapter adapter = new ListAdapter(beans, getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
    }
}