package com.alley.flipper;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;


/**
 * 垂直轮播图控件
 *
 * @author Phoenix
 * @date 2017/4/7 16:48
 */
public class AlleyFlipperView extends ViewFlipper implements ViewFlipper.OnClickListener {
    private BaseFlipperAdapter adapter;
    private OnFlipperViewItemClickListener listener;

    public AlleyFlipperView(Context context) {
        this(context, null);
    }

    public AlleyFlipperView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isFlipping()) {
            startFlipping();
        }
    }

    /**
     * 设置垂直轮播图，数据适配器
     *
     * @param adapter 适配器
     */
    public void setAdapter(BaseFlipperAdapter adapter) {
        this.adapter = adapter;
        if (adapter == null) {
            return;
        }
        for (int i = 0; i < adapter.getCount(); i++) {
            View view = adapter.getView(i, adapter.getInflaterView(i), adapter.getItem(i));
            view.setTag(i);
            addView(view);
            view.setOnClickListener(this);
        }

        if (!isFlipping()) {
            startFlipping();
        }
    }

    @Override
    public void onClick(View view) {
        if (listener != null && adapter != null) {
            listener.onItemClick((int) view.getTag(), adapter.getItem((int) view.getTag()));
        }
    }

    public interface OnFlipperViewItemClickListener {
        /**
         * 点击当前item
         *
         * @param position  item的index
         * @param body  item数据
         */
        void onItemClick(int position, @Nullable Object body);
    }

    /**
     * 对外开发的方法
     *
     * @param listener
     */
    public void setOnFlipperViewItemClickListener(OnFlipperViewItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isFlipping()) {
            stopFlipping();
        }
    }
}
