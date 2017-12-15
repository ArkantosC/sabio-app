package org.sabio.sabioapp.repository;

import org.sabio.sabioapp.domain.model.User;
import org.sabio.sabioapp.helpers.Callback;

/**
 * Created by dcortez on 12/14/2017.
 */

public interface IAuthRepository {

    void login(String email, String password, final Callback callback);
    void signUp(final User user, final Callback callback);
    void recoverPassword(String email, final Callback callback);
}
