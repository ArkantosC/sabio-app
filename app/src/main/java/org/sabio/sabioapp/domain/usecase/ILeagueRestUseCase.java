package org.sabio.sabioapp.domain.usecase;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

import retrofit2.Response;

/**
 * Created by diegocortes on 12/19/17.
 */

public interface ILeagueRestUseCase {
    void getAll(Callback<List<League>> callback);
}
