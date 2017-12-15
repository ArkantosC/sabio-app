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
import org.sabio.sabioapp.repository.ICountryRepository;
import org.sabio.sabioapp.repository.ILeagueRepository;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public class CountryLocalRepository implements ICountryRepository {

    @Dao
    public interface CountryDao {

        @Insert
        Long insert(Country country);

        @Update
        void update(Country country);

        @Delete
        void delete(Country country);

        @Query("select * from Country")
        List<Country> getAll();

        @Query("select * from Country where country_id = :id")
        List<Country> getById(Long id);
    }

    @Override
    public Long insert(Object entity) {
        CountryLocalRepository.CountryDao sabioDao = SabioDatabase.getInstance().countryDao();
        return sabioDao.insert((Country)entity);
    }

    @Override
    public void update(Object entity) {
        CountryLocalRepository.CountryDao sabioDao = SabioDatabase.getInstance().countryDao();
        sabioDao.update((Country)entity);
    }

    @Override
    public void delete(Object entity) {
        CountryLocalRepository.CountryDao sabioDao = SabioDatabase.getInstance().countryDao();
        sabioDao.delete((Country)entity);
    }

    @Override
    public List<Country> getAll() {
        CountryDao sabioDao = SabioDatabase.getInstance().countryDao();
        return sabioDao.getAll();
    }

    @Override
    public List<Country> getById(Long id) {
        CountryDao sabioDao = SabioDatabase.getInstance().countryDao();
        return sabioDao.getById(id);
    }
}
