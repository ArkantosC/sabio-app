package org.sabio.sabioapp.presentation.presenter;

import android.util.Log;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.ICountryRestUseCase;
import org.sabio.sabioapp.domain.usecase.ICountryUseCase;
import org.sabio.sabioapp.domain.usecase.ILeagueRestUseCase;
import org.sabio.sabioapp.domain.usecase.ILeagueUseCase;
import org.sabio.sabioapp.domain.usecase.ITeamRestUseCase;
import org.sabio.sabioapp.domain.usecase.ITeamUseCase;
import org.sabio.sabioapp.domain.usecase.impl.CountryRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.CountryUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LeagueRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.LeagueUseCase;
import org.sabio.sabioapp.domain.usecase.impl.TeamRestUseCase;
import org.sabio.sabioapp.domain.usecase.impl.TeamUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.repository.ICountryRepository;
import org.sabio.sabioapp.repository.impl.CountryLocalRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/18/17.
 */

public class StartPresenter implements StartContract.UserActionListener {

    private StartContract.View view;


    public StartPresenter(StartContract.View view) {
        this.view = view;
    }

}
