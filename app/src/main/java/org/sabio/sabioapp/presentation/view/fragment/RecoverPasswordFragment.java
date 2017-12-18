package org.sabio.sabioapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.helpers.Utilities;
import org.sabio.sabioapp.presentation.presenter.RecoverPasswordContract;
import org.sabio.sabioapp.presentation.presenter.RecoverPasswordPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecoverPasswordFragment extends Fragment implements RecoverPasswordContract.View, View.OnClickListener {

    private RecoverPasswordContract.UserActionListener mActionListener;
    private TextInputLayout tilEmailRecoverPassword;
    private Button btnSendEmail;

    public RecoverPasswordFragment() {
        // Required empty public constructor
    }

    public static RecoverPasswordFragment getInstance() {
        return new RecoverPasswordFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recover_password, container, false);

        mActionListener = new RecoverPasswordPresenter(this);

        tilEmailRecoverPassword = view.findViewById(R.id.tilEmailRecoverPassword);
        btnSendEmail = view.findViewById(R.id.btnSendEmail);

        btnSendEmail.setOnClickListener(this);

        return view;
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void gotToLoginFragment() {
        String message =
                String.format(
                        "Fue enviado un coreo a %s con las instrucciones para recuperar tu contraseña",
                        tilEmailRecoverPassword.getEditText().getText().toString()) ;

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        getFragmentManager().popBackStack();
    }

    void recoverPassword() {

        Boolean result = true;
        String email = tilEmailRecoverPassword.getEditText().getText().toString();

        if (Utilities.isEmpty(email)) {
            tilEmailRecoverPassword.setError("Email es requerido");
            tilEmailRecoverPassword.setErrorEnabled(true);
            result = false;
        } else {
            tilEmailRecoverPassword.setErrorEnabled(false);
        }

        if (result) {
            mActionListener.recoveryPassword(email);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSendEmail:
                recoverPassword();
                break;
        }
    }
}
