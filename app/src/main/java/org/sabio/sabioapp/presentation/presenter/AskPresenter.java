package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by dcortez on 12/15/2017.
 */

public class AskPresenter implements AskContract.UserActionListener {

    private AskContract.View view;

    public AskPresenter(AskContract.View view) {
        this.view = view;
    }

    @Override
    public void selectCountry() {

    }

    @Override
    public void selectLeague() {

    }

    @Override
    public void selectTeam() {

    }

    @Override
    public void loadCountries() {

    }

    @Override
    public void loadLeague(int countryId) {

    }

    @Override
    public void loadTeam(int leagueId) {

    }

    @Override
    public void askToSabio() {

    }
}