package com.bawei.guoyulei20171026.Presenter;

import com.bawei.guoyulei20171026.Bean.Bean;
import com.bawei.guoyulei20171026.Modle.Modle;
import com.bawei.guoyulei20171026.View.View;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/10/26.
 */

public class Presenter {
    private View view;
    private Modle modle;
    public Presenter(View view) {
        this.view = view;
        this.modle=new Modle();
    }
    public void shuju(){
        modle.shuju(new Modle.Data() {
            @Override
            public void shuju(String s) {
                Gson gson=new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                List<Bean.SongListBean> song_list = bean.getSong_list();
                view.Success(song_list);
            }
        });
    }
}
