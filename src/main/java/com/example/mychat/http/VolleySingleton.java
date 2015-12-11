/*
*VolleySingleton.java
*Created on 2014-9-25 上午10:29 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.example.mychat.http;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class VolleySingleton {



    private  static  VolleySingleton mInstance;


    private  RequestQueue mReuestQueue;

    public static synchronized VolleySingleton getInstance(Context context){
        if(mInstance == null){
            //这个地方不要和activity的context绑定，要和application的context绑定
            //这样的话就能在app不销毁的情况下一只运行了，要不然，只要这个activity销毁，就会失效
            mInstance = new VolleySingleton(context.getApplicationContext());
        }
        return mInstance;
    }



    private VolleySingleton(Context context){

        mReuestQueue = Volley.newRequestQueue(context);

    }


    public RequestQueue getRequestQueue(){

        return  this.mReuestQueue;
    }


   public <T> void addToRequestQueue(Request<T> req){

       getRequestQueue().add(req);
    }


   public void cancleRequest(Object tag){

       getRequestQueue().cancelAll(tag);
   }


}
