package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by diegocortes on 12/17/17.
 */

public interface AuthContract {

    interface View extends BaseView {
        void goToLoginFragment();
        void goToMainActivity();
    }

    interface UserActionListener {
        void goToFirstFragment();
    }
}
