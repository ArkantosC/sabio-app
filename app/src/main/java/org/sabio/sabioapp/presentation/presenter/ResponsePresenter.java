package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by jhonlp on 21/12/2017.
 */

public class ResponsePresenter implements ResponseContract.UserActionListener {

    private ResponseContract.View view;

    public ResponsePresenter(ResponseContract.View view) {
        this.view = view;
    }
}
