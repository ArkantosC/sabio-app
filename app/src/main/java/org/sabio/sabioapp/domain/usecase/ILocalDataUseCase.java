package org.sabio.sabioapp.domain.usecase;

/**
 * Created by diegocortes on 12/16/17.
 */

public interface ILocalDataUseCase {

    <T> boolean setData(String key, T value) throws Exception;
    <T> T getData(String key, Class<T> type) throws Exception;
    void clearAllData();
}
