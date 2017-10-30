package com.bawei.guoyulei20171026;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.guoyulei20171026.Bean.Bean;
import com.bawei.guoyulei20171026.Presenter.Presenter;
import com.bawei.guoyulei20171026.View.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View{

    private RecyclerView recyclerView;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Presenter presenter=new Presenter(this);
        presenter.shuju();
    }

    @Override
    public void Success(final List<Bean.SongListBean> song_list) {
     runOnUiThread(new Runnable() {
         @Override
         public void run() {
             adapter = new Adapter(song_list,MainActivity.this);
             recyclerView.setAdapter(adapter);
         }
     });
    }
}
