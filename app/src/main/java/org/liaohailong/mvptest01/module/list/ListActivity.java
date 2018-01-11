package org.liaohailong.mvptest01.module.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import org.liaohailong.mvptest01.R;
import org.liaohailong.mvptest01.adapter.ListPagerAdapter;
import org.liaohailong.mvptest01.base.BaseActivity;
import org.liaohailong.mvptest01.model.Student;
import org.liaohailong.mvptest01.util.AttrHelper;
import org.liaohailong.mvptest01.util.ViewHelper;
import org.liaohailong.mvptest01.widget.PageTransformer.CoverFlowPageTransformer;

import java.util.List;

/**
 * Describe as : 列表界面
 * Created by LHL on 2018/1/9.
 */

public class ListActivity extends BaseActivity<ListPresenterImpl, ListContract.ListView> implements ListContract.ListView {
    public static void show(Context context) {
        Intent intent = new Intent(context, ListActivity.class);
        context.startActivity(intent);
    }

    private ViewPager mViewPager;
    private ListPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mViewPager = findViewById(R.id.view_pager);
        getPresenter().getListData();
    }

    private void showViewPager(List<Student> data) {
        if (mAdapter == null) {
            mAdapter = new ListPagerAdapter();
            mAdapter.setData(data);
            mViewPager.setOffscreenPageLimit(5);
//            int padding = AttrHelper.getWindowWidthPercent(0.4f);
//            mViewPager.setPadding(padding, 0, padding, 0);
            int width = AttrHelper.getWindowWidthPercent(0.2f);
            ViewHelper.setWidth(mViewPager, width);
            mViewPager.setPageTransformer(true, new CoverFlowPageTransformer());
            mViewPager.setAdapter(mAdapter);
        } else {
            mAdapter.setData(data);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showList(List<Student> data) {
        showViewPager(data);
    }
}
