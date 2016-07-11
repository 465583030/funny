package com.example.crxc.funny.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.crxc.funny.R;
import com.example.crxc.funny.adapter.TabTitlePagerAdapter;
import com.example.crxc.funny.bean.Datum;
import com.example.crxc.funny.bean.GifDatum;
import com.example.crxc.funny.bean.JokeMode;
import com.example.crxc.funny.presenter.IJokePresenterImpl;
import com.example.crxc.funny.view.IJokeView;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import rx.Subscriber;

public class MainActivity<IJokePresenter> extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate,IJokeView{
    private static final String TAG = "MainActivity";
    private List<Datum> mDatas = new ArrayList<>();
    private List<GifDatum> mGifDatas = new ArrayList<>();
    private String[] titleArr;
    private android.support.v4.widget.DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private Subscriber<JokeMode> subscriber;
    private static String sKey = "f4f353724cc2afcf3c1c7bcafd86fdad";

    public String getKey() {
        return sKey;
    }



    public int getPage() {
        return sPage;
    }

    public  void setPage(int sPage) {
        MainActivity.sPage = sPage;
    }

    @Override
    public void clearData() {
        mDatas.clear();
    }

    public  int getPageSize() {
        return sPageSize;
    }

    @Override
    public List<GifDatum> getGifData() {
        return mGifDatas;
    }

    @Override
    public void clearGifData() {
        mGifDatas.clear();
    }

    public  void setPageSize(int sPageSize) {
        MainActivity.sPageSize = sPageSize;
    }

    private static int sPage=1;
    private static int sPageSize=8;
    private BGARefreshLayout mRefreshLayout;
    private IJokePresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter=new IJokePresenterImpl(this);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        titleArr = new String[]{getString(R.string.joke), getString(R.string.gif), getString(R.string.random_joke)};
        mPresenter.getJoke(1);
        mPresenter.getGif(1);
        initTabAndViewPager();
        initToolBar();
        initRefreshLayout();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_list_white);
        }
    }


    private void initTabAndViewPager() {
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        TabTitlePagerAdapter mTabTitleAdaptor = new TabTitlePagerAdapter(getSupportFragmentManager(), MainActivity.this, titleArr,mDatas,mGifDatas);
        mViewPager.setAdapter(mTabTitleAdaptor);
        if (mTabLayout!=null) {
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
            mTabLayout.setupWithViewPager(mViewPager);
        }
        for (int i = 0; i < titleArr.length; i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab!=null) {
                tab.setCustomView(mTabTitleAdaptor.getTabView(i));
            }
        }
    }



    public void updateViewPager() {
        mViewPager.getAdapter().notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        switch (mViewPager.getCurrentItem()){
            case 0:mPresenter.refreshJoke();break;
            case 1:mPresenter.refreshGif();break;
        }
    }



    public void endRefreshing() {
        Log.d(TAG, "endRefreshing: 结束刷新");
        mRefreshLayout.endRefreshing();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        switch (mViewPager.getCurrentItem()){
            case 0: mPresenter.loadData();break;
            case 1: mPresenter.loadGifData();break;
        }
        return true;
    }



    public void endLoadingMore() {
        mRefreshLayout.endLoadingMore();
    }

    @Override
    public List<Datum> getData() {
        return mDatas;
    }

    private void initRefreshLayout() {
        mRefreshLayout = (BGARefreshLayout) findViewById(R.id.rl_modulename_refresh);
        // 为BGARefreshLayout设置代理
        if (mRefreshLayout!=null) {
            mRefreshLayout.setDelegate(this);
        }
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this,true);
        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);


//        // 为了增加下拉刷新头部和加载更多的通用性，提供了以下可选配置选项  -------------START
//        // 设置正在加载更多时不显示加载更多控件
//        // mRefreshLayout.setIsShowLoadingMoreView(false);
//        // 设置正在加载更多时的文本
//        refreshViewHolder.setLoadingMoreText(getString(R.string.load_more));
//        // 设置整个加载更多控件的背景颜色资源id
//        refreshViewHolder.setLoadMoreBackgroundColorRes(R.color.colorAccent);
//        // 设置整个加载更多控件的背景drawable资源id
//        refreshViewHolder.setLoadMoreBackgroundDrawableRes(R.mipmap.ic_launcher);
//        // 设置下拉刷新控件的背景颜色资源id
//        refreshViewHolder.setRefreshViewBackgroundColorRes(R.color.colorPrimary);
//        // 设置下拉刷新控件的背景drawable资源id
//        refreshViewHolder.setRefreshViewBackgroundDrawableRes(R.mipmap.bga_refresh_loading01);
//        // 设置自定义头部视图（也可以不用设置）     参数1：自定义头部视图（例如广告位）， 参数2：上拉加载更多是否可用
//        mRefreshLayout.setCustomHeaderView(null, false);
//        // 可选配置  -------------END
    }
}




