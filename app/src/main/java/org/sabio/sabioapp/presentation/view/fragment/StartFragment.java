package org.sabio.sabioapp.presentation.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.presentation.presenter.StartContract;
import org.sabio.sabioapp.presentation.presenter.StartPresenter;
import org.sabio.sabioapp.presentation.view.activity.AuthActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends BaseFragment implements View.OnClickListener, StartContract.View {

    private StartContract.UserActionListener mActionListener;
    private LinearLayout llAskToSabio;
    private LinearLayout llSabioTrivia;
    private LinearLayout llNewsSabio;

    public StartFragment() {
        // Required empty public constructor
    }

    public static StartFragment getInstance() {
        return new StartFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        llAskToSabio = view.findViewById(R.id.llAskToSabio);
        llSabioTrivia = view.findViewById(R.id.llSabioTrivia);
        llNewsSabio = view.findViewById(R.id.llNewsSabio);

        llAskToSabio.setOnClickListener(this);
        llSabioTrivia.setOnClickListener(this);
        llNewsSabio.setOnClickListener(this);

        mActionListener = new StartPresenter(this);
        
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llAskToSabio:
                goToAskSabio();
                break;
            case R.id.llSabioTrivia:
                goToTrivia();
                break;
            case R.id.llNewsSabio:
                goToNews();
                break;
        }
    }

    public void replaceFragment(Fragment fragment, int contentViewerId, boolean addToBackStack) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(contentViewerId, fragment);
        if(addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG);
    }

    @Override
    public void goToAskSabio() {
        AskFragment fragment = AskFragment.getInstance();
        replaceFragment(fragment, R.id.main_activity, true);
    }

    @Override
    public void goToTrivia() {
        TriviaListFragment fragment = TriviaListFragment.getInstance();
        replaceFragment(fragment, R.id.main_activity, true);
    }

    @Override
    public void goToNews() {
        NewsFragment fragment = NewsFragment.getInstance();
        replaceFragment(fragment, R.id.main_activity, true);
    }
}
