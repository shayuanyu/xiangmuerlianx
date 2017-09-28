package com.bawei.xiangmuerlianxi;
/*
*    author jiahngyin
*    2017-09-26
*
*
* */
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.limxing.xlistview.view.XListView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener {
//导入XlistView依赖库到studio工程
    private XListView xlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
         xlist.setPullLoadEnable(true);
        xlist.setXListViewListener(this);
        getnewData();
    }
    private void getnewData(){
        getdata("http://japi.juhe.cn/comic/chapter?comicName=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85&key=8a80857da14f547d3d2597b50e876857");


    }
     private void getdata(String path){
             new AsyncTask<String, Void,String>(){

                 @Override
                 protected void onPostExecute(String s) {
                     super.onPostExecute(s);
                     if (s==null){
                         return;
                     }
                     Gson gson=new Gson();
                     Bean bean = gson.fromJson(s, Bean.class);
                     List<Bean.ResultBean.ChapterListBean> list = bean.getResult().getChapterList();
                     MyAdapter adapter=new MyAdapter(list,MainActivity.this);
                     xlist.setAdapter(adapter);
                 }

                 @Override
                 protected String doInBackground(String... params) {

                                        try {
                                            String param = params[0];
                                            URL uri=new URL(param);
                                            HttpURLConnection connection= (HttpURLConnection) uri.openConnection();
                                            connection.setRequestMethod("GET");
                                            connection.setConnectTimeout(5000);
                                            connection.setReadTimeout(5000);
                                            int code = connection.getResponseCode();
                                            if (code==200){
                                                InputStream is =  connection.getInputStream();
                                                String json = StreamToolas.readFrom(is);
                                               return  json;
                                            }

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }


                     return null;
                 }
             }.execute(path);






     }


    private void initView() {
        xlist = (XListView) findViewById(R.id.xlist);
    }

    @Override
    public void onRefresh() {
       getnewData();
        xlist.stopRefresh(true);
    }

    @Override
    public void onLoadMore() {
        getnewData();
        xlist.stopLoadMore();

    }
}
