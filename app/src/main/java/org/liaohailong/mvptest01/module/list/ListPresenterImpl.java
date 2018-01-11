package org.liaohailong.mvptest01.module.list;

import org.liaohailong.mvptest01.util.ColorHelper;
import org.liaohailong.mvptest01.base.BasePresenter;
import org.liaohailong.mvptest01.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe as : 列表数据控制
 * Created by LHL on 2018/1/9.
 */

public class ListPresenterImpl extends BasePresenter<ListContract.ListView> implements ListContract.ListPresenter {

    @Override
    public void getListData() {
        if (mHandler != null) {
            getView().onStartLoading();
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    List<Student> data = new ArrayList<>();
                    for (int i = 0; i < 15; i++) {
                        boolean isBoy = mRandom.nextBoolean();
                        int age = 13 + mRandom.nextInt(5);
                        int nextColor = ColorHelper.getNextColor(i);
                        Student student = new Student("学号:" + i, age, isBoy, nextColor);
                        data.add(student);
                    }
                    getView().onStopLoading();
                    getView().showList(data);
                }
            }, 5000);
        }
    }
}
