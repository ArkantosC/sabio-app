package org.sabio.sabioapp.domain.usecase;

import android.telecom.Call;

import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by diegocortes on 12/15/17.
 */

public interface ILeagueUseCase {
    void insert(League league, Callback<League> callback);
    void update(League league, Callback<League> callback);
    void delete(League league, Callback<Boolean> callback);
    void getAll(Callback<List<League>> callback);
    void getById(Long id, Callback<List<League>> callback);
    void getByCountry(String country, Callback<List<League>> callback);
}
