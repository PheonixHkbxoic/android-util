package com.yanxing.ui.tablayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yanxing.base.BaseFragment;
import com.yanxing.ui.R;
import com.yanxing.util.LogUtil;

import butterknife.BindView;
import de.greenrobot.event.EventBus;

/**
 * Created by lishuangxiang on 2016/3/14.
 */
public class TabLayoutPager2Fragment extends BaseFragment {

    @BindView(R.id.text)
    TextView mTextView;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_tablayoutpager2;
    }

    @Override
    protected void afterInstanceView() {
        EventBus.getDefault().register(this);

    }

    public void onEvent(String content){
        mTextView.setText(content);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG,"TabLayoutPager2Fragment onDestroy");
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onAttach(Activity activity) {
        LogUtil.d(TAG,"TabLayoutPager2Fragment onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        LogUtil.d(TAG,"TabLayoutPager2Fragment onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LogUtil.d(TAG,"TabLayoutPager2Fragment onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        LogUtil.d(TAG,"TabLayoutPager2Fragment onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        LogUtil.d(TAG,"TabLayoutPager2Fragment onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        LogUtil.d(TAG,"TabLayoutPager2Fragment onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        LogUtil.d(TAG,"TabLayoutPager2Fragment onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        LogUtil.d(TAG,"TabLayoutPager2Fragment onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        LogUtil.d(TAG,"TabLayoutPager2Fragment setUserVisibleHint="+isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
    }
}
