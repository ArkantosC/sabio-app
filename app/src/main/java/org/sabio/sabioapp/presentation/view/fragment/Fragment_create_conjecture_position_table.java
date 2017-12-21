package org.sabio.sabioapp.presentation.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.presentation.presenter.BaseView;
import org.sabio.sabioapp.presentation.presenter.Fragment_create_Contract;


/**
 * Created by jhonlp on 19/12/2017.
 */

public class Fragment_create_conjecture_position_table implements Fragment_create_Contract.View {



        public Fragment_create_conjecture_position_table() {
            // Required empty public constructor
        }

        public static TriviaFragment getInstance () {
            return new TriviaFragment();
        }


        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_create_conjecture_position_table, container, false);
        }

    @Override
    public void showMessageError(Exception error) {

    }
}


