package org.sabio.sabioapp.presentation.presenter;

import android.util.Log;

import org.sabio.sabioapp.Utils.Constant;
import org.sabio.sabioapp.domain.model.User;
import org.sabio.sabioapp.domain.usecase.ILocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.impl.UserUseCase;
import org.sabio.sabioapp.helpers.Callback;

/**
 * Created by diegocortes on 12/17/17.
 */

public class LoginPresenter implements LoginContract.UserActionListener {

    private LoginContract.View view;
    private ILocalDataUseCase localDataUseCase;
    private UserUseCase userUseCase;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();
        this.userUseCase = new UserUseCase();
    }

    @Override
    public void onLogin(final String email, String password, final boolean remember) {
        view.showProgress();
        userUseCase.login(email, password, remember, new Callback<User>() {
            @Override
            public void success(User result) {
                view.hidePRogress();
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.hidePRogress();
                view.showMessageError(error);
            }
        });
    }

    @Override
    public void configure() {

        try {

            String email = localDataUseCase.getData(Constant.SHARED_PREF_EMAIL, String.class);
            if (email != null) {
                view.showRememberedUser(email);
            }
        }catch (Exception ex){
            view.showMessageError(ex);
        }
    }
}
