package org.sabio.sabioapp.domain.usecase;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public interface IAskUseCase {

    List<Country> loadCountries();
    List<League> loadLeague(Long countryId);
    List<Team> loadTeam(Long leagueId);
    void askToSabio();

}
