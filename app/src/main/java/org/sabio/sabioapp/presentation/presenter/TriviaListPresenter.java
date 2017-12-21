package org.sabio.sabioapp.presentation.presenter;

import android.util.Log;

import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.ILeagueUseCase;
import org.sabio.sabioapp.domain.usecase.ITeamUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LeagueUseCase;
import org.sabio.sabioapp.domain.usecase.impl.TeamUseCase;
import org.sabio.sabioapp.domain.usecase.impl.TriviaRestUseCase;
import org.sabio.sabioapp.helpers.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diegocortes on 12/20/17.
 */

public class TriviaListPresenter implements TriviaListContract.UserActionListener {

    private TriviaListContract.View view;
    private TriviaRestUseCase triviaRestUseCase;
    private ITeamUseCase teamUseCase;
    private ILeagueUseCase leagueUseCase;
    private List<Trivia> lstTrivia;
    private List<Team> lstTeam;
    private League league;
    private boolean correct;

    public TriviaListPresenter(TriviaListContract.View view) {
        this.view = view;
        triviaRestUseCase = new TriviaRestUseCase();
        teamUseCase = new TeamUseCase();
        leagueUseCase = new LeagueUseCase();
        lstTrivia = new ArrayList<>(0);
        lstTeam = new ArrayList<>(0);
        correct = false;
    }

    @Override
    public void loadTriviaAll() {
        triviaRestUseCase.getAll(new Callback<List<Trivia>>() {
            @Override
            public void success(List<Trivia> result) {
                lstTrivia.clear();
                lstTrivia.addAll(result);
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }

    @Override
    public void loadTeamByLeague(String code) {
        teamUseCase.getByLeague(code, new Callback<List<Team>>() {
            @Override
            public void success(List<Team> result) {
                lstTeam.clear();
                lstTeam.addAll(result);
            }

            @Override
            public void error(Exception error) {

            }
        });
    }

    @Override
    public void loadLeague(String code) {
        leagueUseCase.getByLeague(code, new Callback<League>() {
            @Override
            public void success(League result) {
                league = result;
            }

            @Override
            public void error(Exception error) {

            }
        });
    }

    @Override
    public void nextQuestion() {
        lstTrivia.remove(0); // removed the first element of list.
    }

    @Override
    public List<Trivia> getListTrivia() {
        return lstTrivia;
    }

    @Override
    public List<Team> getListTeam() {
        return lstTeam;
    }

    @Override
    public League league() {
        return league;
    }

    @Override
    public boolean isCorrect() {
        return correct;
    }

    @Override
    public void updateStatusTodo(int position, boolean selected) {

        if (selected) {
            Team team = lstTeam.get(position);
            if (lstTrivia.get(0).getRespuesta().equals(team.getCode())) {
                correct = true;
            } else {
                correct = false;
            }
        }
        view.refreshTrivia();
    }
}
