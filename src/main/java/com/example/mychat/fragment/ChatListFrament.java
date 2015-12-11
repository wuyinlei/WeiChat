/*
*ChartFrament.java
*Created on 2014-8-12 下午3:00 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.example.mychat.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mychat.R;
import com.example.mychat.widget.LoadingDialog;

/**
 * Created by Ivan on 14-8-12.
 * Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
 * http://www.cniao5.com
 */
public class ChatListFrament extends Fragment {

    private Button showDialog;
    private LoadingDialog mDialog;


    private RequestQueue mQueue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQueue = Volley.newRequestQueue(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment,container,false);
        showDialog = (Button) view.findViewById(R.id.showDialog);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQueue.add(getRequest());
            }
        });
        //第一步

        return view;
    }

    private StringRequest getRequest(){
        mDialog = new LoadingDialog(getContext());
        mDialog.setMessage("正在请求");
        mDialog.show();
        String url = "https://www.baidu.com";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d("ChatListFrament", s);
                mDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("ChatListFrament", volleyError.toString());
                mDialog.dismiss();
            }
        });

        return request;
    }

}
