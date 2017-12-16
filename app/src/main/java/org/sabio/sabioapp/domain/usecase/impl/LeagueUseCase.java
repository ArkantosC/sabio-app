package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.usecase.ILeagueUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.ILeagueRepository;
import org.sabio.sabioapp.repository.impl.LeagueLocalRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/16/17.
 */

public class LeagueUseCase implements ILeagueUseCase {

    @Override
    public void insert(final League league, final Callback<League> callback) {

        new ThreadExecutor<League>(new ThreadExecutor.Task<League>() {
            @Override
            public League execute() throws Exception {

                ILeagueRepository leagueRepository = new LeagueLocalRepository();
                Long id = leagueRepository.insert(league);
                league.setId(id);
                return league;
            }

            @Override
            public void finish(Exception error, League result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void update(final League league, final Callback<League> callback) {

        new ThreadExecutor<League>(new ThreadExecutor.Task<League>() {
            @Override
            public League execute() throws Exception {

                ILeagueRepository leagueRepository = new LeagueLocalRepository();
                leagueRepository.update(league);
                return league;
            }

            @Override
            public void finish(Exception error, League result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void delete(final League league, final Callback<Boolean> callback) {

        new ThreadExecutor<Boolean>(new ThreadExecutor.Task<Boolean>() {
            @Override
            public Boolean execute() throws Exception {

                ILeagueRepository leagueRepository = new LeagueLocalRepository();
                leagueRepository.delete(league);
                return true;
            }

            @Override
            public void finish(Exception error, Boolean result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void getAll(final Callback<List<League>> callback) {

        new ThreadExecutor<List<League>>(new ThreadExecutor.Task<List<League>>() {
            @Override
            public List<League> execute() throws Exception {

                ILeagueRepository leagueRepository = new LeagueLocalRepository();
                return leagueRepository.getAll();
            }

            @Override
            public void finish(Exception error, List<League> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });
    }

    @Override
    public void getById(final Long id, final Callback<List<League>> callback) {

        new ThreadExecutor<List<League>>(new ThreadExecutor.Task<List<League>>() {
            @Override
            public List<League> execute() throws Exception {

                ILeagueRepository leagueRepository = new LeagueLocalRepository();
                return leagueRepository.getById(id);
            }

            @Override
            public void finish(Exception error, List<League> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });
    }

    @Override
    public void getByCountry(final Long countryId, final Callback<List<League>> callback) {

        new ThreadExecutor<List<League>>(new ThreadExecutor.Task<List<League>>() {
            @Override
            public List<League> execute() throws Exception {

                ILeagueRepository leagueRepository = new LeagueLocalRepository();
                return leagueRepository.getByCountry(countryId);
            }

            @Override
            public void finish(Exception error, List<League> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });
    }
}
