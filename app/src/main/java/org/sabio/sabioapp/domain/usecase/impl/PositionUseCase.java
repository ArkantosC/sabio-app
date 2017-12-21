package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.Position;
import org.sabio.sabioapp.domain.usecase.IPositionUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.IBaseRepository;
import org.sabio.sabioapp.repository.impl.PositionRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/21/17.
 */

public class PositionUseCase implements IPositionUseCase {

    IBaseRepository<Position> positionRepository;

    public PositionUseCase() {
        this.positionRepository = new PositionRepository();
    }

    @Override
    public void getAll(final Callback<List<Position>> callback) {
        new ThreadExecutor<List<Position>>(new ThreadExecutor.Task<List<Position>>() {
            @Override
            public List<Position> execute() throws Exception {
                return positionRepository.getAll();
            }

            @Override
            public void finish(Exception error, List<Position> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        }).execute();
    }
}
