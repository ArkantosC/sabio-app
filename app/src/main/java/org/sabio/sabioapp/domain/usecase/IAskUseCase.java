package org.sabio.sabioapp.domain.usecase;

import android.telecom.Call;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public interface IAskUseCase {

    void loadCountries(Callback<List<Country>> callback);
    void loadLeague(String countryCode, Callback<List<League>> callback);
    void loadTeam(String leagueCode, Callback<List<Team>> callback);
    void askToSabio();

}
