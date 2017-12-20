package org.sabio.sabioapp.presentation.presenter;

import android.util.Log;

import org.sabio.sabioapp.Utils.Constant;
import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.usecase.ICountryRestUseCase;
import org.sabio.sabioapp.domain.usecase.ILocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.impl.CountryRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LocalDataUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.presentation.view.activity.MainActivity;
import org.sabio.sabioapp.repository.ICountryRepository;
import org.sabio.sabioapp.repository.impl.CountryLocalRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/16/17.
 */

public class MainActivityPresenter implements  MainActivityContract.UserActionListener {

    private MainActivityContract.View view;
    private ILocalDataUseCase localDataUseCase;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();
    }


    @Override
    public void exit() {
        try {
            localDataUseCase.setData(Constant.SHARED_PREF_IS_AUTH, false);
            localDataUseCase.setData(Constant.SETUP_DATA, false);
            view.goToAuthActivity();
        } catch (Exception ex) {
            view.showMessageError(ex);
        }
    }
}
