package com.winjit.wsademo.Tasks;

import com.android.volley.Request;
import com.winjit.commons.Web.WebRequestManager;
import com.winjit.wsademo.WinjitApp;
import com.winjit.wsademo.constants.TaskConstants;
import com.winjit.wsademo.entities.Profile;
import com.winjit.wsademo.constants.WebRequestConstants;

/**
 * Represent all tasks including web requests and database operations
 */
public class Task extends TasksController {

    public void getProfile() {
        new WebRequestManager(this).makeRequest(WinjitApp.getRequestQueue(), Request.Method.GET,
                TaskConstants.WS_GET_PROFILE,
                WebRequestConstants.END_POINT_PROFILE,
                null,
                Profile.class);
    }

    public void getUsers(int pageNo) {
        new WebRequestManager(this).makeRequest(WinjitApp.getRequestQueue(), Request.Method.GET,
                TaskConstants.WS_GET_USERS,
                "http://api.randomuser.me/?page=" + pageNo + "&results=10",
                null,
                Profile.class);
    }
}