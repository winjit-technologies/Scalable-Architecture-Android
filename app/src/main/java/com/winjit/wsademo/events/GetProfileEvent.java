package com.winjit.wsademo.events;

import com.android.volley.VolleyError;
import com.winjit.wsademo.entities.Profile;

public class GetProfileEvent {

    private Profile profile = null;
    private VolleyError error = null;

    public Profile getProfile() {
        return profile;
    }

    public GetProfileEvent(Profile profile) {
        this.profile = profile;
    }

    public GetProfileEvent(VolleyError error) {
        this.error = error;
    }

    public VolleyError getError() {
        return error;
    }
}
