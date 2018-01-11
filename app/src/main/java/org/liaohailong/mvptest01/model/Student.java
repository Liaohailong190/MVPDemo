package org.liaohailong.mvptest01.model;

import android.graphics.Color;
import android.support.annotation.ColorInt;

import org.liaohailong.mvptest01.adapter.ListPagerAdapter;

/**
 * Describe as : 我是一个学生
 * Created by LHL on 2018/1/9.
 */

public class Student {
    public String name = "";
    public int age = 18;
    public boolean isBoy = true;
    @ColorInt
    public int color = Color.YELLOW;

    public Student(String name, int age, boolean isBoy, @ColorInt int color) {
        this.name = name;
        this.age = age;
        this.isBoy = isBoy;
        this.color = color;
    }

    public void bindView(ListPagerAdapter.StudentViewHolder holder) {
        if (holder.avatar != null) {
            holder.avatar.setBackgroundColor(color);
        }
        if (holder.name != null) {
            holder.name.setText(name);
        }
    }
}
