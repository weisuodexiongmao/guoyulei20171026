package com.bawei.guoyulei20171026;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by 猥琐的熊猫 on 2017/10/26.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        inint();
    }
      private void inint() {
              DisplayImageOptions options=new DisplayImageOptions.Builder()
                      .cacheOnDisk(true)
                      .cacheInMemory(true)
                      .build();

              ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                      .defaultDisplayImageOptions(options)
                      .threadPoolSize(3)
                      .threadPriority(100)
                      .memoryCacheExtraOptions(400,800)
                      .memoryCacheSize(2*1024*1024)
                      .diskCache(new UnlimitedDiskCache(new File(Environment.getExternalStorageDirectory(),"456a")))
                      .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                      .diskCacheSize(50*1024*1024)
                      .build();

              ImageLoader.getInstance().init(configuration);

          }
}
