package com.zs.itking.bundleviewpagerdatatofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Bundle bundle=new Bundle();
    private List<Fragment> fragmentList;
    private OneFragment oneFragment;
    public Fragment[] fragments = null;
    private TwoFragment twoFragment;

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
        viewPager= findViewById(R.id.viewPager);
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        //1.设置MainActivity传递到ViewPager中Fragment的数据
        bundle.putString("putData", "我是MainActivity中的数据");
        //2.适配ViewPager，准备填充Fragment数据，放进List集合
        fragmentList = new ArrayList<>();
        oneFragment = (OneFragment) Fragment.instantiate(this,OneFragment.class.getName(),bundle);
        twoFragment = (TwoFragment) Fragment.instantiate(this,TwoFragment.class.getName(),bundle);
        fragments = new Fragment[]{oneFragment,twoFragment};
        fragmentList.addAll(Arrays.asList(fragments));
        //fragments.add(twoFragment);
        //3.设置适配器，开始填充
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragmentList));
    }

}