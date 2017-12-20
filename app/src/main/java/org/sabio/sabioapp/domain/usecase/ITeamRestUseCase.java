package org.sabio.sabioapp.domain.usecase;

import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by diegocortes on 12/19/17.
 */

public interface ITeamRestUseCase {

    void getAll(Callback<List<Team>> callback);
}
