package com.lmn.view.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lmn.MainDataManager;
import com.lmn.R;
import com.lmn.view.main.homefragment.MainHomeFragment;
import com.lmn.view.my.fragment.MyFragment;
import com.lmn.view.resources.ResourcesFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import lmn.com.lmnlibrary.base.BaseActivity;
import lmn.com.lmnlibrary.utils.SaveFileUtil;
import lmn.com.lmnlibrary.widget.bottomnavigation.BadgeItem;
import lmn.com.lmnlibrary.widget.bottomnavigation.BottomNavigationBar;
import lmn.com.lmnlibrary.widget.bottomnavigation.BottomNavigationItem;

@Route(path = "/main/activity")
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, MainContract.View {

    @Inject
    MainPresenter presenter;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.main_container)
    FrameLayout mainContainer;

    private MainHomeFragment mMainHomeFragment;
    private ResourcesFragment resourcesFragment;
    private MyFragment myFragment;
    private FragmentManager mFragmentManager;

    @Override
    public void initview() {
        SaveFileUtil.isGrantExternalRW(this);
        initBottomNavigation();
        mFragmentManager = getSupportFragmentManager();
        mMainHomeFragment = (MainHomeFragment) mFragmentManager.findFragmentByTag("home_fg");
        if (mMainHomeFragment == null) {
            mMainHomeFragment = MainHomeFragment.newInstance();
            addFragment(R.id.main_container, mMainHomeFragment, "home_fg");
        }
        resourcesFragment = (ResourcesFragment) mFragmentManager.findFragmentByTag("resources_fg");
        if (resourcesFragment == null) {
            resourcesFragment = ResourcesFragment.newInstance();
            addFragment(R.id.main_container, resourcesFragment, "resources_fg");
        }
        myFragment = (MyFragment) mFragmentManager.findFragmentByTag("my_fg");
        if (myFragment == null) {
            myFragment = MyFragment.newInstance();
            addFragment(R.id.main_container, myFragment, "my_fg");
        }
        mFragmentManager.beginTransaction().show(mMainHomeFragment).hide(resourcesFragment).hide(myFragment)
                .commitAllowingStateLoss();
        DaggerMainActivityComponent.builder()
                .appComponent(getAppComponent())
                .mainPresenterModule(new MainPresenterModule(this, MainDataManager.getInstance(mDataManager)))
                .build()
                .inject(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initBottomNavigation() {
        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorAccent)
                .setText("99+")
                .setHideOnSelect(false);

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        //bottomNavigationBar.setAutoHideEnabled(true);


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.axh, "").setInactiveIconResource(R.drawable.axg).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.resouce_1, "").setInactiveIconResource(R.drawable.resource_2).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.axj, "").setInactiveIconResource(R.drawable.axi).setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        if (position == 0) {
            mFragmentManager.beginTransaction().hide(resourcesFragment).hide(myFragment).show(mMainHomeFragment)
                    .commitAllowingStateLoss();
        } else if (position == 1) {
            mFragmentManager.beginTransaction().hide(mMainHomeFragment).hide(myFragment).show(resourcesFragment)
                    .commitAllowingStateLoss();
        } else if (position == 2) {
            mFragmentManager.beginTransaction().hide(resourcesFragment).hide(mMainHomeFragment).show(myFragment)
                    .commitAllowingStateLoss();
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        unbinder = ButterKnife.bind(this);

    }

    @Override
    public void setText(String text) {

    }

    @Override
    public void showProgressDialogView() {

    }

    @Override
    public void hiddenProgressDialogView() {

    }

    // 用来计算返回键的点击间隔时间
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                //弹出提示，可以有多种方式
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destory();
    }
}
