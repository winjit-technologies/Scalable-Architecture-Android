package com.winjit.wsademo.Tasks;

import com.android.volley.VolleyError;
import com.winjit.commons.Web.WebRequestManager;
import com.winjit.wsademo.WinjitApp;
import com.winjit.wsademo.constants.TaskConstants;
import com.winjit.wsademo.events.GetProfileEvent;
import com.winjit.wsademo.events.GetUsersEvent;
import com.winjit.wsademo.entities.Profile;

/**
 * Controller class used to control all web and database activities
 */
public class TasksController implements WebRequestManager.WebProcessListener {

    /**
     * Web api success listener
     * @param taskID : described for which task web api succeed
     * @param object : success object
     */
    @Override
    public void onWebProcessSuccess(int taskID, Object object) {

        switch (taskID) {

            case TaskConstants.WS_GET_PROFILE:
                Profile profile = (Profile) object;
                WinjitApp.getEventBus().post(new GetProfileEvent(profile));
                break;

            case TaskConstants.WS_GET_USERS:
                Profile users = (Profile) object;
                WinjitApp.getEventBus().post(new GetUsersEvent(users));
                break;
        }
    }

    /**
     * Web api failed listener
     * @param error : web api access error
     * @param taskID : described for which task web api failed
     */
    @Override
    public void onWebProcessFailed(VolleyError error, int taskID) {

        switch (taskID) {

            case TaskConstants.WS_GET_PROFILE:
                WinjitApp.getEventBus().post(new GetProfileEvent(error));
                break;

            case TaskConstants.WS_GET_USERS:
                WinjitApp.getEventBus().post(new GetUsersEvent(error));
                break;
        }
    }
}