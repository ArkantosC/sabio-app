package org.sabio.sabioapp.repository.impl;

import android.util.Log;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.helpers.RetrofitSingleton;
import org.sabio.sabioapp.repository.ICountryRepository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by diegocortes on 12/18/17.
 */

public class CountryRestRepository implements ICountryRepository {

    public interface CountryService {

        @PUT("countries/{id}.json")
        Call<Country> insert(@Path("id") Long id, @Body Country country);

        @PATCH("countries/{id}.json")
        Call<Country> update(@Path("id") Long id, @Body Country country);

        @DELETE("countries/{id}.json")
        Call<Country> delete(@Path("id") Long id);

        @GET("countries.json")
        Call<List<Country>> getAll();
    }


    @Override
    public Long insert(Object entity) {
        try {
            Country country = (Country) entity;

            List<Country> countries = getAll();
            Long size = 0L;
            if (countries != null) {
                size = Long.parseLong(String.valueOf(countries.size()));
            }
            country.setId(size);

            Retrofit retrofit = RetrofitSingleton.getInstance();
            CountryService service = retrofit.create(CountryService.class);
            Call<Country> call = service.insert(country.getId(), country);
            Response<Country> response = call.execute();

            return country.getId();

        } catch (IOException e) {
            Log.d(CountryRestRepository.class.toString(), e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public List<Country> getAll() {
        try {
            Retrofit retrofit = RetrofitSingleton.getInstance();
            CountryService service = retrofit.create(CountryService.class);
            Call<List<Country>> call = service.getAll();

            Response<List<Country>> response = call.execute();
            return response.body();

        } catch (IOException e) {
            Log.d(CountryRestRepository.class.toString(), e.getMessage());
        }
        return null;
    }

    @Override
    public List getById(Long id) {
        return null;
    }
}
