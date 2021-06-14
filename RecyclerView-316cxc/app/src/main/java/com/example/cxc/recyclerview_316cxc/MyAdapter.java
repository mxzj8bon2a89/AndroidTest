package com.example.cxc.recyclerview_316cxc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Cxc on 2017/4/13.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;//上下文
    private LayoutInflater layoutInflater;//动态加载布局
    private List<ArticleBean> list;
    //自定义：构造方法传递上下文
    public MyAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    //自定义：获取数据
    public void setList(List<ArticleBean> list){
        this.list = list;
    }
    //自定义：viewHolder子类
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvtitle,tvdescrrpt,tvtime;
        private Button button;
        public Viewholder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            tvtitle = (TextView)itemView.findViewById(R.id.textView);
            tvtime = (TextView)itemView.findViewById(R.id.textView2);
            tvdescrrpt = (TextView)itemView.findViewById(R.id.textView3);
            button = (Button)itemView.findViewById(R.id.button);
        }
    }
    //重写 生成Item的View


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item,parent,false);
        return null;
    }
    //重写 给VieHolder中的控件填充值，设置监听


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position, List payloads) {
        ArticleBean articleBean = list.get(position);
        if(articleBean==null)
            return;
        Viewholder viewholder = (Viewholder)holder;
        viewholder.imageView.setImageResource(articleBean.getImgid());
        viewholder.tvtitle.setText(articleBean.getTitle());
        viewholder.tvdescrrpt.setText(articleBean.getDescription());
        viewholder.tvtime.setText(articleBean.getDescription());
        viewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();//更新RecyclerView
                //在实际案例中，要删除应该会涉及网络或者数据库访问
                //一般要有删除前的提醒
            }
        });
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取当前条目的信息 如id
                int id = list.get(position).getArticleId();
                Toast.makeText(context, ""+id,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override//共有多少条目
    public int getItemCount() {
        return list.size();
    }
}
