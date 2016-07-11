package com.example.crxc.funny.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by crxc on 2016/7/3.
 */
public abstract class HomeAdapter<T> extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    public HomeAdapter(Context context, int layoutId, List<T> datas)
    {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  MyViewHolder.get(mContext,parent,mLayoutId);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder,mDatas.get(position));
    }

    protected abstract void convert(MyViewHolder holder, T t);


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

     public static class MyViewHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> mViews;
        private View mContentView;
        private Context mContext;
        public MyViewHolder(Context context,View itemView,ViewGroup parent){
            super(itemView);
            mContext=context;
            mContentView=itemView;
            mViews=new SparseArray<>();
        }
        public static MyViewHolder get(Context context,ViewGroup parent,int layoutId){
            View itemView= LayoutInflater.from(context).inflate(layoutId,parent,false);
            return new MyViewHolder(context,itemView,parent);
        }
        public <T extends View> T getView(int viewId){
            View view=mViews.get(viewId);
            if(view==null){
                view=mContentView.findViewById(viewId);
                mViews.put(viewId,view);
            }
            return (T) view;
        }

        public void updatePosition(int position) {

        }
    }
}