package org.sabio.sabioapp.domain.usecase;

import android.telecom.Call;

import org.sabio.sabioapp.helpers.Callback;

/**
 * Created by diegocortes on 12/18/17.
 */

public interface SetupDataUseCase {

    void deleteCountries(Callback<Boolean> callback);
    void deleteLeagues(Callback<Boolean> callback);
    void deleteTeams(Callback<Boolean> callback);
    void setupCountries(Callback<Boolean> callback);
    void setupLeagues(Callback<Boolean> callback);
    void setupTeams(Callback<Boolean> callback);

}
