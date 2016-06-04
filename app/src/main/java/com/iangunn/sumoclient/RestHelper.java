package com.iangunn.sumoclient;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by iangunn on 6/4/16.
 */
public class RestHelper {
    private static AsyncHttpClient client = new AsyncHttpClient();


    private static final String BASE_URL = "http://sumo-1.dgysy8is32.us-west-2.elasticbeanstalk.com" +
            "/dashboards";


    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url),params, responseHandler);
    }

    //    public RequestHandle get(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {


    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }



}
