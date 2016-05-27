package com.winjit.commons.Web;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.util.Map;

public class WebRequestHelper<T> extends com.android.volley.Request<T> {

    private int SOCKET_TIMEOUT_MS = 15000;
    private final WebResponseListener<T> webResponseListener;
    private Class<T> clazz;
    private Map<String, String> headers;
    private Map<String, String> params;
    private int TaskId;

    public interface WebResponseListener<T> extends Response.Listener<T>, Response.ErrorListener {
        void onWebRequestResponse(T response, int TaskId);
        void onWebRequestError(VolleyError error, int TaskId);
    }

    public WebRequestHelper(int method, String url, Map<String, String> headers, Map<String, String> params, WebResponseListener<T> webResponseListener, Class<T> clazz, int TaskId) {
        super(method, url, webResponseListener);
        this.headers = headers;
        this.params = params;
        this.webResponseListener = webResponseListener;
        this.clazz = clazz;
        this.TaskId = TaskId;

        //set retry policies
        setRetryPolicy(new DefaultRetryPolicy(
                SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new Gson().fromJson(jsonString,clazz), HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        webResponseListener.onWebRequestResponse(response, TaskId);
    }

    @Override
    public void deliverError(VolleyError error)
    {
        webResponseListener.onWebRequestError(error, TaskId);
    }
}