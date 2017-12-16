package org.sabio.sabioapp.repository;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public interface ILeagueRepository extends IBaseRepository {

    List<League> getByCountry(Long countryId);
}
