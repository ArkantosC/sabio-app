package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.domain.usecase.ITriviaUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.IBaseRepository;
import org.sabio.sabioapp.repository.impl.TriviaRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/20/17.
 */

public class TriviaRestUseCase implements ITriviaUseCase {

    private IBaseRepository<Trivia> triviaRepository;

    public TriviaRestUseCase() {
        this.triviaRepository = new TriviaRepository();
    }

    @Override
    public void getAll(final Callback<List<Trivia>> callback) {
        new ThreadExecutor<List<Trivia>>(new ThreadExecutor.Task<List<Trivia>>() {
            @Override
            public List<Trivia> execute() throws Exception {
                return triviaRepository.getAll();
            }

            @Override
            public void finish(Exception error, List<Trivia> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        }).execute();
    }
}
