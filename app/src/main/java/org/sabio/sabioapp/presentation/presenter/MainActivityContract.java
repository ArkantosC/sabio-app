package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by diegocortes on 12/16/17.
 */

public interface MainActivityContract {

    interface View extends BaseView {
        void goToAuthActivity();
    }

    interface UserActionListener {
        void exit();
    }

}
