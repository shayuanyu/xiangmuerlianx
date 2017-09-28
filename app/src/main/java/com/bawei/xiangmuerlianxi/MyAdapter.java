package com.bawei.xiangmuerlianxi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

import static com.bawei.xiangmuerlianxi.R.id.iamge;

/**
 * Created by Administrator on 2017/9/26.
 */

public class MyAdapter extends BaseAdapter {
  private List<Bean.ResultBean.ChapterListBean> list;
    private Context context;
    private final DisplayImageOptions options;

    public MyAdapter(List<Bean.ResultBean.ChapterListBean> list, Context context) {
        this.list = list;
        this.context = context;
        options = new DisplayImageOptions.Builder()
                             .cacheInMemory(true)
                             .cacheOnDisk(true)
                             .showImageForEmptyUri(R.mipmap.ic_empty)
                             .showImageOnLoading(R.mipmap.loading)
                              .showImageOnFail(R.mipmap.ic_error)
                              .displayer(new RoundedBitmapDisplayer(30))
                              .build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      //使用listView完成此效果,数据自定义（代码、效果各10分）//listView进行优化（代码、效果各10分
        ViewHolder holder=null;
         if (convertView==null){
             convertView = convertView.inflate(context, R.layout.item, null);
             holder=new ViewHolder();
             holder.iamge=(ImageView) convertView.findViewById(iamge);
             holder.name=(TextView) convertView.findViewById(R.id.name);
             convertView.setTag(holder);
         }else{
             holder= (ViewHolder) convertView.getTag();
         }


        holder.name.setText(list.get(position).getName());
        ImageLoader.getInstance().displayImage("http://www.jhq8.cn/qqtouxiang/UploadPic/2012-9/201291016107737.jpg", holder.iamge, options);

        return convertView;
    }
  class ViewHolder{
         ImageView   iamge;
        TextView name;


    }
}
