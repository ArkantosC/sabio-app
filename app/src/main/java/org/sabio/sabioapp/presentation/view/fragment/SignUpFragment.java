package org.sabio.sabioapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.helpers.Utilities;
import org.sabio.sabioapp.presentation.presenter.SignUpContract;
import org.sabio.sabioapp.presentation.presenter.SignUpPresenter;
import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends BaseFragment implements SignUpContract.View, View.OnClickListener {

    private SignUpContract.UserActionListener mActionListener;
    private TextInputLayout tilNameRegister;
    private TextInputLayout tilLastnameRegister;
    private TextInputLayout tilEmailRegister;
    private TextInputLayout tilPasswordRegister;
    private TextInputLayout tilTerminosCondiciones;
    private CheckBox cbTerminosCondicionaes;
    private Button btnCreateAccount;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment getInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_account, container, false);

        mActionListener = new SignUpPresenter(this);

        tilNameRegister = view.findViewById(R.id.tilNameRegister);
        tilLastnameRegister = view.findViewById(R.id.tilLastnameRegister);
        tilEmailRegister = view.findViewById(R.id.tilEmailRegister);
        tilPasswordRegister = view.findViewById(R.id.tilPasswordRegister);
        cbTerminosCondicionaes = view.findViewById(R.id.cbTerminosCondiciones);
        btnCreateAccount = view.findViewById(R.id.btnCreateAccount);
        tilTerminosCondiciones = view.findViewById(R.id.tilTerminosCondiciones);

        btnCreateAccount.setOnClickListener(this);

        return view;
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void goToLoginFragment() {
        String message =
                String.format(
                        "%s, tu cuenta fue creada!",
                        tilNameRegister.getEditText().getText().toString());

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        getFragmentManager().popBackStack();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateAccount:
                signUp();
                break;
        }
    }

    public void signUp() {

        Boolean result = true;
        String name = tilNameRegister.getEditText().getText().toString();
        String lastname = tilLastnameRegister.getEditText().getText().toString();
        String email = tilEmailRegister.getEditText().getText().toString();
        String password = tilPasswordRegister.getEditText().getText().toString();
        boolean agreementTerminos = cbTerminosCondicionaes.isChecked();

        if (Utilities.isEmpty(name)) {
            tilNameRegister.setError("Nombre es requerido");
            tilNameRegister.setErrorEnabled(true);
            result = false;
        } else {
            tilNameRegister.setError(null);
            tilNameRegister.setErrorEnabled(false);
        }

        if (Utilities.isEmpty(lastname)) {
            tilLastnameRegister.setError("Apellido es requerido");
            tilLastnameRegister.setErrorEnabled(true);
            result = false;
        } else {
            tilLastnameRegister.setError(null);
            tilLastnameRegister.setErrorEnabled(false);
        }

        if (Utilities.isEmpty(email)) {
            tilEmailRegister.setError("Email es requerido");
            tilEmailRegister.setErrorEnabled(true);
            result = false;
        } else {
            tilEmailRegister.setError(null);
            tilEmailRegister.setErrorEnabled(false);
        }

        if (Utilities.isEmpty(password)) {
            tilPasswordRegister.setError("Contraseña es requerida");
            tilPasswordRegister.setErrorEnabled(true);
            result = false;
        } else {
            tilPasswordRegister.setError(null);
            tilPasswordRegister.setErrorEnabled(false);
        }

        if (!agreementTerminos) {
            tilTerminosCondiciones.setError("Debe aceptar los términos y condiciones");
            tilTerminosCondiciones.setErrorEnabled(true);
            result = false;
        } else {
            tilTerminosCondiciones.setError(null);
            tilTerminosCondiciones.setErrorEnabled(false);
        }

        if (result) {
            mActionListener.signUp(name + lastname, email, password);
        }
    }
}
