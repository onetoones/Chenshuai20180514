package com.example.chenshuai20180514.view;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.chenshuai20180514.R;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn)
    BottomTabBar btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        BottomTabBar btn = findViewById(R.id.btn);
        btn.init(getSupportFragmentManager())
                .setImgSize(30, 30)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.BLACK)
                .addTabItem("推荐", R.mipmap.raw_1500083878, FragmentOne.class)
                .addTabItem("段子", R.mipmap.raw_1500085327, FragmentTwo.class)
                .addTabItem("发现", R.mipmap.ic_nav_class, FragmentThree.class)
                .addTabItem("视频", R.mipmap.raw_1500083686, FragmentFail.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    @Override
    int setLayout() {
        return R.layout.activity_main;
    }
}