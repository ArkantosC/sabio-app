package org.sabio.sabioapp.helpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diegocortes on 12/18/17.
 */

public final class RetrofitSingleton {

    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = getInstance("https://sabio-app.firebaseio.com/");
        }
        return retrofit;
    }

    private static Retrofit getInstance(String baseURL) {
        return new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
}
