package com.bawei.guoyulei20171026.Modle;

import com.bawei.guoyulei20171026.Bean.Bean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 猥琐的熊猫 on 2017/10/26.
 */

public class Modle {
public void shuju(final Data data){
    OkHttpClient okHttpClient=new OkHttpClient();
    Request request=new Request.Builder().url("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0").build();
    Call call=okHttpClient.newCall(request);
    call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String string = response.body().string();
            data.shuju(string);
        }
    });
}
public interface Data{
    public void shuju(String s);
}
}
