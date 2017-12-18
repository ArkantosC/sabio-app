package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.domain.model.User;
import org.sabio.sabioapp.domain.usecase.impl.UserUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.repository.IAuthRepository;

/**
 * Created by diegocortes on 12/17/17.
 */

public class SignUpPresenter implements SignUpContract.UserActionListener {

    private SignUpContract.View view;
    private UserUseCase userUseCase;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCase();
    }

    @Override
    public void signUp(String fullName, String email, String password) {
        userUseCase.signUp(fullName, email, password, new Callback<User>() {
            @Override
            public void success(User result) {
                view.goToLoginFragment();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }
}
