package com.example.crxc.funny;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crxc on 2016/7/2.
 */
public class TabContextFragment extends Fragment {
    private static final String TAG = "TabContextFragment";
    private RecyclerView mRecyclerView;
    private List<Datum> mDatas=new ArrayList<>();
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mDatas= (List<Datum>) getArguments().getSerializable(TabTitlePager.JokeData);
        mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.icon_layout,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvToDoList);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));
        HomeAdapter adapter = new HomeAdapter(mContext, R.layout.list_layout, mDatas) {
            @Override
            protected void convert(MyViewHolder holder, Object o) {
                TextView textview = holder.getView(R.id.list_text);
                Datum data = (Datum) o;
                textview.setText(data.getContent());
                Log.e(TAG, "convert: 123");
            }
        };
        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
        return view;
    }
}
