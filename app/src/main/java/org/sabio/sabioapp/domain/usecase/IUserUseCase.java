package org.sabio.sabioapp.domain.usecase;

import org.sabio.sabioapp.domain.model.User;
import org.sabio.sabioapp.helpers.Callback;

/**
 * Created by diegocortes on 12/17/17.
 */

public interface IUserUseCase {

    void login(String email, String password, boolean remember, Callback<User> callback);

    void signUp(String fullName, String email, String password, Callback<User> callback);

    void recoveryPassword(String email, Callback<Boolean> callback);

    boolean isValidLoginAndPassword(String email, String password);

}
