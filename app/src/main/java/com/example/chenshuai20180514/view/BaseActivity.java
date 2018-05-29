package com.example.chenshuai20180514.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Creation date
 * @name
 * @Class action
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
    }

    protected abstract void initView();

    //布局
    abstract int setLayout();
    //id
}