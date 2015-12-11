package com.example.mychat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.example.mychat.R;
import com.example.mychat.sys.Constant;
import com.example.mychat.utils.ManifestUtil;

/**
 * Created by wuyinlei on 2015/12/11.
 */
public class StartActivity extends BaseActivity {


    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        PushManager.startWork(this, PushConstants.LOGIN_TYPE_API_KEY, ManifestUtil.getMetaValue(this,"bd_api_key"));
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        mWebView.loadUrl(Constant.API.URL_START);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jump();
            }
        },3000);
    }

    /**
     * 跳转到HomeActivity
     */
    private void jump() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
