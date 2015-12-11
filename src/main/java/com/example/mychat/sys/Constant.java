/*
*Contant.java
*Created on 2014-9-25 下午3:38 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.example.mychat.sys;

/**
 * Created by Ivan on 14-9-25.
 * Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
 * http://www.cniao5.com
 */
public class Constant {


    public static final int REQUEST_CODE=1000;
    public static final int RESULT_CODE=100;
    public static final int SUCCESS=1;
    public static final int FAIL=0;

    public static final String FLAG_AUTH="flag_auth";
    public static final String FRIEND="friend";
    public static final String MEMBER="member";
    public static final String WORD="word";
    public static final String MEMBER_ID="member_id";
    public static final String ACCESS_TOKEN="access_token";
    public static final String BD_USERID="bd_userid";
    public static final String BD_CHANNELID="bd_channelid";
    public static final String BD_API_KEY="bd_api_key";


    public static final String DB_NAME="jizha.db";
    public static final String IS_DATA_INIT="is_data_init_";


    public static final String ACTION_MSG="com.cniao5.jizha.ACTION_CHART";
    public static final String ACTION_CONTACT_UPDATE="com.cniao5.jizha.ACTION_CONTACT_UPDATE";
    public static final String ACTION_MAKE_FRIEND_REQUEST="com.cniao5.jizha.ACTION_MAKE_FRIEND_REQUEST";

    public static final String EXTRA_MSG="com.cniao5.jizha.CHART_MSG";


    public  static class  API{

//        public static final String URL_BASE="http://192.168.1.105:8080/pushserver/";
        public static final String URL_BASE="http://112.124.22.238:8081/pushserver/";
        public static final String URL_START=URL_BASE+"start_android.html";

        public static final String URL_LOGIN=URL_BASE+"login";
        public static final String URL_LOGIN_TOKEN=URL_BASE+"login/token";
        public static final String URL_FRIENDS=URL_BASE+"friend/my";
        public static final String URL_FRIEND_PROFILE=URL_BASE+"friend/profile";
        public static final String URL_FRIENDS_QUERY=URL_BASE+"friend/query";
        public static final String URL_FRIENDS_REQUEST=URL_BASE+"friend/request";

        public static final String URL_CHART_SEND=URL_BASE+"chart/friend/send";
        public static final String URL_FRIENDS_REQUEST_ANSWER=URL_BASE+"friend/request/answer";

    }
}
