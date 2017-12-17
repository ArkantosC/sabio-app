package org.sabio.sabioapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by diegocortes on 12/17/17.
 */

public class SharedPreferencesUtil {

    private static Context context;
    private static SharedPreferences sp;

    public static void init(Context context) {
        SharedPreferencesUtil.context = context;
    }

    public static SharedPreferences getSharedPreferences() {
        if ( sp == null) {
            sp = context.getSharedPreferences(Constant.MY_SABIO_PREF, Context.MODE_PRIVATE);
        }
        return sp;
    }
}


