package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by diegocortes on 12/17/17.
 */

public interface StartContract {

    interface View extends BaseView {
        void goToAskSabio();
        void goToTrivia();
        void goToNews();
    }

    interface UserActionListener {

    }
}
