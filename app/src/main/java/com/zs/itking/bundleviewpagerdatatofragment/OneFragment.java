package com.zs.itking.bundleviewpagerdatatofragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * created by on 2021/11/3
 * 描述：ViewPager中的Fragment，接收MainActivity传来的数据，进行展示
 *
 * @author ZSAndroid
 * @create 2021-11-03-12:54
 */

public class OneFragment extends Fragment {

    private TextView tv_show_data;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        initView(view);
        getData();
        return view;
    }

    /**
     * 初始化控件
     *
     * @param view
     */
    private void initView(View view) {
        tv_show_data = view.findViewById(R.id.tv_show_data);
    }

    /**
     * 获取Bundle传来的数据
     */
    private void getData() {
        Bundle bundle = getArguments();
        tv_show_data.setText("获取MainActivity的数据==="+bundle.getString("putData1"));
    }
}
