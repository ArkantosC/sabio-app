package org.sabio.sabioapp.repository;

/**
 * Created by diegocortes on 12/17/17.
 */

public interface ILocalDataRepository {

    <T> boolean setData(String key, T value) throws Exception;
    <T> T getData(String key, Class<T> type) throws Exception;
    void clearAllData();

}
