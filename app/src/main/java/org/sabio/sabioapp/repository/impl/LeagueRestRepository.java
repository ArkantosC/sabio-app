package org.sabio.sabioapp.repository.impl;

import android.util.Log;

import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.helpers.RetrofitSingleton;
import org.sabio.sabioapp.repository.ILeagueRepository;

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
 * Created by diegocortes on 12/19/17.
 */
public class LeagueRestRepository implements ILeagueRepository {


    public interface LeagueService {

        @PUT("leagues/{id}.json")
        Call<League> insert(@Path("id") Long id, @Body League league);

        @PATCH("leagues/{id}.json")
        Call<League> update(@Path("id") Long id, @Body League league);

        @DELETE("leagues/{id}.json")
        Call<League> delete(@Path("id") Long id);

        @GET("leagues.json")
        Call<List<League>> getAll();

    }

    @Override
    public Long insert(Object entity) {
        return null;
    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public List getAll() {
        try {
            Retrofit retrofit = RetrofitSingleton.getInstance();
            LeagueService service = retrofit.create(LeagueService.class);
            Call<List<League>> call = service.getAll();
            Response<List<League>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            Log.d(LeagueRestRepository.class.toString(), e.getMessage());
        }
        return null;
    }

    @Override
    public List getById(Long id) {
        return null;
    }

    @Override
    public List<League> getByCountry(String country) {
        return null;
    }

    @Override
    public League getLeagueByCode(String code) {
        return null;
    }
}
