package com.yanxing.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.yanxing.adapterlibrary.RecyclerViewAdapter;
import com.yanxing.base.BaseFragment;
import com.yanxing.util.RecycleViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * RecycleView上滑隐藏标题栏和底部导航栏View，下滑显示
 * Created by lishuangxiang on 2016/11/16.
 */

public class HideTitleBottomFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.top)
    LinearLayout mTop;

    @BindView(R.id.bottom)
    LinearLayout mBottom;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_hide_title_bottom;
    }

    @Override
    protected void afterInstanceView() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            strings.add(String.valueOf(i));
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter<String>(strings, R.layout.adapter_hide_title_bottom) {

            @Override
            public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, final int position) {
                holder.setText(R.id.text,mDataList.get(position));
            }
        };
        mRecyclerView.setAdapter(recyclerViewAdapter);
        RecycleViewUtil.startHideShowAnimation(mRecyclerView,mTop,mBottom);
    }
}
