package org.sabio.sabioapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sabio.sabioapp.database.SabioDatabase;
import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.domain.usecase.impl.AskUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.repository.ICountryRepository;
import org.sabio.sabioapp.repository.ILeagueRepository;
import org.sabio.sabioapp.repository.ITeamRepository;
import org.sabio.sabioapp.repository.impl.CountryLocalRepository;
import org.sabio.sabioapp.repository.impl.LeagueLocalRepository;
import org.sabio.sabioapp.repository.impl.TeamLocalRepository;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by dcortez on 12/15/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AskUseCaseTest {

    private AskUseCase askUseCase;
    private SabioDatabase db;

    @Before
    public void setUp() {
        askUseCase = new AskUseCase();
        supplyData();
    }

    @After
    public void tearDown() {
        askUseCase = null;
        db = null;
    }

    @Test
    public void testLoadCountries() {

        askUseCase.loadCountries(new Callback<List<Country>>() {
            @Override
            public void success(List<Country> result) {
                assertNotNull("The result is null", result);
                assertTrue("The countries must not be empty", result.size() > 0);
                assertTrue("The country id is not valid", result.get(0).getId() > 0);
                assertFalse("The country name is not valid", result.get(0).getName().isEmpty());
            }

            @Override
            public void error(Exception error) {
                assertTrue("An exception has occurred",false);
            }
        });

    }

    @Test
    public void testLoadLeague() {

        askUseCase.loadLeague(1L, new Callback<List<League>>() {
            @Override
            public void success(List<League> result) {
                assertNotNull("The result is null", result);
                assertTrue("The league must not be empty", result.size() > 0);
                assertTrue("The league id is not valid", result.get(0).getId() > 0);
                assertFalse("The league name is not valid", result.get(0).getName().isEmpty());
            }

            @Override
            public void error(Exception error) {
                assertTrue("An exception has occurred",false);
            }
        });
    }

    @Test
    public void testLoadTeam() {

        askUseCase.loadTeam(2L, new Callback<List<Team>>() {
            @Override
            public void success(List<Team> result) {
                assertNotNull("The result is null" + result);
                assertTrue("The teams must not be empty", result.size() > 0);
                assertTrue("The team is is not valid", result.get(0).getId() > 0);
                assertFalse("The team name is not valid", result.get(0).getName().isEmpty());
            }

            @Override
            public void error(Exception error) {
                assertTrue("An exception has occurred",false);
            }
        });
    }

    private void supplyData() {

        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, SabioDatabase.class).build();

        SabioDatabase.setInjectedInstance(db);

        ICountryRepository countrySabioRepository = new CountryLocalRepository();

        Long idColombia = countrySabioRepository.insert(new Country("Colombia"));
        Long idEspana = countrySabioRepository.insert(new Country("España"));
        Long idInglaterra = countrySabioRepository.insert(new Country("Inglaterra"));

        ILeagueRepository leagueRepository = new LeagueLocalRepository();
        Long idLigaPostobon = leagueRepository.insert(new League("Liga Pastobon", idColombia));
        Long idCopaAguila = leagueRepository.insert(new League("Copa Aguila", idColombia));
        Long idLigaEspana = leagueRepository.insert(new League("Liga España", idEspana));
        Long idCopaRey = leagueRepository.insert(new League("Copa del Rey", idEspana));
        Long idPremier = leagueRepository.insert(new League("Premier League", idInglaterra));
        Long idFootbalChampionship = leagueRepository.insert(new League("Football League Championship", idInglaterra));

        ITeamRepository teamRepository = new TeamLocalRepository();
        teamRepository.insert(new Team("Atlético Nacional", idLigaPostobon));
        teamRepository.insert(new Team("Millonarios Fútbol Club", idLigaPostobon));
        teamRepository.insert(new Team("Independiente Santa Fe", idLigaPostobon));
        teamRepository.insert(new Team("Atlético Junior", idLigaPostobon));
        teamRepository.insert(new Team("Once Caldas", idLigaPostobon));

        teamRepository.insert(new Team("Barcelona", idLigaEspana));
        teamRepository.insert(new Team("Real Madrid", idLigaEspana));
        teamRepository.insert(new Team("Atlético de Madrid", idLigaEspana));
        teamRepository.insert(new Team("Valencia", idLigaEspana));
        teamRepository.insert(new Team("Sevilla", idLigaEspana));

        teamRepository.insert(new Team("Manchester United", idPremier));
        teamRepository.insert(new Team("Chelsea", idPremier));
        teamRepository.insert(new Team("Arsenal", idPremier));
        teamRepository.insert(new Team("Liverpool", idPremier));
        teamRepository.insert(new Team("Tottenham", idPremier));

    }
}
