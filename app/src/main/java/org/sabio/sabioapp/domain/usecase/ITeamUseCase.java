package org.sabio.sabioapp.domain.usecase;

import android.telecom.Call;

import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by diegocortes on 12/16/17.
 */

public interface ITeamUseCase {

    void insert(Team team, Callback<Team> callback);
    void update(Team team, Callback<Team> callback);
    void delete(Team team, Callback<Boolean> callback);
    void getAll(Callback<List<Team>> callback);
    void getById(Long id, Callback<List<Team>> callback);
    void getByLeague(String league, Callback<List<Team>> callback);
}
