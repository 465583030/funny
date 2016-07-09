package com.example.crxc.funny;

import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableTypeRequest;
import com.example.crxc.funny.inter.JokeInter;
import com.example.crxc.funny.inter.JokeInterImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<Datum> mDatas = new ArrayList<Datum>();
    private String[] titleArr;
    private android.support.v4.widget.DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private Subscriber<JokeMode> subscriber;
    private String key = "f4f353724cc2afcf3c1c7bcafd86fdad";
    private int page=1;
    private int pageSize=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        titleArr = new String[]{getString(R.string.joke), getString(R.string.gif), getString(R.string.random_joke)};
        initData();
        initTabAndViewPager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_list_white);
        }
    }



    private void initTabAndViewPager() {
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
         mViewPager = (ViewPager) findViewById(R.id.viewPager);
        TabTitlePager mTabTitleAdaptor = new TabTitlePager(getSupportFragmentManager(), MainActivity.this, titleArr,mDatas);
        mViewPager.setAdapter(mTabTitleAdaptor);
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < titleArr.length; i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(mTabTitleAdaptor.getTabView(i));
        }
    }

    private void initData() {
        subscriber=new Subscriber<JokeMode>(){

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: 获取数据成功"+ mDatas.get(2).getContent());
                mViewPager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }

            @Override
            public void onNext(JokeMode jokeMode) {
                for(Datum data:jokeMode.getResult().getData()){
                    mDatas.add(data);
                }
            }
        };
        JokeInterImpl.getIntance().getJoke(subscriber,key,page,pageSize);
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
}




