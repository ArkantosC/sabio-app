package org.sabio.sabioapp;

import android.app.Application;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetUi;

import org.sabio.sabioapp.Utils.SharedPreferencesUtil;
import org.sabio.sabioapp.database.SabioDatabase;
import org.sabio.sabioapp.helpers.ThreadExecutor;

/**
 * Created by diegocortes on 12/19/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SabioDatabase.init(getApplicationContext());
        SharedPreferencesUtil.init(getApplicationContext());

        TwitterConfig config =
                new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(
                        new TwitterAuthConfig(
                                "e5a89c87BwViv7cGgqvPYTmte",
                                "oCNXvDnPkVVNOplOZOv8okvUocc2gUW1vLRi2M26aRVHmYERAq"))
                        .debug(true)
                        .build();

        Twitter.initialize(config);
    }
}

