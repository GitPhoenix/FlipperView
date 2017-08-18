package com.alley.flipperview.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.alley.flipper.BaseFlipperAdapter;
import com.alley.flipperview.R;

import java.util.List;

/**
 * 首页垂直轮播图适配器
 *
 * @author Phoenix
 * @date 2017/4/7 17:14
 */
public class FlipperAdapter extends BaseFlipperAdapter<String> {

    public FlipperAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public View getInflaterView(int position) {
        return layoutInflater.inflate(R.layout.view_vertical_flipper, null);
    }

    @Override
    public View getView(int position, View convertView, String body) {
        TextView textView = (TextView) convertView.findViewById(R.id.tv_vertical_flipper_content);
        textView.setText(body);
        return convertView;
    }
}
