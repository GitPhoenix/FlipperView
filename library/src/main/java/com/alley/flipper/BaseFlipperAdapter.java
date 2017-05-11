package com.alley.flipper;


import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

/**
 * 垂直轮播图控件数据适配器
 *
 * @author Phoenix
 * @date 2017/4/7 16:48
 */
public abstract class BaseFlipperAdapter<T> {
    protected LayoutInflater layoutInflater;
    protected List<T> bodyList;

    public BaseFlipperAdapter(Context context, List<T> list) {
        this.bodyList = list;
        layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 数据大小
     *
     * @return 数据大小
     */
    public int getCount() {
        return (bodyList == null) ? 0 : bodyList.size();
    }

    /**
     * item数据
     *
     * @param position
     * @return
     */
    public T getItem(int position) {
        return bodyList.get(position);
    }

    /**
     * item视图
     *
     * @param position item索引
     * @return item视图
     */
    public abstract View getInflaterView(int position);

    /**
     * 数据逻辑处理
     *
     * @param position item索引
     * @param body     item数据
     * @return item视图
     */
    public abstract View getView(int position, @Nullable View convertView, T body);
}
