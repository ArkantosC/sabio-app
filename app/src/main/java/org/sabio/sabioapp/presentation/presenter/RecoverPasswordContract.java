package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.helpers.Callback;

/**
 * Created by diegocortes on 12/18/17.
 */

public interface RecoverPasswordContract {

    interface View  extends BaseView{

        void gotToLoginFragment();
    }

    interface UserActionListener {

        void recoveryPassword(String email);

    }

}
