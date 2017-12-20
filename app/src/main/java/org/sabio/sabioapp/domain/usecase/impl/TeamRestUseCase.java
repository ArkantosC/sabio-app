package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.ITeamRestUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.ITeamRepository;
import org.sabio.sabioapp.repository.impl.TeamRestRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/19/17.
 */

public class TeamRestUseCase implements ITeamRestUseCase {

    private ITeamRepository teamRepository;

    public TeamRestUseCase() {
        this.teamRepository = new TeamRestRepository();
    }

    @Override
    public void getAll(final Callback<List<Team>> callback) {

        new ThreadExecutor<List<Team>>(new ThreadExecutor.Task<List<Team>>() {
            @Override
            public List<Team> execute() throws Exception {
                return teamRepository.getAll();
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
}
