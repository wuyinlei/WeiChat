package com.example.mychat.message;

import android.content.Context;
import android.util.Log;

import com.baidu.android.pushservice.PushMessageReceiver;

import java.util.List;

/**
 * Created by wuyinlei on 2015/12/11.
 */
public class PushTestReceiver extends PushMessageReceiver {
    private static final String TAG = "PushTestReceiver";
    @Override
    public void onBind(final Context context, int errorCode, String appid,
                       String userId, String channelId, String requestId) {


        Log.d(TAG, "errorCode:" + errorCode + ", userid:" + userId + ", channelId:" + channelId + ", appid:" + appid);

    }

    @Override
    public void onUnbind(Context context, int i, String s) {

    }

    @Override
    public void onSetTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onDelTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onListTags(Context context, int i, List<String> list, String s) {

    }

    @Override
    public void onMessage(Context context, String s, String s1) {

    }

    @Override
    public void onNotificationClicked(Context context, String s, String s1, String s2) {

    }

    @Override
    public void onNotificationArrived(Context context, String s, String s1, String s2) {

    }
}
