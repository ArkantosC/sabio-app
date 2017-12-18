package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.Utils.Constant;
import org.sabio.sabioapp.Utils.SharedPreferencesUtil;
import org.sabio.sabioapp.domain.usecase.ILocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LocalDataUseCase;
import org.sabio.sabioapp.repository.ILocalDataRepository;

/**
 * Created by diegocortes on 12/17/17.
 */

public class AuthPresenter implements AuthContract.UserActionListener {

    private AuthContract.View view;
    private ILocalDataUseCase localDataUseCase;

    public AuthPresenter(AuthContract.View view) {
        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();
    }

    @Override
    public void goToFirstFragment() {
        try {;
            Boolean isAuth = localDataUseCase.getData(Constant.SHARED_PREF_IS_AUTH, Boolean.class);

            if (isAuth == null || !isAuth) {
                view.goToLoginFragment();
            } else {
                view.goToMainActivity();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
