package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;

import java.util.List;

/**
 * Created by diegocortes on 12/20/17.
 */

public interface TriviaListContract {

    interface View extends BaseView {

        void refreshTrivia();

    }

    interface UserActionListener {

        void loadTriviaAll();

        void loadTeamByLeague(String code);

        void loadLeague(String code);

        void nextQuestion();

        List<Trivia> getListTrivia();

        List<Team> getListTeam();

        League league();

        boolean isCorrect();

        void updateStatusTodo(int position, boolean selected);
    }
}
