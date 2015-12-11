package com.example.mychat.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mychat.http.VolleyHttpClient;

/**
 * Created by wuyinlei on 2015/12/11.
 */
public class BaseActivity extends AppCompatActivity {

    public VolleyHttpClient mHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHttpClient = new VolleyHttpClient(getApplicationContext());
    }
}
