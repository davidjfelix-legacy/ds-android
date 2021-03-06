package com.dinnersolutions.instameal.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.dinnersolutions.instameal.api.model.User;

/**
 * Created by Dejan Ristic on 1/19/16.
 */
public class AuthManager {

    private SharedPreferences prefs;

    public static final String BEARER_TOKEN = "bearer_token";

    public User activeUser;

    public AuthManager(Context context, SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public void saveBearerToken(String bearerToken) {
        String tokenString = "Bearer " + bearerToken;
        prefs.edit().putString(BEARER_TOKEN, tokenString).apply();
    }

    public String getBearerToken() {
        return prefs.getString(BEARER_TOKEN, "");
    }

    public void unauthenticateActiveUser() {
        activeUser = null;
        prefs.edit().remove(BEARER_TOKEN).apply();
    }

    public boolean isAuthenticated() {
        if (TextUtils.isEmpty(getBearerToken()) && activeUser == null) {
            return false;
        }
        return true;
    }

}
