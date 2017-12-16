package org.sabio.sabioapp.presentation.presenter;

/**
 * Created by dcortez on 12/15/2017.
 */

public interface AskContract {

    interface View {
        void goToResultTable();
        void goToQualificationTable();
        void showMessageError(Exception error);
    }

    interface UserActionListener {

        void selectCountry();
        void selectLeague();
        void selectTeam();

        void loadCountries();
        void loadLeague(int countryId);
        void loadTeam(int leagueId);

        void askToSabio();
    }
}
