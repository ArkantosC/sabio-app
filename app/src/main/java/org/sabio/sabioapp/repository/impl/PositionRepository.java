package org.sabio.sabioapp.repository.impl;

import android.util.Log;

import org.sabio.sabioapp.domain.model.Position;
import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.helpers.RetrofitSingleton;
import org.sabio.sabioapp.repository.IBaseRepository;

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
 * Created by diegocortes on 12/21/17.
 */

public class PositionRepository implements IBaseRepository {

    public interface PositionService {


        @PUT("positions/{id}.json")
        Call<Position> insert(@Path("id") Long id, @Body Position position);

        @PATCH("positions/{id}.json")
        Call<Position> update(@Path("id") Long id, @Body Position position);

        @DELETE("positions/{id}.json")
        Call<Position> delete(@Path("id") Long id);

        @GET("positions.json")
        Call<List<Position>> getAll();

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
            PositionService service = retrofit.create(PositionService.class);
            Call<List<Position>> call = service.getAll();
            Response<List<Position>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            Log.d(TriviaRepository.class.toString(), e.getMessage());
        }
        return null;
    }

    @Override
    public List getById(Long id) {
        return null;
    }
}
