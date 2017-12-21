package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public interface AskContract {

    interface View {
        void goToResultTable();
        void showMessageError(Exception error);
    }

    interface UserActionListener {

        void loadCountries();
        List<Country> getCountries();

        void loadLeague(String countryCode);
        List<League> getLeagues();

        void loadTeam(String leagueCode);
        List<Team> getTeams();

        void askToSabio();
    }
}
