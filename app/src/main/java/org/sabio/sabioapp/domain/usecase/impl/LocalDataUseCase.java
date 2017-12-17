package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.usecase.ILocalDataUseCase;
import org.sabio.sabioapp.repository.ILocalDataRepository;
import org.sabio.sabioapp.repository.impl.LocalDataRepository;

/**
 * Created by diegocortes on 12/16/17.
 */

public class LocalDataUseCase implements ILocalDataUseCase {

    private ILocalDataRepository localDataRepository;

    public LocalDataUseCase() {
        this.localDataRepository = new LocalDataRepository();
    }

    @Override
    public <T> boolean setData(String key, T value) throws Exception {
        return localDataRepository.setData(key, value);
    }

    @Override
    public <T> T getData(String key, Class<T> type) throws Exception {
        return localDataRepository.getData(key, type);
    }

    @Override
    public void clearAllData() {
        localDataRepository.clearAllData();
    }
}
