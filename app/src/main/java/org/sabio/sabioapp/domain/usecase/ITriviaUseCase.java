package org.sabio.sabioapp.domain.usecase;

import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by diegocortes on 12/20/17.
 */

public interface ITriviaUseCase {

    void getAll(Callback<List<Trivia>> callback);

}
