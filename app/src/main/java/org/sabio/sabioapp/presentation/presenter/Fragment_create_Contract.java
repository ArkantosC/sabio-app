package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by jhonlp on 19/12/2017.
 */

public interface Fragment_create_Contract {
    interface View extends BaseView{


    }

    interface UserActionListener {
        void onCreate(final String [] suposiciones , int tipoSuposicion, final boolean remember);

    }


}
