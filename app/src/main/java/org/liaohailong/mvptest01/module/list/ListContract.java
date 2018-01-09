package org.liaohailong.mvptest01.module.list;

import org.liaohailong.mvptest01.base.IView;
import org.liaohailong.mvptest01.model.Student;

import java.util.List;

/**
 * Describe as : 列表界面相关
 * Created by LHL on 2018/1/9.
 */

public interface ListContract {
    interface ListView extends IView {
        void showList(List<Student> data);
    }

    interface ListPresenter {
        void getListData();
    }
}
