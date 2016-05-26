package com.winjit.wsademo.events;

import com.android.volley.VolleyError;
import com.winjit.wsademo.entities.Profile;

public class GetUsersEvent {

    private Profile profile = null;
    private VolleyError error = null;

    public Profile getUsers() {
        return profile;
    }

    public GetUsersEvent(Profile profile) {
        this.profile = profile;
    }

    public GetUsersEvent(VolleyError error) {
        this.error = error;
    }

    public VolleyError getError() {
        return error;
    }
}
