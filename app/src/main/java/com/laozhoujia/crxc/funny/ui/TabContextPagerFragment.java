package com.laozhoujia.crxc.funny.ui;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import android.widget.Toast;

import com.laozhoujia.crxc.funny.R;
import com.laozhoujia.crxc.funny.app.App;
import com.laozhoujia.crxc.funny.base.BasePagerFragment;
import com.laozhoujia.crxc.funny.bean.Datum;
import com.laozhoujia.crxc.funny.callBack.HomeAdapter;
import com.laozhoujia.crxc.funny.callBack.OnRecyclerItemClickListener;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by crxc on 2016/7/2.
 */
public class TabContextPagerFragment extends BasePagerFragment<Datum> {

    @Override
    protected void addOnItemTouchListener() {
        mRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(mRecyclerView) {
            @Override
            protected void onItemLongClick(HomeAdapter.MyViewHolder viewHolder) {

            }

            @Override
            protected void onItemDoubleClick(HomeAdapter.MyViewHolder viewHolder) {
                TextView textView=viewHolder.getView(R.id.list_text);
                ClipboardManager cm =(ClipboardManager)mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(textView.getText()+"");
                Toast.makeText(getContext(),getString(R.string.copy),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(HomeAdapter.MyViewHolder viewHolder) {

            }
        });
    }

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
    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
