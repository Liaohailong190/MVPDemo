package org.liaohailong.mvptest01.widget.PageTransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

import org.liaohailong.mvptest01.util.LogMan;

/**
 * 左右小，中间大
 * Created by LHL on 2017/10/17.
 */

public class CoverFlowPageTransformer implements ViewPager.PageTransformer {
    private static final String TAG = "CoverFlowPageTransformer";
    private static final float MAX_SCALE = 1.5f;
    private static final float MIN_SCALE = 1.275f;
    private static final float MIN_ALPHA = 0.6f;

    @Override
    public void transformPage(View view, float position) {
        float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
        LogMan.i(TAG, "scaleFactor = " + scaleFactor + "    position = " + position);
        if (position > 0) {
            view.setTranslationX(-scaleFactor);
        } else if (position < 0) {
            view.setTranslationX(scaleFactor);
        }
        view.setScaleY(scaleFactor);
        view.setScaleX(scaleFactor);
        // float alpha = 1f -  Math.abs(position) * (1 - );
        float alpha = MIN_ALPHA + (1 - MIN_ALPHA) * (1 - Math.abs(position));
        view.setAlpha(alpha);
    }
}
