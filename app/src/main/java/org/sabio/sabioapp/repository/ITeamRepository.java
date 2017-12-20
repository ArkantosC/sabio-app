package org.sabio.sabioapp.repository;

import org.sabio.sabioapp.domain.model.entities.Team;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public interface ITeamRepository extends IBaseRepository {

    List<Team> getByLeague(String league);
}
