package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.domain.usecase.IUserUseCase;
import org.sabio.sabioapp.domain.usecase.impl.UserUseCase;
import org.sabio.sabioapp.helpers.Callback;

/**
 * Created by diegocortes on 12/18/17.
 */

public class RecoverPasswordPresenter implements RecoverPasswordContract.UserActionListener {

    private RecoverPasswordContract.View view;
    private IUserUseCase userUseCase;

    public RecoverPasswordPresenter(RecoverPasswordContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCase();
    }

    @Override
    public void recoveryPassword(String email) {
        userUseCase.recoveryPassword(email, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                view.gotToLoginFragment();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }
}
