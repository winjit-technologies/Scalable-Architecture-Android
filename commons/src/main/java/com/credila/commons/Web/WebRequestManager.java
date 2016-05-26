package com.credila.commons.Web;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;

import java.util.Map;

/**
 * Created by PrakashG on 05-04-2016.
 */
public class WebRequestManager implements WebRequestHelper.WebResponseListener {

    private WebProcessListener mWebProcessListener;
    private Map<String, String> mHeaders = null;

    public interface WebProcessListener {
        void onWebProcessSuccess(int taskID, Object object);
        void onWebProcessFailed(VolleyError error, int taskID);
    }

    public WebRequestManager(WebProcessListener webProcessListener) {
        mWebProcessListener = webProcessListener;
//        mHeaders = new HashMap<>();
//        mHeaders.put("Content-Type", "application/json");
    }

    public void makeRequest(RequestQueue requestQueue, int methodType, int taskId, String url, Map<String, String> params, Class clazz) {
        WebRequestHelper webRequest = new WebRequestHelper(methodType, url, mHeaders, params, WebRequestManager.this, clazz, taskId);
        requestQueue.add(webRequest);
    }

    @Override
    public void onWebRequestResponse(Object response, int taskId) {
        if (response != null) {
            mWebProcessListener.onWebProcessSuccess(taskId, response);
        }
    }

    @Override
    public void onWebRequestError(VolleyError error, int TaskId) {
        mWebProcessListener.onWebProcessFailed(error, TaskId);
    }

    @Override
    public void onResponse(Object response) { }

    @Override
    public void onErrorResponse(VolleyError error) { }

}