package com.example.nttr.schedulebook;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by nttr on 2018/02/21.
 */

public class ScheduleBookApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
    }
}
