package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.usecase.ILeagueRestUseCase;
import org.sabio.sabioapp.domain.usecase.ILeagueUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.ILeagueRepository;
import org.sabio.sabioapp.repository.impl.LeagueRestRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/19/17.
 */

public class LeagueRestUseCase implements ILeagueRestUseCase {

    private ILeagueRepository leagueRepository;

    public LeagueRestUseCase() {
        leagueRepository = new LeagueRestRepository();
    }

    @Override
    public void getAll(final Callback<List<League>> callback) {

        new ThreadExecutor<List<League>>(new ThreadExecutor.Task<List<League>>() {
            @Override
            public List<League> execute() throws Exception {
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
        }).execute();
    }
}
