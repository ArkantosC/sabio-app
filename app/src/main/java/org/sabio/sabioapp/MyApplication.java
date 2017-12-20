package org.sabio.sabioapp;

import android.app.Application;

import org.sabio.sabioapp.Utils.SharedPreferencesUtil;
import org.sabio.sabioapp.database.SabioDatabase;

/**
 * Created by diegocortes on 12/19/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SabioDatabase.init(getApplicationContext());
        SharedPreferencesUtil.init(getApplicationContext());
    }
}
