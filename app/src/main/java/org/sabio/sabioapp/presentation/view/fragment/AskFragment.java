package org.sabio.sabioapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.presentation.presenter.AskContract;
import org.sabio.sabioapp.presentation.presenter.AskPresenter;
import org.sabio.sabioapp.repository.ICountryRepository;
import org.sabio.sabioapp.repository.impl.CountryLocalRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AskFragment extends BaseFragment implements AskContract.View, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private AskContract.UserActionListener mActionListener;
    private Spinner spnCountry;
    private Spinner spnLeague;
    private Spinner spnTeam;
    private Button btnAsk;

    private String league;
    private String team;

    public AskFragment() {
        // Required empty public constructor
    }

    public static AskFragment getInstance() {
        return new AskFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ask, container, false);

        spnCountry = view.findViewById(R.id.spnCountry);
        spnLeague = view.findViewById(R.id.spnLeague);
        spnTeam = view.findViewById(R.id.spnTeam);
        btnAsk = view.findViewById(R.id.btnAsk);

        mActionListener = new AskPresenter(this);
        mActionListener.loadCountries();

        ArrayAdapter<Country> countryAdapter =
                new ArrayAdapter<Country>(
                        getContext(),
                        R.layout.support_simple_spinner_dropdown_item,
                        mActionListener.getCountries());

        countryAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spnCountry.setAdapter(countryAdapter);

        spnCountry.setOnItemSelectedListener(this);
        spnLeague.setOnItemSelectedListener(this);
        spnTeam.setOnItemSelectedListener(this);

        btnAsk.setOnClickListener(this);

        return view;
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
    public void goToResultTable() {

        ResponseFragment fragment = ResponseFragment.getInstance();
        fragment.setLeagueStr(league);
        fragment.setTeamStr(team);
        replaceFragment(fragment, R.id.main_activity, true);
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()) {
            case R.id.spnCountry:
                Country country = (Country) adapterView.getItemAtPosition(i);
                showLeagues(country.getCode());
                break;
            case R.id.spnLeague:
                League league = (League) adapterView.getItemAtPosition(i);
                this.league = league.getCode();
                showTeam(league.getCode());
                break;
            case R.id.spnTeam:
                Team team = (Team) adapterView.getItemAtPosition(i);
                this.team = team.getCode();
        }
    }

    private void showTeam(String code) {

        mActionListener.loadTeam(code);

        ArrayAdapter<Team> teamsAdapter =
                new ArrayAdapter<Team>(
                        getContext(),
                        R.layout.support_simple_spinner_dropdown_item,
                        mActionListener.getTeams());

        teamsAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spnTeam.setAdapter(teamsAdapter);
    }

    private void showLeagues(String code) {

        mActionListener.loadLeague(code);

        ArrayAdapter<League> leaguesAdapter =
                new ArrayAdapter<League>(
                        getContext(),
                        R.layout.support_simple_spinner_dropdown_item,
                        mActionListener.getLeagues());

        leaguesAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spnLeague.setAdapter(leaguesAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAsk:
                goToResultTable();
                break;
        }
    }
}
