package com.example.crxc.funny.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.crxc.funny.R;
import com.example.crxc.funny.bean.Datum;
import com.example.crxc.funny.bean.GifDatum;
import com.example.crxc.funny.ui.GifFragment;
import com.example.crxc.funny.ui.TabContextFragment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by crxc on 2016/7/8.
 */
public class TabTitlePagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;
    private String[] titleArr;
    private List<Datum> Datas;
    private List<GifDatum> GifDatas;
    public final static String  JokeData="JOKE_DATA";

    public TabTitlePagerAdapter(FragmentManager fm, Context context, String[] titleArr, List<Datum> mDatas, List<GifDatum> mGifDatas) {
        super(fm);
        mContext=context;
        this.titleArr=titleArr;
        Datas=mDatas;
        GifDatas=mGifDatas;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        switch (position){
            case 0: fragment=getJokeFragment();break;
            case 1: fragment=getGifFragment();break;
        }
        return fragment;
    }

    private Fragment getGifFragment() {
        GifFragment fragment = new GifFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable(JokeData, (Serializable) GifDatas);
        fragment.setArguments(bundle);
        return fragment;
    }

    private Fragment getJokeFragment() {
        TabContextFragment fragment = new TabContextFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable(JokeData, (Serializable) Datas);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return titleArr.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArr[position];
    }

    public View getTabView(int position) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.tab_layout,null);
        TextView textView = (TextView) view.findViewById(R.id.title_tv);
        textView.setText(titleArr[position]);
        return view;
    }
}