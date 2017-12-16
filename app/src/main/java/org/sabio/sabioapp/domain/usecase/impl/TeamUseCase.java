package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.ITeamUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.ITeamRepository;
import org.sabio.sabioapp.repository.impl.TeamLocalRepository;

import java.util.List;

import javax.xml.transform.sax.TemplatesHandler;

/**
 * Created by diegocortes on 12/16/17.
 */

public class TeamUseCase implements ITeamUseCase {

    @Override
    public void insert(final Team team, final Callback<Team> callback) {

        new ThreadExecutor<Team>(new ThreadExecutor.Task<Team>() {
            @Override
            public Team execute() throws Exception {

                ITeamRepository teamRepository = new TeamLocalRepository();
                Long id = teamRepository.insert(team);
                team.setId(id);
                return team;
            }

            @Override
            public void finish(Exception error, Team result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void update(final Team team, final Callback<Team> callback) {

        new ThreadExecutor<Team>(new ThreadExecutor.Task<Team>() {
            @Override
            public Team execute() throws Exception {

                ITeamRepository teamRepository = new TeamLocalRepository();
                teamRepository.update(team);
                return team;
            }

            @Override
            public void finish(Exception error, Team result) {
                if (null != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });
    }

    @Override
    public void delete(final Team team, final Callback<Boolean> callback) {

        new ThreadExecutor<Boolean>(new ThreadExecutor.Task<Boolean>() {
            @Override
            public Boolean execute() throws Exception {

                ITeamRepository teamRepository = new TeamLocalRepository();
                teamRepository.delete(team);
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
    public void getAll(final Callback<List<Team>> callback) {

        new ThreadExecutor<List<Team>>(new ThreadExecutor.Task<List<Team>>() {
            @Override
            public List<Team> execute() throws Exception {

                ITeamRepository teamRepository = new TeamLocalRepository();
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
        });

    }

    @Override
    public void getById(final Long id, final Callback<List<Team>> callback) {

        new ThreadExecutor<List<Team>>(new ThreadExecutor.Task<List<Team>>() {
            @Override
            public List<Team> execute() throws Exception {

                ITeamRepository teamRepository = new TeamLocalRepository();
                return teamRepository.getById(id);
            }

            @Override
            public void finish(Exception error, List<Team> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void getByLeague(final Long leagueId, final Callback<List<Team>> callback) {

        new ThreadExecutor<List<Team>>(new ThreadExecutor.Task<List<Team>>() {
            @Override
            public List<Team> execute() throws Exception {

                ITeamRepository teamRepository = new TeamLocalRepository();
                return teamRepository.getByLeague(leagueId);
            }

            @Override
            public void finish(Exception error, List<Team> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }
}
