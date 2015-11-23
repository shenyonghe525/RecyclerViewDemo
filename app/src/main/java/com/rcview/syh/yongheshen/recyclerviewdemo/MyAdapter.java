package com.rcview.syh.yongheshen.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作者： yongheshen on 15/11/23.
 * 描述：
 */
class MyAdapter extends RecyclerView.Adapter
{

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    private ItemData[] datas = {new ItemData("LOL", "faker is god?"), new ItemData("LOL", "godv is dog?")};

    class ViewHolder extends RecyclerView.ViewHolder
    {

        private View root;

        private TextView tvTitle, tvContent;

        public ViewHolder(View root)
        {
            super(root);
            tvTitle = (TextView) root.findViewById(R.id.tvTitle);
            tvContent = (TextView) root.findViewById(R.id.tvContent);
        }

        public TextView getTvTitle()
        {
            return tvTitle;
        }

        public TextView getTvContent()
        {
            return tvContent;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position)
    {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.getTvTitle().setText(datas[position].getTitle());
        viewHolder.getTvContent().setText(datas[position].getContent());

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {

                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });

        }
    }

    @Override
    public int getItemCount()
    {
        return datas.length;
    }
}
