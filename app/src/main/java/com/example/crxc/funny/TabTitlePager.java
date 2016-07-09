package com.example.crxc.funny;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by crxc on 2016/7/8.
 */
public class TabTitlePager extends FragmentPagerAdapter {


    private final Context mContext;
    private String[] titleArr;
    private List<Datum> Datas;
    public final static String  JokeData="JOKE_DATA";

    public TabTitlePager(FragmentManager fm, Context context, String[] titleArr, List mDatas) {
        super(fm);
        mContext=context;
        this.titleArr=titleArr;
        Datas=mDatas;
    }

    @Override
    public Fragment getItem(int position) {
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
        View view = mInflater.inflate(R.layout.tab_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.title_tv);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setImageResource(R.mipmap.ic_launcher);
        textView.setText(titleArr[position]);
        return view;
    }
}