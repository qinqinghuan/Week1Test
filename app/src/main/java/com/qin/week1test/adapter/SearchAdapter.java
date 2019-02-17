package com.qin.week1test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.qin.week1test.R;
import com.qin.week1test.bean.SearchBean;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    Context context;
    private List<SearchBean.ResultBean> searchBeans;

    public SearchAdapter(Context context, List<SearchBean.ResultBean> searchBeans) {
        this.context = context;
        this.searchBeans = searchBeans;
    }
    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view=View.inflate(context, R.layout.layout_recycler,null);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder viewHolder, int i) {
        viewHolder.textView1.setText(searchBeans.get(i).getCommodityName());
        viewHolder.textView2.setText("$:"+searchBeans.get(i).getPrice()+"元");
        RoundedCorners roundedCorners= new RoundedCorners(20);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options= RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        Glide.with(context).load(searchBeans.get(i).getMasterPic()).apply(options).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return searchBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.mProductImageView);
            textView1=itemView.findViewById(R.id.mProductName);
            textView2=itemView.findViewById(R.id.mProductPrice);
        }
    }
}
