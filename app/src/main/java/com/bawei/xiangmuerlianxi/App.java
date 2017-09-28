package com.bawei.xiangmuerlianxi;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2017/9/26.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(5)
                                         .threadPriority(100)
                                         .memoryCacheExtraOptions(200,200)
                                         .memoryCacheSize(2*1024*1024)

                                         .diskCacheSize(50*1024*1024)
                                         .diskCacheFileNameGenerator(new Md5FileNameGenerator())

                                         .build();

                                        ImageLoader.getInstance().init(configuration);
    }
}
