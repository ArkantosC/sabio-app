package org.sabio.sabioapp.repository.impl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.sabio.sabioapp.database.SabioDatabase;
import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.repository.ILeagueRepository;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public class LeagueLocalRepository implements ILeagueRepository {

    @Dao
    public interface LeagueDao {

        @Insert
        Long insert(League league);

        @Update
        void update(League league);

        @Delete
        void delete(League league);

        @Query("select * from League")
        List<League> getAll();

        @Query("select * from League where id = :id")
        List<League> getById(Long id);

        @Query("select * from League where countryId = :countryCode")
        List<League> getByCountry(String countryCode);
    }

    @Override
    public Long insert(Object entity) {
        LeagueLocalRepository.LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
        return sabioDao.insert((League)entity);
    }

    @Override
    public void update(Object entity) {
        LeagueLocalRepository.LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
        sabioDao.update((League)entity);
    }

    @Override
    public void delete(Object entity) {
        LeagueLocalRepository.LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
        sabioDao.delete((League)entity);
    }

    @Override
    public List getAll() {
        LeagueLocalRepository.LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
        return sabioDao.getAll();
    }

    @Override
    public List getById(Long id) {
        LeagueLocalRepository.LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
        return sabioDao.getById(id);
    }

    @Override
    public List<League> getByCountry(String country) {
        LeagueLocalRepository.LeagueDao sabioDao = SabioDatabase.getInstance().leagueDao();
        return sabioDao.getByCountry(country);
    }
}
