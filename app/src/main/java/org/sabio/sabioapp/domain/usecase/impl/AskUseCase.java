package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.IAskUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.ICountryRepository;
import org.sabio.sabioapp.repository.ILeagueRepository;
import org.sabio.sabioapp.repository.ITeamRepository;
import org.sabio.sabioapp.repository.impl.CountryLocalRepository;
import org.sabio.sabioapp.repository.impl.LeagueLocalRepository;
import org.sabio.sabioapp.repository.impl.TeamLocalRepository;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public class AskUseCase implements IAskUseCase {

    private ICountryRepository countrySabioRepository;
    private ILeagueRepository leagueRepository;
    private ITeamRepository teamRepository;

    public AskUseCase() {

        this.countrySabioRepository = new CountryLocalRepository();
        this.leagueRepository = new LeagueLocalRepository();
        this.teamRepository = new TeamLocalRepository();

    }

    @Override
    public void loadCountries(final Callback<List<Country>> callback) {

        new ThreadExecutor<List<Country>>(new ThreadExecutor.Task<List<Country>>() {
            @Override
            public List<Country> execute() throws Exception {

                return countrySabioRepository.getAll();
            }

            @Override
            public void finish(Exception error, List<Country> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        }).execute();
    }

    @Override
    public void loadLeague(final String countryCode, final Callback<List<League>> callback) {

        new ThreadExecutor<List<League>>(new ThreadExecutor.Task<List<League>>() {
            @Override
            public List<League> execute() throws Exception {
                return leagueRepository.getByCountry(countryCode);
            }

            @Override
            public void finish(Exception error, List<League> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        }).execute();
    }

    @Override
    public void loadTeam(final String leagueCode, final Callback<List<Team>> callback) {

        new ThreadExecutor<List<Team>>(new ThreadExecutor.Task<List<Team>>() {
            @Override
            public List<Team> execute() throws Exception {

                return teamRepository.getByLeague(leagueCode);
            }

            @Override
            public void finish(Exception error, List<Team> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        }).execute();

    }

    @Override
    public void askToSabio() {
        // Invokes the web services.
    }
}
