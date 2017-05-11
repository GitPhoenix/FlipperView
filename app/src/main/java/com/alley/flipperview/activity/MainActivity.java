package com.alley.flipperview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alley.flipperview.R;
import com.alley.flipperview.adapter.FlipperAdapter;
import com.alley.flipper.AlleyFlipperView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlleyFlipperView viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setSubView();
        initEvent();
    }

    private void setSubView() {
        List<String> noticeContent = new ArrayList<>();
        noticeContent.add("通知公告内容、消息、仿京东、支付宝口碑人气商家等");
        noticeContent.add("支持各种布局样式，可定制多种布局样式的轮播效果");
        noticeContent.add("高扩展性，随心所欲，全应用通用");

        FlipperAdapter adapter = new FlipperAdapter(this, noticeContent);
        viewFlipper.setAdapter(adapter);
        viewFlipper.setFlipInterval(3 * 1000);
        viewFlipper.setInAnimation(this, R.anim.push_bottom_in);
        viewFlipper.setOutAnimation(this, R.anim.push_bottom_out);
    }

    private void initEvent() {
        viewFlipper.setOnFlipperViewItemClickListener(new AlleyFlipperView.OnFlipperViewItemClickListener() {
            @Override
            public void onItemClick(int position, Object body) {
                Log.i("main", "垂直轮播公告：" + body);
            }
        });
    }

    private void initView() {
        viewFlipper = (AlleyFlipperView) findViewById(R.id.AlleyFlipperView);
    }
}
