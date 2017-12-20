package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.IAskUseCase;
import org.sabio.sabioapp.domain.usecase.impl.AskUseCase;
import org.sabio.sabioapp.helpers.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public class AskPresenter implements AskContract.UserActionListener {

    private AskContract.View view;
    private IAskUseCase askUseCase;
    private List<Country> lstCountries;
    private List<League> lstLeagues;
    private List<Team> lstTeams;

    public AskPresenter(AskContract.View view) {
        this.view = view;
        this.askUseCase = new AskUseCase();
        this.lstCountries = new ArrayList<>(0);
        this.lstLeagues = new ArrayList<>(0);
        this.lstTeams = new ArrayList<>(0);
    }

    @Override
    public void loadCountries() {

        askUseCase.loadCountries(new Callback<List<Country>>() {
            @Override
            public void success(List<Country> result) {
                lstCountries.clear();
                lstCountries.addAll(result);
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });

    }

    @Override
    public List<Country> getCountries() {
        return lstCountries;
    }

    @Override
    public void loadLeague(String countryCode) {
        askUseCase.loadLeague(countryCode, new Callback<List<League>>() {
            @Override
            public void success(List<League> result) {
                lstLeagues.clear();
                lstLeagues.addAll(result);
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }

    @Override
    public List<League> getLeagues() {
        return lstLeagues;
    }

    @Override
    public void loadTeam(String leagueCode) {
        askUseCase.loadTeam(leagueCode, new Callback<List<Team>>() {
            @Override
            public void success(List<Team> result) {
                lstTeams.clear();
                lstTeams.addAll(result);
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }

    @Override
    public List<Team> getTeams() {
        return lstTeams;
    }

    @Override
    public void askToSabio() {

    }
}