package org.sabio.sabioapp.presentation.presenter;

import android.util.Log;

import org.sabio.sabioapp.Utils.Constant;
import org.sabio.sabioapp.domain.model.User;
import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.ICountryRestUseCase;
import org.sabio.sabioapp.domain.usecase.ICountryUseCase;
import org.sabio.sabioapp.domain.usecase.ILeagueRestUseCase;
import org.sabio.sabioapp.domain.usecase.ILeagueUseCase;
import org.sabio.sabioapp.domain.usecase.ILocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.ITeamRestUseCase;
import org.sabio.sabioapp.domain.usecase.ITeamUseCase;
import org.sabio.sabioapp.domain.usecase.impl.CountryRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.CountryUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LeagueRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LeagueUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LocalDataUseCase;
import org.sabio.sabioapp.domain.usecase.impl.TeamRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.TeamUseCase;
import org.sabio.sabioapp.domain.usecase.impl.UserUseCase;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by diegocortes on 12/17/17.
 */

public class LoginPresenter implements LoginContract.UserActionListener {

    private LoginContract.View view;
    private ILocalDataUseCase localDataUseCase;
    private UserUseCase userUseCase;


    private ICountryRestUseCase countryRestUseCase;
    private ILeagueRestUseCase leagueRestUseCase;
    private ITeamRestUseCase teamRestUseCase;

    private ICountryUseCase countryUseCase;
    private ILeagueUseCase leagueUseCase;
    private ITeamUseCase teamUseCase;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();
        this.userUseCase = new UserUseCase();

        this.countryRestUseCase = new CountryRestUseCase();
        this.leagueRestUseCase = new LeagueRestUseCase();
        this.teamRestUseCase = new TeamRestUseCase();

        this.countryUseCase = new CountryUseCase();
        this.leagueUseCase = new LeagueUseCase();
        this.teamUseCase = new TeamUseCase();

    }

    @Override
    public void onLogin(final String email, String password, final boolean remember) {
        view.showProgress();
        userUseCase.login(email, password, remember, new Callback<User>() {
            @Override
            public void success(User result) {
                view.hidePRogress();
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.hidePRogress();
                view.showMessageError(error);
            }
        });
    }


    @Override
    public void loadCountries() {
        countryRestUseCase.getAll(new Callback<List<Country>>() {
            @Override
            public void success(List<Country> result) {
                for (Country country : result)
                {
                    countryUseCase.insert(country, new Callback<Country>() {
                        @Override
                        public void success(Country result) {
                            Log.d(StartPresenter.class.toString(), "Country was saved: " + result.getName());
                        }

                        @Override
                        public void error(Exception error) {
                            view.showMessageError(error);
                        }
                    });
                }
            }
            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }

    @Override
    public void loadLeagues() {
        leagueRestUseCase.getAll(new Callback<List<League>>() {
            @Override
            public void success(List<League> result) {
                for (League league : result) {
                    leagueUseCase.insert(league, new Callback<League>() {
                        @Override
                        public void success(League result) {
                            Log.d(StartPresenter.class.toString(), "League was saved: " + result.getName());
                        }

                        @Override
                        public void error(Exception error) {
                            view.showMessageError(error);
                        }
                    });
                }
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }

    @Override
    public void loadTeams() {
        teamRestUseCase.getAll(new Callback<List<Team>>() {
            @Override
            public void success(List<Team> result) {
                for (Team team : result) {

                    teamUseCase.insert(team, new Callback<Team>() {
                        @Override
                        public void success(Team result) {
                            Log.d(StartPresenter.class.toString(), "Team was saved:" + result.getName());
                        }

                        @Override
                        public void error(Exception error) {
                            view.showMessageError(error);
                        }
                    });
                }
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }


    @Override
    public void configure() {

        try {

            String email = localDataUseCase.getData(Constant.SHARED_PREF_EMAIL, String.class);
            if (email != null) {
                view.showRememberedUser(email);
            }
        }catch (Exception ex){
            view.showMessageError(ex);
        }
    }
}
