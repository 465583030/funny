package com.example.crxc.funny.ui;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.example.crxc.funny.R;
import com.example.crxc.funny.adapter.HomeAdapter;
import com.example.crxc.funny.base.BaseFragment;
import com.example.crxc.funny.base.BaseItemDecoration;
import com.example.crxc.funny.bean.Datum;

/**
 * Created by crxc on 2016/7/2.
 */
public class TabContextFragment extends BaseFragment<Datum> {

    @Override
    protected void setLayoutManager() {
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));
    }

    @Override
    protected void setAdapter() {
        adapter = new HomeAdapter<Datum>(mContext, R.layout.list_layout, mDatas) {
            @Override
            protected void convert(MyViewHolder holder, Datum data) {
                TextView textview = holder.getView(R.id.list_text);
                textview.setText(data.getContent());
            }
        };

        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.addItemDecoration(new BaseItemDecoration(mContext, BaseItemDecoration.VERTICAL_LIST));
    }
}
