package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.Utils.Constant;
import org.sabio.sabioapp.domain.usecase.ILocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LocalDataUseCase;
import org.sabio.sabioapp.presentation.view.activity.MainActivity;

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
            view.goToAuthActivity();
        } catch (Exception ex) {
            view.showMessageError(ex);
        }
    }
}
