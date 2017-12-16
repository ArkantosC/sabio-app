package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.usecase.ICountryUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.ICountryRepository;
import org.sabio.sabioapp.repository.impl.CountryLocalRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/15/17.
 */

public class CountryUseCase implements ICountryUseCase {

    @Override
    public void insert(final Country country, final Callback<Country> callback) {

        new ThreadExecutor<Country>(new ThreadExecutor.Task<Country>() {
            @Override
            public Country execute() throws Exception {
                ICountryRepository countryRepository = new CountryLocalRepository();
                Long id = countryRepository.insert(country);
                country.setId(id);
                return country;
            }

            @Override
            public void finish(Exception error, Country result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void update(final Country country, final Callback<Country> callback) {

        new ThreadExecutor<Country>(new ThreadExecutor.Task<Country>() {
            @Override
            public Country execute() throws Exception {

                ICountryRepository countryRepository = new CountryLocalRepository();
                countryRepository.update(country);
                return country;

            }

            @Override
            public void finish(Exception error, Country result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void delete(final Country country, final Callback<Boolean> callback) {

        new ThreadExecutor<Boolean>(new ThreadExecutor.Task<Boolean>() {
            @Override
            public Boolean execute() throws Exception {

                ICountryRepository countryRepository = new CountryLocalRepository();
                countryRepository.delete(country);
                return true;
            }

            @Override
            public void finish(Exception error, Boolean result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void getAll(final Callback<List<Country>> callback) {

        new ThreadExecutor<List<Country>>(new ThreadExecutor.Task<List<Country>>() {
            @Override
            public List<Country> execute() throws Exception {

                ICountryRepository countryRepository = new CountryLocalRepository();
                return countryRepository.getAll();
            }

            @Override
            public void finish(Exception error, List<Country> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }

    @Override
    public void getById(final Long id, final Callback<List<Country>> callback) {

        new ThreadExecutor<List<Country>>(new ThreadExecutor.Task<List<Country>>() {
            @Override
            public List<Country> execute() throws Exception {

                ICountryRepository countryRepository = new CountryLocalRepository();
                return countryRepository.getById(id);
            }

            @Override
            public void finish(Exception error, List<Country> result) {
                if (error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        });

    }
}
