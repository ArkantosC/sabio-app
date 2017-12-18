package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by diegocortes on 12/17/17.
 */

public interface SignUpContract {

    interface View extends BaseView {
        void goToLoginFragment();
    }

    interface UserActionListener {
        void signUp(String fullName, String email, String password);
    }
}
