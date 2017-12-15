package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.IAskUseCase;
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

    @Override
    public List<Country> loadCountries() {
        ICountryRepository countrySabioRepository = new CountryLocalRepository();
        return countrySabioRepository.getAll();
    }

    @Override
    public List<League> loadLeague(Long countryId) {
        ILeagueRepository leagueRepository = new LeagueLocalRepository();
        return leagueRepository.getById(countryId);
    }

    @Override
    public List<Team> loadTeam(Long leagueId) {
        ITeamRepository teamRepository = new TeamLocalRepository();
        return teamRepository.getById(leagueId);
    }

    @Override
    public void askToSabio() {
        // Invokes the web services.
    }
}
