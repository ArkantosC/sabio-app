package org.sabio.sabioapp.repository.impl;

import android.content.SharedPreferences;
import android.util.Log;

import org.sabio.sabioapp.Utils.SharedPreferencesUtil;
import org.sabio.sabioapp.domain.usecase.impl.LocalDataUseCase;
import org.sabio.sabioapp.repository.ILocalDataRepository;

import java.util.Map;

/**
 * Created by diegocortes on 12/17/17.
 */

public class LocalDataRepository implements ILocalDataRepository {

    @Override
    public <T> boolean setData(String key, T value) throws Exception {
        SharedPreferences sharedPreferences = SharedPreferencesUtil.getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (value == null) {
            editor.remove(key);
        } else if(value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if(value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if(value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if(value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if(value instanceof String) {
            editor.putString(key, (String) value);
        }

        return editor.commit();
    }

    @Override
    public <T> T getData(String key, Class<T> type) throws Exception {
        SharedPreferences sharedPreferences = SharedPreferencesUtil.getSharedPreferences();
        Map<String, Object> preferences = (Map<String, Object>)sharedPreferences.getAll();
        Object value = preferences.get(key);

        try {
            if (value != null) {
                return type.cast(value);
            }
        }catch (RuntimeException rex) {
            Log.e(LocalDataRepository.class.toString(), rex.getMessage());
            throw new Exception(rex);
        }

        return null;
    }

    @Override
    public void clearAllData() {
        SharedPreferences sharedPreferences = SharedPreferencesUtil.getSharedPreferences();
        sharedPreferences.edit().clear().commit();
    }
}
