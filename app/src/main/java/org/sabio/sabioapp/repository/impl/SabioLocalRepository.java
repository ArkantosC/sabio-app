package org.sabio.sabioapp.repository.impl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import org.sabio.sabioapp.database.SabioDatabase;
import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.repository.ISabioRepository;

/**
 * Created by diegocortes on 12/14/17.
 */

public class SabioLocalRepository implements ISabioRepository {

    @Dao
    public interface CountryDao {

        @Insert
        Long insert(Country country);

        @Update
        void update(Country country);

        @Delete
        void delete(Country country);

    }


    @Dao
    public interface LeagueDao {

        @Insert
        Long insert(League league);

        @Update
        void update(League league);

        @Delete
        void delete(League league);

    }

    @Dao
    public interface TeamDao {

        @Insert
        Long insert(Team team);

        @Update
        void update(Team team);

        @Delete
        void delete(Team team);

    }

    @Override
    public Long insert(Object entity) {

        if (entity instanceof Country) {
            CountryDao sabioDao = SabioDatabase.getInstance().countryDao();
            return sabioDao.insert((Country)entity);
        }


        if (entity instanceof League) {
            LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
            return sabioDao.insert((League)entity);
        }

        if (entity instanceof Team) {
            TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
            return sabioDao.insert((Team)entity);
        }

        return -1L;
    }

    @Override
    public void update(Object entity) {

        if (entity instanceof Country) {
            CountryDao sabioDao = SabioDatabase.getInstance().countryDao();
            sabioDao.update((Country)entity);
        }

        if (entity instanceof League) {
            LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
            sabioDao.update((League)entity);
        }

        if (entity instanceof Team) {
            TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
            sabioDao.update((Team)entity);
        }
    }

    @Override
    public void delete(Object entity) {

        if (entity instanceof Country) {
            CountryDao sabioDao = SabioDatabase.getInstance().countryDao();
            sabioDao.delete((Country)entity);
        }

        if (entity instanceof League) {
            LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
            sabioDao.delete((League)entity);
        }

        if (entity instanceof Team) {
            TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
            sabioDao.delete((Team)entity);
        }
    }
}
