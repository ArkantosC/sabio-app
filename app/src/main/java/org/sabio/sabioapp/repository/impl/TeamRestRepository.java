package org.sabio.sabioapp.repository.impl;

import android.util.Log;

import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.helpers.RetrofitSingleton;
import org.sabio.sabioapp.repository.ITeamRepository;

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

public class TeamRestRepository implements ITeamRepository {

    public interface TeamService {

        @PUT("teams/{id}.json")
        Call<Team> insert(@Path("id") Long id, @Body Team team);

        @PATCH("teams/{id}.json")
        Call<Team> update(@Path("id") Long id, @Body Team team);

        @DELETE("teams/{id}.json")
        Call<Team> delete(@Path("id") Long id);

        @GET("teams.json")
        Call<List<Team>> getAll();
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
            TeamService service = retrofit.create(TeamService.class);
            Call<List<Team>> call = service.getAll();
            Response<List<Team>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            Log.d(TeamRestRepository.class.toString(), e.getMessage());
        }
        return null;
    }

    @Override
    public List getById(Long id) {
        return null;
    }

    @Override
    public List<Team> getByLeague(String league) {
        return null;
    }
}
