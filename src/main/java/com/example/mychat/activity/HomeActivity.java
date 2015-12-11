package com.example.mychat.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.example.mychat.R;
import com.example.mychat.fragment.ChatListFrament;
import com.example.mychat.fragment.ContactFrament;
import com.example.mychat.fragment.MoreFragment;
import com.example.mychat.util.TabUtils;
import com.example.mychat.utils.ManifestUtil;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {


    private List<Tab> mTabs;
    private ActionBar mActionBar;
    private ViewPager mViewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushManager.startWork(getApplicationContext(),PushConstants.LOGIN_TYPE_API_KEY, ManifestUtil.getMetaValue(this,"bd_api_key"));


      /*  UmengUpdateAgent.setUpdateCheckConfig(false);

        UmengUpdateAgent.setUpdateOnlyWifi(false);
        UmengUpdateAgent.update(this);*/
        mViewPager = (ViewPager) this.findViewById(R.id.pager);

        initTabs();
        initActionBar();


    }


    /**
     * 初始化tab
     */
    private void initTabs() {
        mTabs = new ArrayList<Tab>(3);

        mTabs.add(new Tab(R.string.chart, ChatListFrament.class));
        mTabs.add(new Tab(R.string.contact, ContactFrament.class));
        mTabs.add(new Tab(R.string.more, MoreFragment.class));

    }


    /**
     * 初始化ActionBar
     */
    private void initActionBar() {

        mActionBar = getSupportActionBar();

        mActionBar.setDisplayHomeAsUpEnabled(false);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (Tab t : mTabs) {
            ActionBar.Tab tab = mActionBar.newTab();
            tab.setCustomView(TabUtils.renderTabView(this, t.getTxt(), 0));
            tab.setTabListener(this);
            mActionBar.addTab(tab);
        }


        mViewPager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(this);

        //TabUtils.updateTabBadge(mActionBar.getTabAt(0), 10);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }


    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {

        //设置当前要显示的View
        mViewPager.setCurrentItem(i);
        //选中对应的Tab
        mActionBar.selectTab(mActionBar.getTabAt(i));
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu_actionbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       /* if (item.getItemId() == R.id.menu_add_friend) {
            //startActivity(new Intent(this,FriendSearchActivity.class));
        }*/
        return super.onOptionsItemSelected(item);
    }


    public class Tab {

        public Tab() {
        }

        public Tab(int txt, Class fragment) {

            this.txt = txt;
            this.fragment = fragment;
        }


        private int txt;
        private Class fragment;


        public int getTxt() {
            return txt;
        }

        public void setTxt(int txt) {
            this.txt = txt;
        }

        public Class getFragment() {
            return fragment;
        }

        public void setFragment(Class fragment) {
            this.fragment = fragment;
        }
    }


    class TabFragmentPagerAdapter extends FragmentPagerAdapter {


        public TabFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            Fragment fragment = null;

            try {
                fragment = (Fragment) mTabs.get(i).getFragment().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }

    }
}
