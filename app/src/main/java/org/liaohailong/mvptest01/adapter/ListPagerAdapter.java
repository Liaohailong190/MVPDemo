package org.liaohailong.mvptest01.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import org.liaohailong.mvptest01.R;
import org.liaohailong.mvptest01.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe as : 列表师徒适配器
 * Created by LHL on 2018/1/9.
 */

public class ListPagerAdapter extends PagerAdapter {

    private List<Student> mData = new ArrayList<>();
    private SparseArray<View> mViews = new SparseArray<>();

    public void setData(List<Student> mData) {
        if (mData.isEmpty()) {
            return;
        }
        this.mData.clear();
        this.mData.addAll(mData);
        this.mViews.clear();
    }

    @Override
    public int getCount() {
//        return Integer.MAX_VALUE;
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int index = position % mData.size();
        Student student = mData.get(index);
        View view = mViews.get(index);
        StudentViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(container.getContext()).inflate(R.layout.layout_student_item, container, false);
            viewHolder = new StudentViewHolder(view);
            view.setTag(viewHolder);
            mViews.put(index, view);
        }
        viewHolder = (StudentViewHolder) view.getTag();
        student.bindView(viewHolder);
        //移除父容器方便复用
        ViewParent parent = view.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.removeView(view);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int index = position % mData.size();
        View view = mViews.get(index);
        if (view != null) {
            container.removeView(view);
        }
    }

    public static class StudentViewHolder {
        private View itemView;
        public ImageView avatar;
        public TextView name;

        private StudentViewHolder(View itemView) {
            this.itemView = itemView;
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
        }
    }
}
