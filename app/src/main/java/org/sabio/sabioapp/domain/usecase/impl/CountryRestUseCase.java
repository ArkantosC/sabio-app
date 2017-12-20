package org.sabio.sabioapp.domain.usecase.impl;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.usecase.ICountryRestUseCase;
import org.sabio.sabioapp.helpers.Callback;
import org.sabio.sabioapp.helpers.ThreadExecutor;
import org.sabio.sabioapp.repository.ICountryRepository;
import org.sabio.sabioapp.repository.impl.CountryRestRepository;

import java.util.List;

/**
 * Created by diegocortes on 12/18/17.
 */

public class CountryRestUseCase implements ICountryRestUseCase {

    private ICountryRepository countryRepository;

    public CountryRestUseCase() {
        this.countryRepository = new CountryRestRepository();
    }

    @Override
    public void insert(final Country country, final Callback<Country> callback) {

        new ThreadExecutor<Country>(new ThreadExecutor.Task<Country>() {
            @Override
            public Country execute() throws Exception {
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
        }).execute();

    }

    @Override
    public void getAll(final Callback<List<Country>> callback) {

        new ThreadExecutor<List<Country>>(new ThreadExecutor.Task<List<Country>>() {
            @Override
            public List<Country> execute() throws Exception {
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
        }).execute();
    }
}
