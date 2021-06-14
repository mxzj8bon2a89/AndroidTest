package com.example.cxc.recyclerview_316cxc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;//显示布局效果
    private MyAdapter myAdapter;
    private List<ArticleBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        //获取recyclerView 设置一些属性 获取数据源 绑定
    }

    //自定义 获取数据 并形成 list
    private List<ArticleBean> getData(){
        //定义一个list 赋值 返回
        return null;
    }
}
