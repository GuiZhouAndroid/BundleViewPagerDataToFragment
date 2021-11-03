package com.zs.itking.bundleviewpagerdatatofragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private final Bundle bundle1 = new Bundle();
    private final Bundle bundle2 = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        viewPager = findViewById(R.id.viewPager);
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        //1.设置MainActivity传递到ViewPager中Fragment的数据
        bundle1.putString("putData1", "我是MainActivity中的数据");
        bundle2.putString("putData2", "我是MainActivity中的数据");
        //2.适配ViewPager，准备填充Fragment数据，放进List集合
        List<Fragment> fragmentList = new ArrayList<>();
        //3.Bundle数据与Fragment对象绑定
        OneFragment oneFragment = (OneFragment) Fragment.instantiate(this, OneFragment.class.getName(),bundle1);
        TwoFragment twoFragment = (TwoFragment) Fragment.instantiate(this, TwoFragment.class.getName(),bundle2);
        //4.携带Bundle数据的Fragment放进数组里面
        Fragment[] fragments = new Fragment[]{oneFragment, twoFragment};
        //3.设置适配器，开始填充
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), fragments, fragmentList));
    }
}