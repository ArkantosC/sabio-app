package org.sabio.sabioapp.domain.usecase;

import org.sabio.sabioapp.domain.model.Position;
import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by diegocortes on 12/21/17.
 */

public interface IPositionUseCase {

    void getAll(Callback<List<Position>> callback);
}
