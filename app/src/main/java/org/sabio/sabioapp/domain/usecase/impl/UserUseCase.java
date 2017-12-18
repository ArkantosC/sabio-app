package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.Utils.Constant;
import org.sabio.sabioapp.domain.model.User;
import org.sabio.sabioapp.domain.usecase.ILocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.IUserUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.repository.IAuthRepository;
import org.sabio.sabioapp.repository.impl.AuthFirebaseRepository;

/**
 * Created by diegocortes on 12/17/17.
 */

public class UserUseCase implements IUserUseCase {

    private IAuthRepository authRepository;
    private ILocalDataUseCase localDataUseCase;

    public UserUseCase() {
        this.authRepository = new AuthFirebaseRepository();
        this.localDataUseCase = new LocalDataUseCase();
    }

    @Override
    public void login(final String email, String password, final boolean remember, final Callback<User> callback) {
        authRepository.login(email, password, new Callback<User>() {
            @Override
            public void success(User user) {

                try {

                    if (user != null && remember) {
                        localDataUseCase.setData(Constant.SHARED_PREF_EMAIL, email);
                    }

                    localDataUseCase.setData(Constant.SHARED_PREF_IS_AUTH, true);
                    callback.success(user);

                } catch (Exception e) {
                    callback.error(e);
                }
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void signUp(String fullName, String email, String password, final Callback<User> callback) {

        User user = new User(fullName, email, password);
        authRepository.signUp(user, new Callback<User>() {
            @Override
            public void success(User user) {
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void recoveryPassword(String email, final Callback<Boolean> callback) {

        authRepository.recoverPassword(email, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                callback.success(true);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });

    }

    @Override
    public boolean isValidLoginAndPassword(String email, String password) {
        return false;
    }
}
