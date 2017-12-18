package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by diegocortes on 12/17/17.
 */

public interface LoginContract {

    interface View extends BaseView{
        void goToSignUpFragment();
        void goToRecoverPassword();
        void goToMainActivity();
        void showProgress();
        void hidePRogress();
        void showRememberedUser(String email);
    }

    interface UserActionListener {
        void onLogin(final String email, String password, final boolean remember);
        void configure();
    }
}
