package com.bawei.guoyulei20171026;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.guoyulei20171026.Bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/10/26.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Bean.SongListBean> song_list;
    private Context context;

    public Adapter(List<Bean.SongListBean> song_list, Context context) {
        this.song_list = song_list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new VHitem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    VHitem vHitem= (VHitem) holder;
        vHitem.textView.setText(song_list.get(position).getTitle());
        vHitem.textView2.setText(song_list.get(position).getAlbum_title());
        ImageLoader.getInstance().displayImage(song_list.get(position).getPic_big(),vHitem.imageView);
    }

    @Override
    public int getItemCount() {
        return song_list.size();
    }
    class VHitem extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView,textView2;
        public VHitem(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
            textView= (TextView) itemView.findViewById(R.id.textView);
            textView2= (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
