package org.sabio.sabioapp.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.Utils.SharedPreferencesUtil;
import org.sabio.sabioapp.presentation.presenter.AuthContract;
import org.sabio.sabioapp.presentation.presenter.AuthPresenter;
import org.sabio.sabioapp.presentation.view.fragment.LoginFragment;

public class AuthActivity extends AppCompatActivity implements AuthContract.View {

    private AuthContract.UserActionListener mActionListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.authToolbar);
        setSupportActionBar(toolbar);

        mActionListner = new AuthPresenter(this);
        mActionListner.goToFirstFragment();
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_auth, fragment);
        if(addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void goToLoginFragment() {
        replaceFragment(LoginFragment.getInstance(), false);
    }

    @Override
    public void goToMainActivity() {

        Intent intentMainActivity  = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
        finish();
    }

    @Override
    public void showMessageError(Exception error) {
        //TODO:Mostrar error.
    }
}
